package com.yonyou.iuap.allowances.service;

import cn.hutool.core.date.DateUtil;
import com.yonyou.iuap.allowances.dao.AllowancesMapper;
import com.yonyou.iuap.allowances.entity.Allowances;
import com.yonyou.iuap.baseservice.intg.service.GenericIntegrateService;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import com.yonyou.uap.busilog.annotation.LogConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

@Service

/**
 * Allowances CRUD 核心服务,提供逻辑删除/乐观锁
 */
public class AllowancesService extends GenericIntegrateService<Allowances> {

	private static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";
	private AllowancesMapper allowancesMapper;

	@Autowired
	public void setAllowancesMapper(AllowancesMapper allowancesMapper) {
		this.allowancesMapper = allowancesMapper;
		super.setGenericMapper(allowancesMapper);
	}
	
	/**
	 * @CAU 可插拔设计
	 * @return 向父类 GenericIntegrateService 提供可插拔的特性声明
	 */
	@Override
	protected ServiceFeature[] getFeats() {
		return new ServiceFeature[]{BPM, MULTI_TENANT, LOGICAL_DEL, UNION_REFERENCE};
	}
	
	@Override
	@LogConfig(busiCode = "allowances_insertSelective", busiName = "员工津贴", operation = "员工津贴保存", templateId = "allowances_insertSelective")
	public Allowances insertSelective(Allowances entity) {
		String now = DateUtil.format(new Date(), DATEFORMAT);
		entity.setApplyTime(now);
		return super.insertSelective(entity);
	}

	@Override
	@LogConfig(busiCode = "allowances_updateSelective", busiName = "员工津贴", operation = "员工津贴修改", templateId = "allowances_updateSelective")
	public Allowances updateSelective(Allowances entity) {
		return super.updateSelective(entity);

	}
	@LogConfig(busiCode = "allowances_saveMultiple", busiName = "员工津贴", operation = "员工津贴批量添加", templateId = "allowances_saveMultiple")
	public void saveMultiple(List<Allowances> listData) {
		for (Allowances allowances : listData) {
			String now = DateUtil.format(new Date(), DATEFORMAT);
			allowances.setApplyTime(now);
		}
		super.saveBatch(listData);
	}
	
	@LogConfig(busiCode = "allowances_updateMultiple", busiName = "员工津贴", operation = "员工津贴批量修改", templateId = "allowances_updateMultiple")
	public void updateMultiple(List<Allowances> listData) {
		super.saveBatch(listData);
	}

	@Override
	@LogConfig(busiCode = "allowances_deleteSelective", busiName = "员工津贴", operation = "员工津贴删除", templateId = "allowances_deleteBatch")
	public int deleteBatch(List<Allowances> list) {
		return super.deleteBatch(list);
	}
	
}