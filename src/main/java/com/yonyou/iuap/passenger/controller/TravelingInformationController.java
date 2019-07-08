package com.yonyou.iuap.passenger.controller;

import com.yonyou.iuap.base.web.BaseController;
import com.yonyou.iuap.baseservice.support.exception.CodingException;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;
import com.yonyou.iuap.passenger.entity.TravelingInformation;
import com.yonyou.iuap.passenger.service.TravelingInformationService;
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
 * 说明：乘车预定信息 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-10-25 20:11:56
 */
@Controller
@RequestMapping(value = "/traveling_information")
public class TravelingInformationController extends BaseController {
	//多语常量
	private static final String KEY11 = "ja.all.con1.0011";
	private static final String MSG11 = "按编码规则生成编码出错，原因：获取后编码失败";
	private static final String KEY1 = "ja.all.con1.0001";
	private static final String MSG1 = "查询数据异常！";
	private static final String KEY2 = "ja.all.con1.0002";
	private static final String MSG2 = "新增数据异常！";
	private static final String KEY3 = "ja.all.con1.0003";
	private static final String MSG3 = "修改数据异常！";
	private static final String KEY4 = "ja.all.con1.0004";
	private static final String MSG4 = "删除数据异常！";
	private Logger logger = LoggerFactory.getLogger(TravelingInformationController.class);
	private TravelingInformationService travelingInformationService;

	@Autowired
	public void setTravelingInformationService(TravelingInformationService travelingInformationService) {
		this.travelingInformationService = travelingInformationService;
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
			Page<TravelingInformation> page = this.travelingInformationService.selectAllByPage(pageRequest, searchParams);
			return this.buildSuccess(page);
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY1, MSG1), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY1, MSG1), RequestStatusEnum.FAIL_FIELD);
		}
	}
	
	/**
	 * 添加数据
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object insertSelective(@RequestBody TravelingInformation entity) {
		try {
			entity = this.travelingInformationService.insertSelective(entity);
			TravelingInformation travelingInformation = this.travelingInformationService.findById(entity.getId());
			return this.buildSuccess(travelingInformation);
		} catch (CodingException e) {
            logger.error(e.getMessage(), e);
            return this.buildError("msg", e.getMessage(), RequestStatusEnum.FAIL_FIELD);
        } catch (Exception e) {
            logger.error(MessageSourceUtil.getMessage(KEY1, MSG1), e);
            return this.buildError("msg", MessageSourceUtil.getMessage(KEY1, MSG1), RequestStatusEnum.FAIL_FIELD);
        }
	}

	/**
	 * 修改数据
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object updateSelective(@RequestBody TravelingInformation entity) {
		try {
			entity = this.travelingInformationService.updateSelective(entity);
			TravelingInformation travelingInformation = this.travelingInformationService.findById(entity.getId());
			return this.buildSuccess(travelingInformation);
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY3, MSG3), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY3, MSG3), RequestStatusEnum.FAIL_FIELD);
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
	public Object deleteBatch(@RequestBody List<TravelingInformation> listData, HttpServletRequest request,
							  HttpServletResponse response) {
		try {
			this.travelingInformationService.deleteBatch(listData);
			return super.buildSuccess();
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY4, MSG4), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY4, MSG4), RequestStatusEnum.FAIL_FIELD);
		}
	}
}