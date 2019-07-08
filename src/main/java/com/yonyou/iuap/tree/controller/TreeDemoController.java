package com.yonyou.iuap.tree.controller;

import com.yonyou.iuap.base.web.BaseController;
import com.yonyou.iuap.mvc.type.JsonResponse;
import com.yonyou.iuap.tree.entity.TreeDemo;
import com.yonyou.iuap.tree.service.TreeDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 说明：树结构 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-10-30 16:13:30
 */
@Controller
@RequestMapping(value = "/tree_demo")
@Api(tags = "树表tree接口",description=" 树表table文档说明",hidden=true)
public class TreeDemoController extends BaseController {

	private static final String PARENTID = "parentId";
	private Logger logger = LoggerFactory.getLogger(TreeDemoController.class);
	private TreeDemoService treeDemoService;
	
	@Autowired
	public void setTreeDemoService(TreeDemoService treeDemoService) {
		this.treeDemoService = treeDemoService;
	}

	/**
	 * description:获取子节点数据list
	 * @param id
	 * @return
	 */
	@ApiOperation(value="查询树子节点数据",notes="查询树子节点数据接口说明")
	@ApiImplicitParam(name="id",value="查询数据id",dataType="String", paramType = "query")
	@ApiResponse(response = JsonResponse.class, code = 200, message = "success")
	@RequestMapping(value = "/getSonNodes",method=RequestMethod.GET)
	@ResponseBody
	public Object getSonNodes(String id) {
		Map<String, Object> map = new HashMap<>();
		if (!StringUtils.isEmpty(id)) {
			map.put(PARENTID, id);
		} else {
			map.put(PARENTID, "0");
		}
		List<TreeDemo> queryList = this.treeDemoService.queryList(map);
		map.clear();
		map.put("content", queryList);
		return this.buildSuccess("data", map);
	}

	/**
	 * 树模糊查询优化代码
	 * @param searchValue
	 * @return
	 */
	@ApiOperation(value="模糊查询树",notes="模糊查询树节点数据接口说明")
	@ApiImplicitParam(name="searchValue",value="查询数据",dataType="String", paramType = "query")
	@ApiResponse(response = JsonResponse.class, code = 200, message = "success")
	@RequestMapping(value = "/dataSearchNodes",method=RequestMethod.GET)
	@ResponseBody
	public Object dataSearchNodes(String searchValue){
		Map<String, Object> map = new HashMap<>();
		List< TreeDemo> queryList = new ArrayList<>();
		if (!StringUtils.isEmpty(searchValue)) {
			map = this.treeDemoService.dataSearch(searchValue);
		}else {
			map.put(PARENTID, "0");
			queryList = this.treeDemoService.queryList(map);
			map.clear();
			map.put("content", queryList);
		}
		return this.buildSuccess("data", map);
	}
}