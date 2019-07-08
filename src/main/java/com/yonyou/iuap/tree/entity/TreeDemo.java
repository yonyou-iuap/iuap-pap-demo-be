package com.yonyou.iuap.tree.entity;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.bpm.entity.AbsBpmModel;
import com.yonyou.iuap.baseservice.entity.MultiTenant;
import com.yonyou.iuap.baseservice.entity.annotation.Associative;
import com.yonyou.iuap.baseservice.entity.annotation.CodingEntity;
import com.yonyou.iuap.baseservice.print.entity.Printable;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.condition.Match;
import com.yonyou.iuap.baseservice.support.generator.GeneratedValue;
import com.yonyou.iuap.enumeration.entity.anno.EnumValue;
import com.yonyou.iuap.tree.constant.IsSonEnum;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 树结构
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "IUAPD_TREELIST")
@Associative(fkName = "treeId")
@CodingEntity(codingField = "")
public class TreeDemo extends AbsBpmModel implements Serializable, MultiTenant, Printable {
	@Id
	@GeneratedValue
	@Condition
	protected String id;// ID
	@EnumValue(value = IsSonEnum.class, des = "isSonEnumValue")
	@Condition
	@Column(name = "IS_SON")
	private Integer isSon; // 是否有子节点
	@Transient
	private String isSonEnumValue; // 是否有子节点
	@Condition(match = Match.LIKE)
	@Column(name = "NAME")
	private String name; // 名称
	@Condition(match = Match.EQ)
	@Column(name = "PARENTID")
	private String parentId; // 父节点
	@Column(name = "TENANT_ID")
	@Condition
	private String tenantid;
	@Column(name = "CODE")
	@Condition(match = Match.IN)
	private String code;
	@Transient
	private List<TreeDemo> children = new ArrayList<>(); //
	@Condition(match = Match.LIKE)
	@Column(name = "NAME2")
	private String name2; // 名称2
	@Condition(match = Match.LIKE)
	@Column(name = "NAME3")
	private String name3; // 名称3
	@Condition(match = Match.LIKE)
	@Column(name = "NAME4")
	private String name4; // 名称4
	@Condition(match = Match.LIKE)
	@Column(name = "NAME5")
	private String name5; // 名称5
	@Condition(match = Match.LIKE)
	@Column(name = "NAME6")
	private String name6; // 名称6

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
		return "TREE_DEMO";
	}

	public Integer getIsSon() {
		return this.isSon;
	}

	public void setIsSon(Integer isSon) {
		this.isSon = isSon;
	}

	public String getIsSonEnumValue() {
		return this.isSonEnumValue;
	}

	public void setIsSonEnumValue(String isSonEnumValue) {
		this.isSonEnumValue = isSonEnumValue;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<TreeDemo> getChildren() {
		return children;
	}

	public void setChildren(List<TreeDemo> children) {
		this.children = children;
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
