package com.yonyou.iuap.passenger.service;

import com.yonyou.iuap.baseservice.intg.service.GenericIntegrateService;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import com.yonyou.iuap.passenger.dao.EmergencyContactMapper;
import com.yonyou.iuap.passenger.entity.EmergencyContact;
import com.yonyou.uap.busilog.annotation.LogConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

@Service

/**
 * EmergencyContact CRUD 核心服务,提供逻辑删除/乐观锁
 */
public class EmergencyContactService extends GenericIntegrateService<EmergencyContact> {

	private EmergencyContactMapper emergencyContactMapper;

	@Autowired
	public void setEmergencyContactMapper(EmergencyContactMapper emergencyContactMapper) {

		this.emergencyContactMapper = emergencyContactMapper;
		super.setGenericMapper(emergencyContactMapper);
	}
	
	/**
	 * @CAU 可插拔设计
	 * @return 向父类 GenericIntegrateService 提供可插拔的特性声明
	 */
	@Override
	protected ServiceFeature[] getFeats() {
		return new ServiceFeature[] { REFERENCE, BPM, MULTI_TENANT, LOGICAL_DEL };
	}
	
	@Override
	@LogConfig(busiCode = "emergencyContact_deleteBatch", busiName = "紧急联系人", operation = "紧急联系人删除", templateId = "emergencyContact_deleteBatch")
	public int deleteBatch(List<EmergencyContact> list) {
		return super.deleteBatch(list);
	}

	@Override
	@LogConfig(busiCode = "emergencyContact_insertSelective", busiName = "紧急联系人", operation = "紧急联系人添加", templateId = "emergencyContact_insertSelective")
	public EmergencyContact insertSelective(EmergencyContact entity) {
		return super.insertSelective(entity);
	}

	@Override
	@LogConfig(busiCode = "emergencyContact_updateSelective", busiName = "紧急联系人", operation = "紧急联系人修改", templateId = "emergencyContact_updateSelective")
	public EmergencyContact updateSelective(EmergencyContact entity) {
		return super.updateSelective(entity);
	}

	
}