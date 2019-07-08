package com.yonyou.iuap.purchaseorder.dao;

import com.yonyou.iuap.baseservice.persistence.mybatis.mapper.GenericExMapper;
import com.yonyou.iuap.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.purchaseorder.entity.PurchaseOrderDetail;


@MyBatisRepository
public interface PurchaseOrderDetailMapper extends GenericExMapper<PurchaseOrderDetail> {

}

