package com.yonyou.iuap.passenger.service;

import com.yonyou.iuap.baseservice.intg.service.GenericIntegrateService;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import com.yonyou.iuap.passenger.dao.PassengerMapper;
import com.yonyou.iuap.passenger.entity.Passenger;
import com.yonyou.uap.busilog.annotation.LogConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

@Service

/**
 * Passenger CRUD 核心服务,提供逻辑删除/乐观锁
 */
public class PassengerService extends GenericIntegrateService<Passenger> {

	private PassengerMapper passengerMapper;

	@Autowired
	public void setPassengerMapper(PassengerMapper passengerMapper) {
		this.passengerMapper = passengerMapper;
		super.setGenericMapper(passengerMapper);
	}
	
	/**
	 * @CAU 可插拔设计
	 * @return 向父类 GenericIntegrateService 提供可插拔的特性声明
	 */
	@Override
	protected ServiceFeature[] getFeats() {
		return new ServiceFeature[] { REFERENCE, BPM, MULTI_TENANT, LOGICAL_DEL,REMOTE_REFERENCE };
	}

	@Override
	@LogConfig(busiCode = "passenger_deleteBatch", busiName = "乘客信息", operation = "乘客信息删除", templateId = "passenger_deleteBatch")
	public int deleteBatch(List<Passenger> list) {
		return super.deleteBatch(list);
	}

	@Override
	@LogConfig(busiCode = "passenger_insertSelective", busiName = "乘客信息", operation = "乘客信息添加", templateId = "passenger_insertSelective")
	public Passenger insertSelective(Passenger entity) {
		return super.insertSelective(entity);
	}

	@Override
	@LogConfig(busiCode = "passenger_updateSelective", busiName = "乘客信息", operation = "乘客信息修改", templateId = "passenger_updateSelective")
	public Passenger updateSelective(Passenger entity) {
		return super.updateSelective(entity);
	}

	/*public Page<Passenger> selectAllBySonCode(PageRequest pageRequest,SearchParams searchParam) {
		CustomSelectPageable calling = new AbsCustomSelectPage<Passenger>(searchParam,pageRequest){
			@Override
			public Page<Passenger> doCunstomSelectPage() {
				return passengerMapper.selectAllBySonCode(this.pageRequest, this.searchParams).getPage();
			}
		};
		return super.customSelectPageWithFeatures(calling);
	}*/
	
}