package com.yonyou.iuap.tree.service;

import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.enumeration.utils.EnumValueUtils;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.tree.entity.TreeDemo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeDemoEnumService implements QueryFeatureExtension<TreeDemo> {

	@Override
	public List<TreeDemo> afterListQuery(List<TreeDemo> list) {
		return EnumValueUtils.i18nEnumEntityKeyToValue(list, TreeDemo.class);
	}

	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}
}
