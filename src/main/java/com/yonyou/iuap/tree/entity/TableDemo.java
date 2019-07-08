package com.yonyou.iuap.tree.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.allowances.constant.SexEnum;
import com.yonyou.iuap.baseservice.entity.AbsDrModel;
import com.yonyou.iuap.baseservice.entity.MultiTenant;
import com.yonyou.iuap.baseservice.entity.annotation.CodingEntity;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.generator.GeneratedValue;
import com.yonyou.iuap.enumeration.entity.anno.EnumValue;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 表TableDemo
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "IUAPD_TREELIST_DETAIL")
@CodingEntity(codingField = "")
public class TableDemo extends AbsDrModel implements Serializable, MultiTenant {
	@Id
	@GeneratedValue
	@Condition
	protected String id;// ID
	@Condition
	@Column(name = "TREE_ID")
	private String treeId; // 树ID
	@Condition
	@Column(name = "CODE")
	private String code; // 工号
	@EnumValue(value = SexEnum.class, des = "sexEnumValue")
	@Condition
	@Column(name = "SEX")
	private Integer sex; // 性别
	@Transient
	private String sexEnumValue; // 性别
	@Condition
	@Column(name = "NAME")
	private String name; // 姓名
	@Condition
	@Column(name = "AGE")
	private Integer age; // 年龄
	@Column(name = "TENANT_ID")
	@Condition
	private String tenantid;
	@Condition
	@Column(name = "NAME2")
	private String name2; // 姓名2
	@Condition
	@Column(name = "NAME3")
	private String name3; // 姓名3
	@Condition
	@Column(name = "NAME4")
	private String name4; // 姓名4
	@Condition
	@Column(name = "NAME5")
	private String name5; // 姓名5
	@Condition
	@Column(name = "NAME6")
	private String name6; // 姓名6

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

	public String getTreeId() {
		return this.treeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
