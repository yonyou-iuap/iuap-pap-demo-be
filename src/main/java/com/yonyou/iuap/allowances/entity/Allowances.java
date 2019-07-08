package com.yonyou.iuap.allowances.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.allowances.constant.*;
import com.yonyou.iuap.baseservice.bpm.entity.AbsBpmModel;
import com.yonyou.iuap.baseservice.entity.MultiTenant;
import com.yonyou.iuap.baseservice.entity.annotation.CodingEntity;
import com.yonyou.iuap.baseservice.entity.annotation.CodingField;
import com.yonyou.iuap.baseservice.entity.annotation.Reference;
import com.yonyou.iuap.baseservice.print.entity.Printable;
import com.yonyou.iuap.baseservice.statistics.support.StatFunctions;
import com.yonyou.iuap.baseservice.statistics.support.StatisticsField;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.condition.Match;
import com.yonyou.iuap.baseservice.support.generator.GeneratedValue;
import com.yonyou.iuap.enumeration.entity.anno.EnumValue;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 员工津贴记录N
 * 
 * @date 2018年11月05日 下午02点23分42秒
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "IUAPD_ALLOWANCES")
@CodingEntity(codingField = "code")
public class Allowances extends AbsBpmModel implements Serializable, Printable, MultiTenant {

	@Id
	@GeneratedValue
	@Condition
	@StatisticsField(functions = { StatFunctions.count })
	protected String id;// ID
	@Transient
	private String deptName; // 部门
	@Condition(match = Match.LIKE)
	@Column(name = "CODE")
	@CodingField(code = "iuapd_asval")
	private String code; // 员工编号
	@Condition
	@Column(name = "SERVICE_YEARS_COMPANY")
	private Integer serviceYearsCompany; // 司龄
	@Condition
	@Column(name = "PICK_TIME")
	private String pickTime; // 领取时间
	@Condition
	@Column(name = "POST_LEVEL")
	@Reference(code = "post_level", srcProperties = { "code" }, desProperties = { "levelName" })
	private String postLevel; // 职级
	@Condition(match = Match.EQ)
	@Column(name = "YEAR")
	private String year; // 年份
	@EnumValue(value = SexEnum.class, des = "sexEnumValue")
	@Condition
	@Column(name = "SEX")
	private Integer sex; // 员工性别
	@Transient
	private String sexEnumValue; // 员工性别
	@Condition
	@Column(name = "ALLOWANCE_STANDARD")
	private BigDecimal allowanceStandard; // 补贴标准
	@Condition
	@Column(name = "REMARK")
	private String remark; // 备注
	@Transient
	private String levelName; // 职级
	@Condition
	@Column(name = "DEPT")
	@Reference(code = "newdept", srcProperties = { "refname" }, desProperties = { "deptName" })
	private String dept; // 所属部门
	@EnumValue(value = ExdeedsEnum.class, des = "exdeedsEnumValue")
	@Condition(match = Match.EQ)
	@Column(name = "EXDEEDS")
	private Integer exdeeds; // 是否超标
	@Transient
	private String exdeedsEnumValue; // 是否超标
	@Condition
	@Column(name = "ALLOWANCE_ACTUAL")
	@StatisticsField(functions = { StatFunctions.sum })
	private BigDecimal allowanceActual; // 实际补贴
	@EnumValue(value = AllowanceTypeEnum.class, des = "allowanceTypeEnumValue")
	@Condition
	@Column(name = "ALLOWANCE_TYPE")
	private Integer allowanceType; // 补贴类别
	@Transient
	private String allowanceTypeEnumValue; // 补贴类别
	@EnumValue(value = MonthEnum.class, des = "monthEnumValue")
	@Condition(match = Match.EQ)
	@Column(name = "MONTH")
	private Integer month; // 月份
	@Transient
	private String monthEnumValue; // 月份
	@EnumValue(value = PickTypeEnum.class, des = "pickTypeEnumValue")
	@Condition
	@Column(name = "PICK_TYPE")
	private Integer pickType; // 领取方式
	@Transient
	private String pickTypeEnumValue; // 领取方式
	@Condition(match = Match.LIKE)
	@Column(name = "NAME")
	private String name; // 员工姓名
	@Condition
	@Column(name = "SERVICE_YEARS")
	private Integer serviceYears; // 工龄
	@Condition
	@Column(name = "APPLY_TIME")
	private String applyTime; // 申请时间
	@Column(name = "TENANT_ID")
	@Condition(match = Match.EQ)
	private String tenantid;
	@Condition(match = Match.LIKE)
	@Column(name = "NAME2")
	private String name2; // 员工姓名2
	@Condition(match = Match.LIKE)
	@Column(name = "NAME3")
	private String name3; // 员工姓名3
	@Condition(match = Match.LIKE)
	@Column(name = "NAME4")
	private String name4; // 员工姓名4
	@Condition(match = Match.LIKE)
	@Column(name = "NAME5")
	private String name5; // 员工姓名5
	@Condition(match = Match.LIKE)
	@Column(name = "NAME6")
	private String name6; // 员工姓名6

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
		return "ALLOWANCES";
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getServiceYearsCompany() {
		return this.serviceYearsCompany;
	}

	public void setServiceYearsCompany(Integer serviceYearsCompany) {
		this.serviceYearsCompany = serviceYearsCompany;
	}

	public String getPickTime() {
		return this.pickTime;
	}

	public void setPickTime(String pickTime) {
		this.pickTime = pickTime;
	}

	public String getPostLevel() {
		return postLevel;
	}

	public void setPostLevel(String postLevel) {
		this.postLevel = postLevel;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getSexEnumValue() {
		return this.sexEnumValue;
	}

	public void setSexEnumValue(String sexEnumValue) {
		this.sexEnumValue = sexEnumValue;
	}

	public BigDecimal getAllowanceStandard() {
		return this.allowanceStandard;
	}

	public void setAllowanceStandard(BigDecimal allowanceStandard) {
		this.allowanceStandard = allowanceStandard;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Integer getExdeeds() {
		return this.exdeeds;
	}

	public void setExdeeds(Integer exdeeds) {
		this.exdeeds = exdeeds;
	}

	public String getExdeedsEnumValue() {
		return this.exdeedsEnumValue;
	}

	public void setExdeedsEnumValue(String exdeedsEnumValue) {
		this.exdeedsEnumValue = exdeedsEnumValue;
	}

	public BigDecimal getAllowanceActual() {
		return this.allowanceActual;
	}

	public void setAllowanceActual(BigDecimal allowanceActual) {
		this.allowanceActual = allowanceActual;
	}

	public Integer getAllowanceType() {
		return this.allowanceType;
	}

	public void setAllowanceType(Integer allowanceType) {
		this.allowanceType = allowanceType;
	}

	public String getAllowanceTypeEnumValue() {
		return this.allowanceTypeEnumValue;
	}

	public void setAllowanceTypeEnumValue(String allowanceTypeEnumValue) {
		this.allowanceTypeEnumValue = allowanceTypeEnumValue;
	}

	public Integer getMonth() {
		return this.month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getMonthEnumValue() {
		return this.monthEnumValue;
	}

	public void setMonthEnumValue(String monthEnumValue) {
		this.monthEnumValue = monthEnumValue;
	}

	public Integer getPickType() {
		return this.pickType;
	}

	public void setPickType(Integer pickType) {
		this.pickType = pickType;
	}

	public String getPickTypeEnumValue() {
		return this.pickTypeEnumValue;
	}

	public void setPickTypeEnumValue(String pickTypeEnumValue) {
		this.pickTypeEnumValue = pickTypeEnumValue;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getServiceYears() {
		return this.serviceYears;
	}

	public void setServiceYears(Integer serviceYears) {
		this.serviceYears = serviceYears;
	}

	public String getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	@Override
	public String getBpmBillCode() {
		return getCode();
	}

	@Override
	public String getTenantid() {
		return this.tenantid;
	}

	@Override
	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public String getName4() {
		return name4;
	}

	public void setName4(String name4) {
		this.name4 = name4;
	}

	public String getName5() {
		return name5;
	}

	public void setName5(String name5) {
		this.name5 = name5;
	}

	public String getName6() {
		return name6;
	}

	public void setName6(String name6) {
		this.name6 = name6;
	}
}
