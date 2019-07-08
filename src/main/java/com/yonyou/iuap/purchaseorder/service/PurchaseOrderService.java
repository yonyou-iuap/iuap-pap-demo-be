package com.yonyou.iuap.purchaseorder.service;

import com.yonyou.iuap.baseservice.intg.service.GenericIntegrateService;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import com.yonyou.iuap.purchaseorder.dao.PurchaseOrderMapper;
import com.yonyou.iuap.purchaseorder.entity.PurchaseOrder;
import com.yonyou.uap.busilog.annotation.LogConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

@Service

/**
 * PurchaseOrder CRUD 核心服务,提供逻辑删除/乐观锁
 */
public class PurchaseOrderService extends GenericIntegrateService<PurchaseOrder> {

	private PurchaseOrderMapper purchaseOrderMapper;

	@Autowired
	public void setPurchaseOrderMapper(PurchaseOrderMapper purchaseOrderMapper) {
		this.purchaseOrderMapper = purchaseOrderMapper;
		super.setGenericMapper(purchaseOrderMapper);
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
	@LogConfig(busiCode = "purchaseOrder_deleteBatch", busiName = "请购单", operation = "请购单删除", templateId = "purchaseOrder_deleteBatch")
	public int deleteBatch(List<PurchaseOrder> list) {
		return super.deleteBatch(list);
	}

}