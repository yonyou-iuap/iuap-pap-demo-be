package com.yonyou.iuap.purchaseorder.service;

import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.enumeration.utils.EnumValueUtils;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.purchaseorder.entity.PurchaseOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderEnumService implements QueryFeatureExtension<PurchaseOrder> {

	@Override
	public List<PurchaseOrder> afterListQuery(List<PurchaseOrder> list) {
		return EnumValueUtils.i18nEnumEntityKeyToValue(list, PurchaseOrder.class);
	}

	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}
}
