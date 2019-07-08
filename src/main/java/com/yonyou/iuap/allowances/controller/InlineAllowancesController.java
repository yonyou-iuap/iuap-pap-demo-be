package com.yonyou.iuap.allowances.controller;

import com.yonyou.iuap.CSRFToken;
import com.yonyou.iuap.allowances.entity.Allowances;
import com.yonyou.iuap.allowances.service.AllowancesEnumService;
import com.yonyou.iuap.allowances.service.AllowancesService;
import com.yonyou.iuap.base.web.BaseController;
import com.yonyou.iuap.baseservice.statistics.service.StatCommonService;
import com.yonyou.iuap.baseservice.support.exception.CodingException;
import com.yonyou.iuap.common.utils.ExcelExportImportor;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：员工津贴记录 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-10-9 16:44:58
 */
@Controller
@RequestMapping(value = "/inline_allowances")
public class InlineAllowancesController extends BaseController {
	//多语常量
	private static final String KEY1 = "ja.all.con1.0001";
	private static final String MSG1 = "查询数据异常！";
	private static final String KEY2 = "ja.all.con1.0002";
	private static final String MSG2 = "新增数据异常！";
	private static final String KEY11 = "ja.all.con1.0011";
	private static final String MSG11 = "按编码规则生成编码出错，原因：获取后编码失败";
	private static final String KEY3 = "ja.all.con1.0003";
	private static final String MSG3 = "修改数据异常！";
	private static final String KEY4 = "ja.all.con1.0004";
	private static final String MSG4 = "删除数据异常！";
	private static final String KEY5 = "ja.all.con1.0005";
	private static final String MSG5 = "Excel模板下载失败！";
	private static final String KEY6 = "ja.all.con1.0006";
	private static final String MSG6 = "Excel模板下載成功！";
	private static final String KEY7 = "ja.all.con1.0007";
	private static final String MSG7 = "导入文件格式异常！";
	private static final String KEY8 = "ja.all.con1.0008";
	private static final String MSG8 = "导入数据异常！";
	private static final String KEY9 = "ja.all.con1.0009";
	private static final String MSG9 = "Excel导入失败！";
	private static final String KEY10 = "ja.all.con1.0010";
	private static final String MSG10 = "Excel导入成功！";
	private static final String NAME = "name";
	private static final String KEY = "ja.all.con.00001";
	private static final String MESSAGE = "名称不能为空！";
	private static final String MODELCODE = "Allowances";
	private Logger logger = LoggerFactory.getLogger(InlineAllowancesController.class);
	private AllowancesService allowancesService;
	@Autowired
	private StatCommonService statCommonService;

	private static Map<String, String> getImportHeadInfo() {
		Map<String, String> importMap = new HashMap<>();
		importMap.put("code", MessageSourceUtil.getMessage("ja.all.entity1.0001", "员工编号"));
		importMap.put("serviceYearsCompany", MessageSourceUtil.getMessage("ja.all.entity1.0002", "司龄"));
		importMap.put("pickTime", MessageSourceUtil.getMessage("ja.all.entity1.0003", "领取时间"));
		importMap.put("level", MessageSourceUtil.getMessage("ja.all.entity1.0004", "职级"));
		importMap.put("year", MessageSourceUtil.getMessage("ja.all.entity1.0005", "年份"));
		importMap.put("sex", MessageSourceUtil.getMessage("ja.all.entity1.0006", "员工性别"));
		importMap.put("allowanceStandard", MessageSourceUtil.getMessage("ja.all.entity1.0007", "补贴标准"));
		importMap.put("remark", MessageSourceUtil.getMessage("ja.all.entity1.0008", "备注"));
		importMap.put("dept", MessageSourceUtil.getMessage("ja.all.entity1.0009", "所属部门"));
		importMap.put("exdeeds", MessageSourceUtil.getMessage("ja.all.entity1.0010", "是否超标"));
		importMap.put("allowanceActual", MessageSourceUtil.getMessage("ja.all.entity1.0011", "实际补贴"));
		importMap.put("allowanceType", MessageSourceUtil.getMessage("ja.all.entity1.0012", "补贴类别"));
		importMap.put("month", MessageSourceUtil.getMessage("ja.all.entity1.0013", "月份"));
		importMap.put("pickType", MessageSourceUtil.getMessage("ja.all.entity1.0014", "领取方式"));
		importMap.put("name", MessageSourceUtil.getMessage("ja.all.entity1.0015", "员工姓名"));
		importMap.put("serviceYears", MessageSourceUtil.getMessage("ja.all.entity1.0016", "工龄"));
		importMap.put("applyTime", MessageSourceUtil.getMessage("ja.all.entity1.0017", "申请时间"));
		return importMap;
	}

	@Autowired
	public void setAllowancesService(AllowancesService allowancesService) {
		this.allowancesService = allowancesService;
	}

	/**
	 * 批量添加
	 * @param listData
	 * @return
	 */
	@CSRFToken
	@RequestMapping(value = "/saveMultiple", method = RequestMethod.POST)
	@ResponseBody
	public Object saveMultiple(@RequestBody List<Allowances> listData) {
		try {
			this.allowancesService.saveMultiple(listData);
			return this.buildSuccess();
		} catch (CodingException e) {
			logger.error(e.getMessage(), e);
			return this.buildError("msg", e.getMessage(), RequestStatusEnum.FAIL_FIELD);
		} catch (Exception e) {
			logger.error(MessageSourceUtil.getMessage(KEY1, MSG1), e);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY1, MSG1), RequestStatusEnum.FAIL_FIELD);
		}
	}

	/**
	 * 批量修改
	 * @param listData
	 * @return
	 */
	@CSRFToken
	@RequestMapping(value = "/updateMultiple", method = RequestMethod.POST)
	@ResponseBody
	public Object updateMultiple(@RequestBody List<Allowances> listData) {
		try {
			this.allowancesService.updateMultiple(listData);
			return this.buildSuccess();
		} catch (Exception exp) {
			logger.error("exp", exp);
			return this.buildError("msg", "Error update database", RequestStatusEnum.FAIL_FIELD);
		}

	}

	/**
	 * 删除
	 * @param listData
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@CSRFToken
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBatch(@RequestBody List<Allowances> listData, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			this.allowancesService.deleteBatch(listData);
			return super.buildSuccess();
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY4, MSG4), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY4, MSG4), RequestStatusEnum.FAIL_FIELD);
		}
	}

	/**
	 * 下载模板
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/excelTemplateDownload", method = { RequestMethod.GET })
	@ResponseBody
	public Object excelTemplateDownload(HttpServletRequest request, HttpServletResponse response) {
		String name = "ALLOWANCES";
		try {
			ExcelExportImportor.downloadExcelTemplate(response, getImportHeadInfo(), name, name);
		} catch (Exception e) {
			logger.error(MessageSourceUtil.getMessage(KEY5, MSG5), e);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY5, MSG5), RequestStatusEnum.FAIL_FIELD);
		}
		return super.buildSuccess(MessageSourceUtil.getMessage(KEY6, MSG6));
	}

	/**
	 * 多过滤 多排序
	 * @param pageRequest
	 * @param searchMap
	 * @return
	 */
	@CSRFToken(verify = false)
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(PageRequest pageRequest, @RequestBody Map<String, Object> searchMap) {
		try {
			SearchParams searchParams = new SearchParams();
			searchParams.setSearchMap(searchMap);
		    if (pageRequest.getPageSize() == 1) {
				Integer allCount = Integer.MAX_VALUE-1;
				pageRequest = new PageRequest(pageRequest.getPageNumber(), allCount, pageRequest.getSort());
			}
	    	Page<Map> page = this.statCommonService.selectFieldsByPage(pageRequest, searchParams, MODELCODE);
	    	AllowancesEnumService.fillDynamicList( page.getContent());
	    	return this.buildSuccess(page);
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY1, MSG1), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY1, MSG1), RequestStatusEnum.FAIL_FIELD);
		}
	}
}
