package com.yonyou.iuap.passenger.service;

import com.yonyou.iuap.baseservice.intg.service.GenericIntegrateService;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import com.yonyou.iuap.passenger.dao.TravelingInformationMapper;
import com.yonyou.iuap.passenger.entity.TravelingInformation;
import com.yonyou.uap.busilog.annotation.LogConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

@Service

/**
 * TravelingInformation CRUD 核心服务,提供逻辑删除/乐观锁
 */
public class TravelingInformationService extends GenericIntegrateService<TravelingInformation> {

	private TravelingInformationMapper travelingInformationMapper;

	@Autowired
	public void setTravelingInformationMapper(TravelingInformationMapper travelingInformationMapper) {
		this.travelingInformationMapper = travelingInformationMapper;
		super.setGenericMapper(travelingInformationMapper);
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
	@LogConfig(busiCode = "travelingInformation_deleteBatch", busiName = "乘车信息", operation = "乘车信息删除", templateId = "travelingInformation_deleteBatch")
	public int deleteBatch(List<TravelingInformation> list) {
		return super.deleteBatch(list);
	}

	@Override
	@LogConfig(busiCode = "travelingInformation_insertSelective", busiName = "乘车信息", operation = "乘车信息添加", templateId = "travelingInformation_insertSelective")
	public TravelingInformation insertSelective(TravelingInformation entity) {
		return super.insertSelective(entity);
	}

	@Override
	@LogConfig(busiCode = "travelingInformation_updateSelective", busiName = "乘车信息", operation = "乘车信息修改", templateId = "travelingInformation_updateSelective")
	public TravelingInformation updateSelective(TravelingInformation entity) {
		return super.updateSelective(entity);
	}

	
}