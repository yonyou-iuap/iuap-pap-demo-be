package com.yonyou.iuap.tree.controller;

import com.yonyou.iuap.base.web.BaseController;
import com.yonyou.iuap.context.InvocationInfoProxy;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.JsonResponse;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;
import com.yonyou.iuap.pap.base.i18n.MethodUtils;
import com.yonyou.iuap.tree.entity.TableDemo;
import com.yonyou.iuap.tree.service.TableDemoService;
import io.swagger.annotations.*;
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
 * 说明：表TableDemo 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-10-31 9:36:22
 */
@Controller
@RequestMapping(value = "/table_demo")
@Api(tags = "树表table接口",description="树表table文档说明",hidden=true)
public class TableDemoController extends BaseController {
	//多语常量
	private static final String KEY1 = "ja.all.con1.0001";
	private static final String MSG1 = "查询数据异常！";
	private static final String KEY2 = "ja.all.con1.0002";
	private static final String MSG2 = "新增数据异常！";
	private static final String KEY3 = "ja.all.con1.0003";
	private static final String MSG3 = "修改数据异常！";
	private static final String KEY4 = "ja.all.con1.0004";
	private static final String MSG4 = "删除数据异常！";
	private static final String NAME = "name";
	private static final String KEY = "ja.all.con.00001";
	private static final String MESSAGE = "名称不能为空！";
	private Logger logger = LoggerFactory.getLogger(TableDemoController.class);
	private TableDemoService tableDemoService;

	@Autowired
	public void setTableDemoService(TableDemoService tableDemoService) {
		this.tableDemoService = tableDemoService;
	}
	/**
	 * 获取列表数据
	 * @param pageRequest
	 * @param searchParams
	 * @return
	 */
	@ApiOperation(value="查询列表数据",notes="查询树表列表数据接口说明")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageRequest",value="分页数据、排序数据",dataType="PageRequest", paramType = "query"),
		@ApiImplicitParam(name="searchParams",value="查询条件",dataType="SearchParams", paramType = "query"),
	})
	@ApiResponse(response = JsonResponse.class, code = 200, message = "success")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(PageRequest pageRequest, SearchParams searchParams) {
		try {
			if (pageRequest.getPageSize() == 1) {
				Integer allCount = Integer.MAX_VALUE - 1;
				pageRequest = new PageRequest(pageRequest.getPageNumber(), allCount, pageRequest.getSort());
			}
			Page<TableDemo> page = this.tableDemoService.selectAllByPage(pageRequest, searchParams);
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
	@ApiOperation(value="删除数据",notes="删除树表中表数据接口说明")
	@ApiImplicitParam(name="listData",value="删除数据集合",dataType="List", paramType = "delete")
	@ApiResponse(response = JsonResponse.class, code = 200, message = "success")
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBatch(@RequestBody List<TableDemo> listData) {
		try {
			this.tableDemoService.deleteBatch(listData);
			return super.buildSuccess();
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY4, MSG4), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY4, MSG4), RequestStatusEnum.FAIL_FIELD);
		}
	}

	/**
	 * 添加数据
	 * @param entity
	 * @return
	 */
	@ApiOperation(value="添加数据",notes="添加树表中表数据接口说明")
	@ApiImplicitParam(name="entity",value="添加数据",dataType="TableDemo", paramType = "insert")
	@ApiResponse(response = JsonResponse.class, code = 200, message = "success")
	@RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object insertSelective(@RequestBody TableDemo entity) {
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
			this.tableDemoService.insertSelective(entity);
			return this.buildSuccess(entity);
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY2, MSG2), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY2, MSG2), RequestStatusEnum.FAIL_FIELD);
		}
	}

	/**
	 * 修改数据
	 * @param entity
	 * @return
	 */
	@ApiOperation(value="修改数据",notes="修改树表中表数据接口说明")
	@ApiImplicitParam(name="entity",value="修改数据",dataType="TableDemo", paramType = "update")
	@ApiResponse(response = JsonResponse.class, code = 200, message = "success")
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object updateSelective(@RequestBody TableDemo entity) {
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
			this.tableDemoService.updateSelective(entity);
			return this.buildSuccess(entity);
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY3, MSG3), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY3, MSG3), RequestStatusEnum.FAIL_FIELD);
		}
	}
}