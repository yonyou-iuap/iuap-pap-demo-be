package com.yonyou.iuap.passenger.entity;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.bpm.entity.AbsBpmModel;
import com.yonyou.iuap.baseservice.entity.MultiTenant;
import com.yonyou.iuap.baseservice.entity.annotation.CodingEntity;
import com.yonyou.iuap.baseservice.print.entity.Printable;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.generator.GeneratedValue;
import com.yonyou.iuap.enumeration.entity.anno.EnumValue;
import com.yonyou.iuap.passenger.constant.PayStatusEnum;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * 乘车预定信息
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "IUAPD_TRAVELING_INFORMATION")
@CodingEntity(codingField = "")
public class TravelingInformation extends AbsBpmModel implements Serializable, MultiTenant, Printable {
	@Id
	@GeneratedValue
	@Condition
	protected String id;// ID
	@Condition
	@Column(name = "COST")
	private BigDecimal cost; // 费用
	@Condition
	@Column(name = "LINE")
	private String line; // 乘车线路
	@Condition
	@Column(name = "STATION_END")
	private String stationEnd; // 下车站点
	@Condition
	@Column(name = "PASSENGER_ID")
	private String passengerId; // 员工编号
	@Condition
	@Column(name = "REMARK")
	private String remark; // 备注
    @EnumValue(value = PayStatusEnum.class, des = "payStatusEnumValue")
	@Condition
	@Column(name = "PAY_STATUS")
	private Integer payStatus; // 支付状态
	@Transient
	private String payStatusEnumValue; // 支付状态
	@Condition
	@Column(name = "STATION_BEGIN")
	private String stationBegin; // 上车站点
	@Column(name = "TENANT_ID")
	@Condition
	private String tenantid;
	@Column(name="TRAVEL_TIME")
	@Condition
	private String travelTime;

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
		return "TRAVELING_INFORMATION";
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getLine() {
		return this.line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getStationEnd() {
		return this.stationEnd;
	}

	public void setStationEnd(String stationEnd) {
		this.stationEnd = stationEnd;
	}

	public String getPassengerId() {
		return this.passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getPayStatusEnumValue() {
		return this.payStatusEnumValue;
	}

	public void setPayStatusEnumValue(String payStatusEnumValue) {
		this.payStatusEnumValue = payStatusEnumValue;
	}

	public String getStationBegin() {
		return this.stationBegin;
	}

	public void setStationBegin(String stationBegin) {
		this.stationBegin = stationBegin;
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

	public String getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	
	
	
}
