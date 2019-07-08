package com.yonyou.iuap.model.controller;

import com.yonyou.iuap.base.web.BaseController;
import com.yonyou.iuap.context.InvocationInfoProxy;
import com.yonyou.iuap.model.entity.Model;
import com.yonyou.iuap.model.service.ModelService;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;
import com.yonyou.iuap.pap.base.i18n.MethodUtils;
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

import java.util.List;

/**
 * 说明：model测试 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-10-19 16:29:48
 */
@Controller
@RequestMapping(value = "/origin_model")
public class ModelController extends BaseController {
	//多语常量
	private static final String KEY1 = "ja.all.con1.0001";
	private static final String MSG1 = "查询数据异常！";
	private static final String KEY2 = "ja.all.con1.0002";
	private static final String MSG2 = "新增数据异常！";
	private static final String KEY3 = "ja.all.con1.0003";
	private static final String MSG3 = "修改数据异常！";
	private static final String KEY4 = "ja.all.con1.0004";
	private static final String MSG4 = "删除数据异常！";
	private static final String NAME = "modelName";
	private static final String KEY = "ja.all.con.00001";
	private static final String MESSAGE = "名称不能为空！";
	private Logger logger = LoggerFactory.getLogger(ModelController.class);
	private ModelService modelService;

	@Autowired
	public void setModelService(ModelService modelService) {
		this.modelService = modelService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(PageRequest pageRequest, SearchParams searchParams) {
		try {
			if (pageRequest.getPageSize() == 1) {
				Integer allCount = Integer.MAX_VALUE - 1;
				pageRequest = new PageRequest(pageRequest.getPageNumber(), allCount, pageRequest.getSort());
			}
			Page<Model> page = this.modelService.selectAllByPage(pageRequest, searchParams);
			return this.buildSuccess(page);
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY1, MSG1), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY1, MSG1), RequestStatusEnum.FAIL_FIELD);
		}
	}


	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBatch(@RequestBody List<Model> listData) {
		try {
			this.modelService.deleteBatch(listData);
			return super.buildSuccess();
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY4, MSG4), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY4, MSG4), RequestStatusEnum.FAIL_FIELD);
		}
	}

	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object updateSelective(@RequestBody Model entity) {
		try {
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
			this.modelService.updateSelective(entity);
			return this.buildSuccess(entity);
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY3, MSG3), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY3, MSG3), RequestStatusEnum.FAIL_FIELD);
		}
	}

	@RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object insertSelective(@RequestBody Model entity) {
		try {
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
			this.modelService.insertSelective(entity);
			return this.buildSuccess(entity);
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY2, MSG2), exp);
			return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
		}
	}

}