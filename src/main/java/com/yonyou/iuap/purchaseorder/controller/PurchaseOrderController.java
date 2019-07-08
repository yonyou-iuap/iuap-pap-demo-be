package com.yonyou.iuap.purchaseorder.controller;

import com.yonyou.iuap.base.web.BaseController;
import com.yonyou.iuap.baseservice.entity.annotation.Associative;
import com.yonyou.iuap.baseservice.support.exception.CodingException;
import com.yonyou.iuap.baseservice.vo.GenericAssoVo;
import com.yonyou.iuap.context.InvocationInfoProxy;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;
import com.yonyou.iuap.pap.base.i18n.MethodUtils;
import com.yonyou.iuap.purchaseorder.entity.PurchaseOrder;
import com.yonyou.iuap.purchaseorder.service.PurchaseOrderAssoService;
import com.yonyou.iuap.purchaseorder.service.PurchaseOrderService;
import org.apache.commons.lang3.StringUtils;
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


/**
 * 说明：请购单主表PurchaseOrder 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-11-5 14:01:30
 */
@Controller
@RequestMapping(value = "/purchase_order")
public class PurchaseOrderController extends BaseController {
	//多语常量
	private static final String KEY1 = "ja.all.con1.0001";
	private static final String MSG1 = "查询数据异常！";
	private static final String KEY2 = "ja.all.con1.0002";
	private static final String MSG2 = "新增数据异常！";
	private static final String NAME = "orderName";
	private static final String KEY = "ja.all.con.00001";
	private static final String MESSAGE = "名称不能为空！";
	private Logger logger = LoggerFactory.getLogger(PurchaseOrderController.class);
	private PurchaseOrderService purchaseOrderService;
	private PurchaseOrderAssoService purchaseOrderAssoService;

	@Autowired
	public void setPurchaseOrderService(PurchaseOrderService purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;

	}

	@Autowired
	public void setPurchaseOrderAssoService(PurchaseOrderAssoService purchaseOrderAssoService) {
		this.purchaseOrderAssoService = purchaseOrderAssoService;
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
			Integer allCount = Integer.MAX_VALUE-1;
			if (pageRequest.getPageSize() == 1) {
				pageRequest = new PageRequest(pageRequest.getPageNumber(), allCount, pageRequest.getSort());
			}
			Page<PurchaseOrder> page = this.purchaseOrderService.selectAllByPage(pageRequest, searchParams);
			return this.buildSuccess(page);
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY1, MSG1), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY1, MSG1), RequestStatusEnum.FAIL_FIELD);
		}
		
	}

	/**
	 * 获取表单详情数据
	 *
	 * @param pageRequest
	 * @param searchParams
	 * @return
	 */
	@RequestMapping(value = "/getOrder", method = RequestMethod.GET)
	@ResponseBody
	public Object getOrder(PageRequest pageRequest, SearchParams searchParams) {
		try {
			Integer allCount = Integer.MAX_VALUE - 1;
			if (pageRequest.getPageSize() == 1) {
				pageRequest = new PageRequest(pageRequest.getPageNumber(), allCount, pageRequest.getSort());
			}
			Page<PurchaseOrder> page = this.purchaseOrderService.selectAllByPage(pageRequest, searchParams);
			return this.buildSuccess(page);
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY1, MSG1), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY1, MSG1), RequestStatusEnum.FAIL_FIELD);
		}

	}

	/**
	 * 主子表合并处理--新增
	 * @param vo
	 * GenericAssoVo中entity是单条主表数据,sublist是子表数据
	 * @return 主表的业务实体
	 */
	@RequestMapping(value = "/saveAssoVo", method = RequestMethod.POST)
	@ResponseBody
	public Object saveAssoVo(@RequestBody GenericAssoVo<PurchaseOrder> vo) {
		try {
			Associative annotation = vo.getEntity().getClass().getAnnotation(Associative.class);
			if (annotation == null || StringUtils.isEmpty(annotation.fkName())) {
				return buildError("msg", MessageSourceUtil.getMessage("ja.pur.con1.0001", "没有@Associative或没有fkName属性！"), RequestStatusEnum.FAIL_FIELD);
			}
			PurchaseOrder entity = vo.getEntity();
			/**国际化 当前语种*/
			String localeSerial = InvocationInfoProxy.getParameter("locale_serial");
			String loacleName = MethodUtils.getDataBySerial(entity, NAME, localeSerial);
			if (StringUtils.isBlank(loacleName)) {
				return this.buildError("msg", MessageSourceUtil.getMessage(KEY, MESSAGE), RequestStatusEnum.FAIL_FIELD);
			}
			/**国际化 验证默认语种*/
			String defaultSerial = InvocationInfoProxy.getParameter("default_serial");
			String defaultName = MethodUtils.getDataBySerial(entity, NAME, defaultSerial);
			if (StringUtils.isBlank(defaultName)) {
				return this.buildError("msg", MessageSourceUtil.getMessage(KEY, MESSAGE), RequestStatusEnum.FAIL_FIELD);
			}
			/**国际化 验证简体中文**/
			String simpleChineseName = MethodUtils.getDataBySerial(entity, NAME, "");
			if (StringUtils.isBlank(simpleChineseName)) {
				return this.buildError("msg", MessageSourceUtil.getMessage(KEY, MESSAGE), RequestStatusEnum.FAIL_FIELD);
			}
			Object result = purchaseOrderAssoService.saveAssoVo(vo, annotation);
			return this.buildSuccess(result);
		} catch (CodingException e) {
            logger.error(e.getMessage(), e);
            return this.buildError("msg", e.getMessage(), RequestStatusEnum.FAIL_FIELD);
        } catch (Exception e) {
            logger.error(MessageSourceUtil.getMessage(KEY1, MSG1), e);
            return this.buildError("msg", MessageSourceUtil.getMessage(KEY1, MSG1), RequestStatusEnum.FAIL_FIELD);
		}
	}

	/**
	 * 主子表合并处理--修改
	 *
	 * @param vo GenericAssoVo中entity是单条主表数据,sublist是子表数据
	 * @return 主表的业务实体
	 */
	@RequestMapping(value = "/updateAssoVo", method = RequestMethod.POST)
	@ResponseBody
	public Object updateAssoVo(@RequestBody GenericAssoVo<PurchaseOrder> vo) {
		try {
			Associative annotation = vo.getEntity().getClass().getAnnotation(Associative.class);
			if (annotation == null || StringUtils.isEmpty(annotation.fkName())) {
				return buildError("msg", MessageSourceUtil.getMessage("ja.pur.con1.0001", "没有@Associative或没有fkName属性！"), RequestStatusEnum.FAIL_FIELD);
			}
			PurchaseOrder entity = vo.getEntity();
			/**国际化 当前语种*/
			String localeSerial = InvocationInfoProxy.getParameter("locale_serial");
			String loacleName = MethodUtils.getDataBySerial(entity, NAME, localeSerial);
			if (StringUtils.isBlank(loacleName)) {
				return this.buildError("msg", MessageSourceUtil.getMessage(KEY, MESSAGE), RequestStatusEnum.FAIL_FIELD);
			}
			/**国际化 验证默认语种*/
			String defaultSerial = InvocationInfoProxy.getParameter("default_serial");
			String defaultName = MethodUtils.getDataBySerial(entity, NAME, defaultSerial);
			if (StringUtils.isBlank(defaultName)) {
				return this.buildError("msg", MessageSourceUtil.getMessage(KEY, MESSAGE), RequestStatusEnum.FAIL_FIELD);
			}
			/**国际化 验证简体中文**/
			String simpleChineseName = MethodUtils.getDataBySerial(entity, NAME, "");
			if (StringUtils.isBlank(simpleChineseName)) {
				return this.buildError("msg", MessageSourceUtil.getMessage(KEY, MESSAGE), RequestStatusEnum.FAIL_FIELD);
			}
			Object result = purchaseOrderAssoService.saveAssoVo(vo, annotation);
			return this.buildSuccess(result);
		} catch (CodingException e) {
			logger.error(e.getMessage(), e);
			return this.buildError("msg", e.getMessage(), RequestStatusEnum.FAIL_FIELD);
		} catch (Exception e) {
			logger.error(MessageSourceUtil.getMessage(KEY1, MSG1), e);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY1, MSG1), RequestStatusEnum.FAIL_FIELD);
		}
	}
	/**
	 * 主子表合并处理--删除,默认级联删除子表,
	 * 若取消级联删除请在主实体上注解改为@Associative(fkName = "orderId",deleteCascade = false)
	 * @param entities 待删除业务实体
	 * @return 删除成功的实体
	 */
	@RequestMapping(value = "/deleAssoVo", method = RequestMethod.POST)
	@ResponseBody
	public Object deleAssoVo(@RequestBody PurchaseOrder... entities) {
		if (entities.length == 0) {
			return this.buildGlobalError(MessageSourceUtil.getMessage("ja.pur.con1.0002", "请求实体不能为空！"));
		}
		Associative annotation = entities[0].getClass().getAnnotation(Associative.class);
		if (annotation != null && !StringUtils.isEmpty(annotation.fkName())) {
			int result = 0;
			for (PurchaseOrder entity : entities) {
				if (StringUtils.isEmpty(entity.getId())) {
					return this.buildError("msg", MessageSourceUtil.getMessage("ja.pur.con1.0003", "ID字段为空！"), RequestStatusEnum.FAIL_FIELD);
				} else {
					result += this.purchaseOrderAssoService.deleAssoVo(entity, annotation);
				}
			}
			return this.buildSuccess(MessageSourceUtil.getMessage("ja.pur.con1.0004", "数据已被删除！"));
		} else {
			return this.buildError("msg", MessageSourceUtil.getMessage("ja.pur.con1.0001", "没有@Associative或没有fkName属性！"), RequestStatusEnum.FAIL_FIELD);
		}
	}

}