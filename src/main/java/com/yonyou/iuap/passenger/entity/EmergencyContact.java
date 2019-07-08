package com.yonyou.iuap.passenger.entity;

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
 * 紧急联系人
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "IUAPD_EMERGENCY_CONTACT")
public class EmergencyContact extends AbsBpmModel implements Serializable, MultiTenant, Printable {

	@Id
	@GeneratedValue
	@Condition
	protected String id;// ID
	@Condition
	@Column(name = "CONTACT_RELATION")

	private String contactRelation; // 与联系人关系
	@Condition
	@Column(name = "CONTACT_NAME")

	private String contactName; // 联系人姓名
	@Condition
	@Column(name = "PASSENGER_ID")

	private String passengerId; // 员工编号
	@Condition
	@Column(name = "REMARK")

	private String remark; // 备注
	@Condition
	@Column(name = "CONTACT_PHONE")

	private String contactPhone; // 联系人电话
	@Column(name = "TENANT_ID")
	@Condition
	private String tenantid;
	@Condition
	@Column(name = "CONTACT_NAME2")
	private String contactName2; // 联系人姓名2
	@Condition
	@Column(name = "CONTACT_NAME3")
	private String contactName3; // 联系人姓名3
	@Condition
	@Column(name = "CONTACT_NAME4")
	private String contactName4; // 联系人姓名4
	@Condition
	@Column(name = "CONTACT_NAME5")
	private String contactName5; // 联系人姓名5
	@Condition
	@Column(name = "CONTACT_NAME6")
	private String contactName6; // 联系人姓名6

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
		return "EMERGENCY_CONTACT";
	}

	public String getContactRelation() {
		return this.contactRelation;
	}

	public void setContactRelation(String contactRelation) {
		this.contactRelation = contactRelation;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
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

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
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

	public String getContactName2() {
		return contactName2;
	}

	public void setContactName2(String contactName2) {
		this.contactName2 = contactName2;
	}

	public String getContactName3() {
		return contactName3;
	}

	public void setContactName3(String contactName3) {
		this.contactName3 = contactName3;
	}

	public String getContactName4() {
		return contactName4;
	}

	public void setContactName4(String contactName4) {
		this.contactName4 = contactName4;
	}

	public String getContactName5() {
		return contactName5;
	}

	public void setContactName5(String contactName5) {
		this.contactName5 = contactName5;
	}

	public String getContactName6() {
		return contactName6;
	}

	public void setContactName6(String contactName6) {
		this.contactName6 = contactName6;
	}
}
