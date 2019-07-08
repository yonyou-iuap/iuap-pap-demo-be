package com.yonyou.iuap.tree.service;

import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.enumeration.utils.EnumValueUtils;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.tree.entity.TableDemo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableDemoEnumService implements QueryFeatureExtension<TableDemo> {

	@Override
	public List<TableDemo> afterListQuery(List<TableDemo> list) {
		return EnumValueUtils.i18nEnumEntityKeyToValue(list, TableDemo.class);
	}

	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}
}
