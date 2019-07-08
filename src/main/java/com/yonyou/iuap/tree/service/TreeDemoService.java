package com.yonyou.iuap.tree.service;

import com.yonyou.iuap.baseservice.intg.service.GenericIntegrateService;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.tree.dao.TreeDemoMapper;
import com.yonyou.iuap.tree.entity.TreeDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Map.Entry;

import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

@Service

/**
 * TreeDemo CRUD 核心服务,提供逻辑删除/乐观锁
 */
public class TreeDemoService extends GenericIntegrateService<TreeDemo> {

	private TreeDemoMapper treeDemoMapper;

	@Autowired
	public void setTreeDemoMapper(TreeDemoMapper treeDemoMapper) {
		this.treeDemoMapper = treeDemoMapper;
		super.setGenericMapper(treeDemoMapper);
	}

	/**
	 * @CAU 可插拔设计
	 * @return 向父类 GenericIntegrateService 提供可插拔的特性声明
	 */
	@Override
	protected ServiceFeature[] getFeats() {
		return new ServiceFeature[] { REFERENCE, BPM, MULTI_TENANT, LOGICAL_DEL };
	}

	/**
	 * 构造树
	 * @param nodes
	 * @return
	 * TODO 封装并提供
	 */
	private List<TreeDemo> convertTreeDataNew(List<TreeDemo> nodes) {
		List<TreeDemo> treeDemos = new ArrayList<>();
		Map<String, TreeDemo> idMap = new HashMap<>(nodes.size()*4/3+1);
		Map<String, List<TreeDemo>> pidMap = new HashMap<>(nodes.size()*4/3+1);
		//构建基础数据
		for (TreeDemo treeDemo : nodes) {
			idMap.put(treeDemo.getId(), treeDemo);
			List<TreeDemo> list = pidMap.get(treeDemo.getParentId());
			if (list==null) {
				list=new ArrayList<>();
				pidMap.put(treeDemo.getParentId(), list);
			}
			list.add(treeDemo);
		}
		//组装树
		Set<Entry<String, List<TreeDemo>>> entrySet = pidMap.entrySet();
		for (Entry<String, List<TreeDemo>> entry : entrySet) {
			String pid = entry.getKey();
			TreeDemo treeDemo = idMap.get(pid);
			if (treeDemo!=null) {
				treeDemo.setChildren(entry.getValue());
			}
		}
		for (int i = 0; i < nodes.size(); i++) {
			if("0".equals(nodes.get(i).getParentId())){
				treeDemos.add(nodes.get(i));
			}
		}
		return treeDemos;
	}
	/**
	 * 根据模糊查询的结果 获取所有相关的分级code	
	 * @param treeDemos
	 * @return
	 */
	private List<String> getParentInnerCode(List<TreeDemo> treeDemos) {
		Set<String> set = new HashSet<>();
		// code每4位表示一级
		int level = 4;
		for (TreeDemo treeDemo : treeDemos){
			String code = treeDemo.getCode();
			for (int i = 1;i <= code.length() / level;i ++){
				String parentCode = code.substring(0, i * level);
				set.add(parentCode);
			}
		}
		List<String> codeList = new ArrayList<String>();
		for (String code : set){
			codeList.add(code);
		}
		return codeList;
	}
	
	public Map<String, Object> dataSearch(String searchValue) {
		Map<String, Object> map = new HashMap<>();
		
		SearchParams searchParams = new SearchParams();
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("name", searchValue);
		searchParams.setSearchMap(searchMap);
		List<TreeDemo> rtnVal = super.selectAllByPage(null, searchParams).getContent();
		if (rtnVal != null && !rtnVal.isEmpty()){
			searchMap.clear();
			searchMap.put("code", this.getParentInnerCode(rtnVal));
			rtnVal = super.selectAllByPage(null, searchParams).getContent();
			List<TreeDemo> convertTreeDataNew = this.convertTreeDataNew(rtnVal);
			Set<String> parentIdSet = new HashSet<>();
			for (TreeDemo treeDemo : rtnVal) {
				parentIdSet.add(treeDemo.getParentId());
				parentIdSet.remove(null);
			}
			map.put("content", convertTreeDataNew);
			map.put("parentIdSet", parentIdSet);
			return map;
		}
		return null;
	}
}