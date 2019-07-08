package com.yonyou.iuap.tree.dao;

import com.yonyou.iuap.baseservice.persistence.mybatis.mapper.GenericExMapper;
import com.yonyou.iuap.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.tree.entity.TreeDemo;


@MyBatisRepository
public interface TreeDemoMapper extends GenericExMapper<TreeDemo> {
	
}

