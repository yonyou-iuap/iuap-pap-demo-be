package com.yonyou.iuap.passenger.dao;

import com.yonyou.iuap.baseservice.persistence.mybatis.mapper.GenericExMapper;
import com.yonyou.iuap.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.passenger.entity.EmergencyContact;


@MyBatisRepository
public interface EmergencyContactMapper extends GenericExMapper<EmergencyContact> {

}

