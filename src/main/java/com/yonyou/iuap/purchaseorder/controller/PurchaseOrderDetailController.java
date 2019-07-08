package com.yonyou.iuap.purchaseorder.controller;

import com.yonyou.iuap.base.web.BaseController;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;
import com.yonyou.iuap.purchaseorder.entity.PurchaseOrderDetail;
import com.yonyou.iuap.purchaseorder.service.PurchaseOrderDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 说明：请购单详情表_物料表 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-11-5 17:23:26
 */
@Controller
@RequestMapping(value = "/purchase_order_detail")
public class PurchaseOrderDetailController extends BaseController {
	//多语常量
	private static final String KEY1 = "ja.all.con1.0001";
	private static final String MSG1 = "查询数据异常！";
	private static final String KEY4 = "ja.all.con1.0004";
	private static final String MSG4 = "删除数据异常！";
	private Logger logger = LoggerFactory.getLogger(PurchaseOrderDetailController.class);
	private PurchaseOrderDetailService purchaseOrderDetailService;

	@Autowired
	public void setPurchaseOrderDetailService(PurchaseOrderDetailService purchaseOrderDetailService) {
		this.purchaseOrderDetailService = purchaseOrderDetailService;
	}
	/**
	 * 获取列表数据
	 * @param pageRequest
	 * @param searchParams
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(PageRequest pageRequest, SearchParams searchParams) {
		try {
			if (pageRequest.getPageSize() == 1) {
				Integer allCount = Integer.MAX_VALUE-1;
				pageRequest = new PageRequest(pageRequest.getPageNumber(), allCount, pageRequest.getSort());
			}
			Page<PurchaseOrderDetail> page = this.purchaseOrderDetailService.selectAllByPage(pageRequest, searchParams);
			return this.buildSuccess(page);
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY1, MSG1), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY1, MSG1), RequestStatusEnum.FAIL_FIELD);
		}
	}
	/**
	 * 获取表单详情数据
	 * @param pageRequest
	 * @param searchParams
	 * @return
	 */
	@RequestMapping(value = "/getOrderDetail", method = RequestMethod.GET)
	@ResponseBody
	public Object getOrderDetail(PageRequest pageRequest, SearchParams searchParams) {
		try {
			if (pageRequest.getPageSize() == 1) {
				Integer allCount = Integer.MAX_VALUE - 1;
				pageRequest = new PageRequest(pageRequest.getPageNumber(), allCount, pageRequest.getSort());
			}
			Page<PurchaseOrderDetail> page = this.purchaseOrderDetailService.selectAllByPage(pageRequest, searchParams);
			return this.buildSuccess(page);
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY1, MSG1), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY1, MSG1), RequestStatusEnum.FAIL_FIELD);
		}
	}

	/**
	 * 删除数据
	 * @param listData
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBatch(@RequestBody List<PurchaseOrderDetail> listData, HttpServletRequest request,
							  HttpServletResponse response) {
		try {
			this.purchaseOrderDetailService.deleteBatch(listData);
			return super.buildSuccess();
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY4, MSG4), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY4, MSG4), RequestStatusEnum.FAIL_FIELD);
		}
	}
}