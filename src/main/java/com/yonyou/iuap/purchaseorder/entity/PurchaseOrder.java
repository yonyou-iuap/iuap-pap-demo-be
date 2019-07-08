package com.yonyou.iuap.purchaseorder.entity;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.bpm.entity.AbsBpmModel;
import com.yonyou.iuap.baseservice.entity.MultiTenant;
import com.yonyou.iuap.baseservice.entity.annotation.Associative;
import com.yonyou.iuap.baseservice.entity.annotation.CodingEntity;
import com.yonyou.iuap.baseservice.entity.annotation.CodingField;
import com.yonyou.iuap.baseservice.entity.annotation.Reference;
import com.yonyou.iuap.baseservice.print.entity.Printable;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.condition.Match;
import com.yonyou.iuap.baseservice.support.generator.GeneratedValue;
import com.yonyou.iuap.enumeration.entity.anno.EnumValue;
import com.yonyou.iuap.purchaseorder.constant.BpmStateEnum;
import com.yonyou.iuap.purchaseorder.constant.OrderTypeEnum;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * 请购单主表PurchaseOrder
 * 
 * @date 2018年11月05日 下午02点01分29秒
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "IUAPD_PURCHASE_ORDER")
@Associative(fkName = "orderId")
@CodingEntity(codingField = "orderCode")
public class PurchaseOrder extends AbsBpmModel implements Serializable, MultiTenant, Printable {
	
	@Transient
	public String bpmStateEnumValue;// 流程状态
	@Id
	@GeneratedValue
	@Condition
	protected String id;// ID
	@Condition
	@Column(name = "ORDER_USER")
	@Reference(code = "wbUser", srcProperties = { "refname" }, desProperties = { "orderUserName" })
	private String orderUser; // 请购单申请人
	@EnumValue(value = OrderTypeEnum.class, des = "orderTypeEnumValue")
	@Condition
	@Column(name = "ORDER_TYPE")
	private Integer orderType; // 请购单类型
	@Transient
	private String orderTypeEnumValue; // 请购单类型
	@Transient
	private String orderDeptName; // 请购单申请部门
	@Condition
	@Column(name = "ORDER_DEPT")
	@Reference(code = "newdept", srcProperties = { "refname" }, desProperties = { "orderDeptName" })
	private String orderDept; // 请购单申请部门
	@Condition(match = Match.LIKE)
	@Column(name = "ORDER_CODE")
	@CodingField(code = "masterdetail-one")
	private String orderCode; // 请购单编号
	@EnumValue(value = BpmStateEnum.class, des = "bpmStateEnumValue")
	@Condition(match = Match.EQ)
	@Column(name = "bpm_state")
	private Integer bpmState;
	@Condition
	@Column(name = "ORDER_PRICE")
	private BigDecimal orderPrice; // 请购单价格
	@Condition
	@Column(name = "ORDER_DATE")
	private String orderDate; // 请购单申请日期
	@Transient
	private String orderUserName; // 请购单申请人
	@Condition(match = Match.LIKE)
	@Column(name = "ORDER_NAME")
	private String orderName; // 请购单名称
	@Column(name = "TENANT_ID")
	@Condition
	private String tenantid;
	@Condition(match = Match.LIKE)
	@Column(name = "ORDER_NAME2")
	private String orderName2; // 请购单名称2
	@Condition(match = Match.LIKE)
	@Column(name = "ORDER_NAME3")
	private String orderName3; // 请购单名称3
	@Condition(match = Match.LIKE)
	@Column(name = "ORDER_NAME4")
	private String orderName4; // 请购单名称4
	@Condition(match = Match.LIKE)
	@Column(name = "ORDER_NAME5")
	private String orderName5; // 请购单名称5
	@Condition(match = Match.LIKE)
	@Column(name = "ORDER_NAME6")
	private String orderName6; // 请购单名称6

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
		return "PURCHASE_ORDER";
	}

	public String getOrderUser() {
		return this.orderUser;
	}

	public void setOrderUser(String orderUser) {
		this.orderUser = orderUser;
	}

	public Integer getOrderType() {
		return this.orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getOrderTypeEnumValue() {
		return this.orderTypeEnumValue;
	}

	public void setOrderTypeEnumValue(String orderTypeEnumValue) {
		this.orderTypeEnumValue = orderTypeEnumValue;
	}

	public String getOrderDeptName() {
		return this.orderDeptName;
	}

	public void setOrderDeptName(String orderDeptName) {
		this.orderDeptName = orderDeptName;
	}

	public String getOrderDept() {
		return this.orderDept;
	}

	public void setOrderDept(String orderDept) {
		this.orderDept = orderDept;
	}

	public String getOrderCode() {
		return this.orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	@Override
	public Integer getBpmState() {
		return bpmState;
	}

	@Override
	public void setBpmState(Integer bpmState) {
		this.bpmState = bpmState;
	}

	public BigDecimal getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderUserName() {
		return this.orderUserName;
	}

	public void setOrderUserName(String orderUserName) {
		this.orderUserName = orderUserName;
	}

	public String getOrderName() {
		return this.orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
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

	public String getBpmStateEnumValue() {
		return bpmStateEnumValue;
	}

	public void setBpmStateEnumValue(String bpmStateEnumValue) {
		this.bpmStateEnumValue = bpmStateEnumValue;
	}

	public String getOrderName2() {
		return orderName2;
	}

	public void setOrderName2(String orderName2) {
		this.orderName2 = orderName2;
	}

	public String getOrderName3() {
		return orderName3;
	}

	public void setOrderName3(String orderName3) {
		this.orderName3 = orderName3;
	}

	public String getOrderName4() {
		return orderName4;
	}

	public void setOrderName4(String orderName4) {
		this.orderName4 = orderName4;
	}

	public String getOrderName5() {
		return orderName5;
	}

	public void setOrderName5(String orderName5) {
		this.orderName5 = orderName5;
	}

	public String getOrderName6() {
		return orderName6;
	}

	public void setOrderName6(String orderName6) {
		this.orderName6 = orderName6;
	}
}
