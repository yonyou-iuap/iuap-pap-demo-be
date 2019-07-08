package com.yonyou.iuap.model.service;

import com.yonyou.iuap.baseservice.intg.service.GenericIntegrateService;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import com.yonyou.iuap.baseservice.statistics.service.StatCommonService;
import com.yonyou.iuap.baseservice.support.condition.Match;
import com.yonyou.iuap.model.dao.ModelMapper;
import com.yonyou.iuap.model.entity.Model;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;
import com.yonyou.uap.busilog.annotation.LogConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

@Service

/**
 * Model CRUD 核心服务,提供逻辑删除/乐观锁
 */
public class ModelService extends GenericIntegrateService<Model> {

	private Logger log = LoggerFactory.getLogger(ModelService.class);

	private ModelMapper modelMapper;
	@Autowired
	private StatCommonService statCommonService;

	@Autowired
	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
		super.setGenericMapper(modelMapper);
	}

	@Override
	@LogConfig(busiCode = "model_deleteBatch", busiName = "视图模型", operation = "视图模型删除", templateId = "model_deleteBatch")
	public int deleteBatch(List<Model> list) {
		return super.deleteBatch(list);
	}

	@Override
	@LogConfig(busiCode = "model_updateSelective", busiName = "视图模型", operation = "视图模型修改", templateId = "model_updateSelective")
	public Model updateSelective(Model entity) {

		Map<String, Object> searchMap = new HashMap<>();
		List<Map<String, Object>> wheres = new ArrayList<>(2);
		Map<String, Object> statment1 = new HashMap<>();
		statment1.put("key", "id");
		statment1.put("value", entity.getId());
		statment1.put("condition", "UEQ");
		Map<String, Object> statment2 = new HashMap<>();
		statment2.put("key", "modelName");
		statment2.put("value", entity.getModelName());
		statment2.put("condition", Match.EQ.name());
		wheres.add(statment1);
		wheres.add(statment2);
		searchMap.put("whereParams", wheres);
		SearchParams searchParams = new SearchParams();
		searchParams.setSearchMap(searchMap);
		List<Map> findAll = this.statCommonService.findAll(searchParams, Model.class.getSimpleName());
		if (findAll != null && findAll.size() >= 1) {
			String msg = MessageSourceUtil.getMessage("ja.model.data.0001", "检索名称不唯一,") + "" + ":" + entity.getModelName();
			log.error(msg);
			throw new RuntimeException(msg);
		}
		return super.updateSelective(entity);
	}

	@Override
	@LogConfig(busiCode = "model_insertSelective", busiName = "视图模型", operation = "视图模型添加", templateId = "model_insertSelective")
	public Model insertSelective(Model entity) {
		List<Model> listData = this.queryList("modelName", entity.getModelName());
		if (listData != null && listData.size() >= 1) {
			String msg = MessageSourceUtil.getMessage("ja.model.data.0001", "检索名称不唯一,") + "" + ":" + entity.getModelName();
			log.error(msg);
			throw new RuntimeException(msg);
		}
		return super.insertSelective(entity);
	}

	/**
	 * @CAU 可插拔设计
	 * @return 向父类 GenericIntegrateService 提供可插拔的特性声明
	 */
	@Override
	protected ServiceFeature[] getFeats() {
		return new ServiceFeature[] { REFERENCE, LOGICAL_DEL, MULTI_TENANT };
	}

}