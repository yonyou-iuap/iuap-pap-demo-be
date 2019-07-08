package com.yonyou.iuap.passenger.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;

import com.yonyou.iuap.baseservice.persistence.mybatis.mapper.GenericExMapper;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.mybatis.type.PageResult;
import com.yonyou.iuap.passenger.entity.Passenger;


@MyBatisRepository
public interface PassengerMapper extends GenericExMapper<Passenger> {

  PageResult<Passenger> selectAllBySonCode(@Param("page") PageRequest paramPageRequest, @Param("condition") SearchParams paramSearchParams);

}

