package com.yonyou.iuap.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.entity.AbsDrModel;
import com.yonyou.iuap.baseservice.entity.MultiTenant;
import com.yonyou.iuap.baseservice.entity.annotation.CodingEntity;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.generator.GeneratedValue;
import com.yonyou.iuap.enumeration.entity.anno.EnumValue;
import com.yonyou.iuap.model.constant.ModelTypeEnum;

import javax.persistence.*;
import java.io.Serializable;

/**
 * model测试
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "IUAPD_GRID_TEMP")
@CodingEntity(codingField = "")
@Entity
public class Model extends AbsDrModel implements Serializable, MultiTenant {
	@Id
	@GeneratedValue
	@Condition
	protected String id;// ID
	@Condition
	@Column(name = "MODEL_NAME")
	private String modelName; // 模型名称
	@Condition
	@Column(name = "MODEL_CODE")
	private String modelCode; // 模型编码
	@EnumValue(value = ModelTypeEnum.class, des = "modelTypeEnumValue")
	@Condition
	@Column(name = "MODEL_TYPE")
	private String modelType; // 模型类型
	@Transient
	private String modelTypeEnumValue; // 模型类型
	@Condition
	@Column(name = "MODEL_CONTENT")
	private String modelContent; // 模板内容
	@Column(name = "TENANT_ID")
	@Condition
	private String tenantid;
	@Condition
	@Column(name = "MODEL_NAME2")
	private String modelName2; // 模型名称2
	@Condition
	@Column(name = "MODEL_NAME3")
	private String modelName3; // 模型名称3
	@Condition
	@Column(name = "MODEL_NAME4")
	private String modelName4; // 模型名称4
	@Condition
	@Column(name = "MODEL_NAME5")
	private String modelName5; // 模型名称5
	@Condition
	@Column(name = "MODEL_NAME6")
	private String modelName6; // 模型名称6

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

	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelCode() {
		return this.modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getModelType() {
		return this.modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public String getModelTypeEnumValue() {
		return this.modelTypeEnumValue;
	}

	public void setModelTypeEnumValue(String modelTypeEnumValue) {
		this.modelTypeEnumValue = modelTypeEnumValue;
	}

	public String getModelContent() {
		return this.modelContent;
	}

	public void setModelContent(String modelContent) {
		this.modelContent = modelContent;
	}

	@Override
	public String getTenantid() {
		return this.tenantid;
	}

	@Override
	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}

	public String getModelName2() {
		return modelName2;
	}

	public void setModelName2(String modelName2) {
		this.modelName2 = modelName2;
	}

	public String getModelName3() {
		return modelName3;
	}

	public void setModelName3(String modelName3) {
		this.modelName3 = modelName3;
	}

	public String getModelName4() {
		return modelName4;
	}

	public void setModelName4(String modelName4) {
		this.modelName4 = modelName4;
	}

	public String getModelName5() {
		return modelName5;
	}

	public void setModelName5(String modelName5) {
		this.modelName5 = modelName5;
	}

	public String getModelName6() {
		return modelName6;
	}

	public void setModelName6(String modelName6) {
		this.modelName6 = modelName6;
	}

}
