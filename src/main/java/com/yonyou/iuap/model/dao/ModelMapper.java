package com.yonyou.iuap.model.dao;

import com.yonyou.iuap.baseservice.persistence.mybatis.mapper.GenericExMapper;
import com.yonyou.iuap.model.entity.Model;
import com.yonyou.iuap.mybatis.anotation.MyBatisRepository;


@MyBatisRepository
public interface ModelMapper extends GenericExMapper<Model> {

}

