package com.yonyou.iuap.purchaseorder.service;

import com.yonyou.iuap.baseservice.entity.annotation.Associative;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.iuap.baseservice.vo.GenericAssoVo;
import com.yonyou.iuap.purchaseorder.dao.PurchaseOrderMapper;
import com.yonyou.iuap.purchaseorder.entity.PurchaseOrder;
import com.yonyou.iuap.purchaseorder.entity.PurchaseOrderDetail;
import com.yonyou.uap.busilog.annotation.LogConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

/**
 * 主子表联合查询,修改服务
 * 
 * @date 2018年11月05日 下午02点01分29秒
 */
@Service
public class PurchaseOrderAssoService extends GenericAssoService<PurchaseOrder> {

	private PurchaseOrderMapper mapper;

	/**
	 * 注入主表mapper
	 */
	@Autowired
	public void setService(PurchaseOrderMapper mapper) {
		this.mapper = mapper;
		super.setGenericMapper(mapper);
	}

	/**
	 * 注入子表PurchaseOrderDetailService
	 */
	@Autowired
	public void setPurchaseOrderDetailService(PurchaseOrderDetailService subService) {
		super.setSubService(PurchaseOrderDetail.class, subService);
	}

	@Override
	@LogConfig(busiCode = "purchaseOrder_saveAssoVo", busiName = "请购单", operation = "请购单添加或修改", templateId = "purchaseOrder_saveAssoVo")
	public Object saveAssoVo(GenericAssoVo<PurchaseOrder> arg0, Associative arg1) {
		return super.saveAssoVo(arg0, arg1);
	}
	
	@Override
	@LogConfig(busiCode = "purchaseOrder_deleAssoVo", busiName = "请购单", operation = "请购单删除", templateId = "purchaseOrder_deleAssoVo")
	public int deleAssoVo(PurchaseOrder arg0, Associative arg1) {
		return super.deleAssoVo(arg0, arg1);
	}
	
	@Override
	protected ServiceFeature[] getFeats() {
		return new ServiceFeature[] { REFERENCE, BPM, MULTI_TENANT, LOGICAL_DEL };
	}

}
