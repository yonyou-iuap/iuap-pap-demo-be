package com.yonyou.iuap.purchaseorder.service;

import com.yonyou.iuap.baseservice.intg.service.GenericIntegrateService;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import com.yonyou.iuap.purchaseorder.dao.PurchaseOrderDetailMapper;
import com.yonyou.iuap.purchaseorder.entity.PurchaseOrderDetail;
import com.yonyou.uap.busilog.annotation.LogConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

@Service

/**
 * PurchaseOrderDetail CRUD 核心服务,提供逻辑删除/乐观锁
 */
public class PurchaseOrderDetailService extends GenericIntegrateService<PurchaseOrderDetail> {

	private PurchaseOrderDetailMapper purchaseOrderDetailMapper;

	@Autowired
	public void setPurchaseOrderDetailMapper(PurchaseOrderDetailMapper purchaseOrderDetailMapper) {

		this.purchaseOrderDetailMapper = purchaseOrderDetailMapper;
		super.setGenericMapper(purchaseOrderDetailMapper);
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
	@LogConfig(busiCode = "purchaseOrderDetail_deleteBatch", busiName = "请购单详情", operation = "请购单详情删除", templateId = "purchaseOrderDetail_deleteBatch")
	public int deleteBatch(List<PurchaseOrderDetail> list) {
		return super.deleteBatch(list);
	}
}