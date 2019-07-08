package com.yonyou.iuap.purchaseorder.entity;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.bpm.entity.AbsBpmModel;
import com.yonyou.iuap.baseservice.entity.MultiTenant;
import com.yonyou.iuap.baseservice.print.entity.Printable;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.generator.GeneratedValue;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;

/**
 * 请购单详情表_物料表
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "IUAPD_PURCHASE_ORDER_DETAIL")
public class PurchaseOrderDetail extends AbsBpmModel implements Serializable, MultiTenant, Printable {

	@Id
	@GeneratedValue
	@Condition
	protected String id;// ID
	@Condition
	@Column(name = "DETAIL_NAME")

	private String detailName; // 物料名称
	@Condition
	@Column(name = "ORDER_ID")

	private String orderId; // 请购单ID
	@Condition
	@Column(name = "DETAIL_MODEL")
	private String detailModel; // 物料型号
	@Condition
	@Column(name = "DETAIL_DATE")

	private String detailDate; // 需求日期
	@Condition
	@Column(name = "DETAIL_COUNT")

	private Integer detailCount; // 物料数量
	@Column(name = "TENANT_ID")
	@Condition
	private String tenantid;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(Serializable id) {
		this.id = id.toString();
		super.id = id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getMainBoCode() {
		return "PURCHASE_ORDER_DETAIL";
	}

	public String getDetailName() {
		return this.detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDetailModel() {
		return this.detailModel;
	}

	public void setDetailModel(String detailModel) {
		this.detailModel = detailModel;
	}

	public String getDetailDate() {
		return this.detailDate;
	}

	public void setDetailDate(String detailDate) {
		this.detailDate = detailDate;
	}

	public Integer getDetailCount() {
		return this.detailCount;
	}

	public void setDetailCount(Integer detailCount) {
		this.detailCount = detailCount;
	}

	@Override
	public String getBpmBillCode() {
		return DateUtil.format(new Date(), "yyyyMMddHHmmss" + new Random().nextInt(10));
	}

	@Override
	public String getTenantid() {
		return this.tenantid;
	}

	@Override
	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}

}
