package com.yonyou.iuap.allowances.dao;
import com.yonyou.iuap.allowances.entity.Allowances;
import com.yonyou.iuap.baseservice.persistence.mybatis.mapper.GenericExMapper;
import com.yonyou.iuap.mybatis.anotation.MyBatisRepository;
@MyBatisRepository
public interface AllowancesMapper extends GenericExMapper<Allowances> {
	
}

