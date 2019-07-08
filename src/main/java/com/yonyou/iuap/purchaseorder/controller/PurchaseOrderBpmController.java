package com.yonyou.iuap.purchaseorder.controller;

import com.yonyou.iuap.baseservice.bpm.controller.GenericBpmController;
import com.yonyou.iuap.purchaseorder.entity.PurchaseOrder;
import com.yonyou.iuap.purchaseorder.service.PurchaseOrderBpmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 说明：请购单主表PurchaseOrder 流程控制Controller——提供流程提交、收回、审批回调等rest接口
 * 
 * @date 2018-11-5 14:01:30
 */
@Controller
@RequestMapping(value="/purchase_order")
public class PurchaseOrderBpmController extends GenericBpmController<PurchaseOrder> {
    
    private Logger logger = LoggerFactory.getLogger(PurchaseOrderController.class);


    private PurchaseOrderBpmService service;
    @Autowired
    public void setService(PurchaseOrderBpmService service) {
        this.service = service;
        super.setService(service);
    }

}
