package com.yonyou.iuap.tree.service;

import com.yonyou.iuap.baseservice.intg.service.GenericIntegrateService;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import com.yonyou.iuap.tree.dao.TableDemoMapper;
import com.yonyou.iuap.tree.entity.TableDemo;
import com.yonyou.uap.busilog.annotation.LogConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

@Service

/**
 * TableDemo CRUD 核心服务,提供逻辑删除/乐观锁
 */
public class TableDemoService extends GenericIntegrateService<TableDemo> {

	private TableDemoMapper tableDemoMapper;

	@Autowired
	public void setTableDemoMapper(TableDemoMapper tableDemoMapper) {
		this.tableDemoMapper = tableDemoMapper;
		super.setGenericMapper(tableDemoMapper);
	}

	/**
	 * @CAU 可插拔设计
	 * @return 向父类 GenericIntegrateService 提供可插拔的特性声明
	 */
	@Override
	protected ServiceFeature[] getFeats() {
		return new ServiceFeature[] { REFERENCE, LOGICAL_DEL, MULTI_TENANT };
	}

	
	@Override
	@LogConfig(busiCode = "tableDemo_deleteBatch", busiName = "表信息", operation = "表信息删除", templateId = "tableDemo_deleteBatch")
	public int deleteBatch(List<TableDemo> list) {
		return super.deleteBatch(list);
	}

	@Override
	@LogConfig(busiCode = "tableDemo_insertSelective", busiName = "表信息", operation = "表信息添加", templateId = "tableDemo_insertSelective")
	public TableDemo insertSelective(TableDemo entity) {
		return super.insertSelective(entity);
	}

	@Override
	@LogConfig(busiCode = "tableDemo_updateSelective", busiName = "表信息", operation = "表信息修改", templateId = "tableDemo_updateSelective")
	public TableDemo updateSelective(TableDemo entity) {
		return super.updateSelective(entity);
	}
}