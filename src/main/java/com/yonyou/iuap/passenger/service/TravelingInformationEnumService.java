package com.yonyou.iuap.passenger.service;

import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.enumeration.utils.EnumValueUtils;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.passenger.entity.TravelingInformation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelingInformationEnumService implements QueryFeatureExtension<TravelingInformation> {

	@Override
	public List<TravelingInformation> afterListQuery(List<TravelingInformation> list) {
		return EnumValueUtils.i18nEnumEntityKeyToValue(list, TravelingInformation.class);
	}

	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}
}
