package com.assignment.topics.util;

import org.springframework.stereotype.Component;

import com.assignment.topics.constant.QueryConstant;

@Component
public class QueryBuilder {
	
	public String buildNthLevelQuery(int level) {
		
		StringBuilder nthLevelTopicsQuery = QueryConstant.nLevelTopicsQuery;
		for(int i = 0; i< level; i++) {
			if(i==0) {
				nthLevelTopicsQuery.append("where ");
			}else {
				nthLevelTopicsQuery.append("and ");
			}
			nthLevelTopicsQuery.append("t");
			for(int j = 0; j<=i;j++) {
				nthLevelTopicsQuery.append(".pTopic");
			}
			if(i+1 == level) {
				nthLevelTopicsQuery.append(" = null ");
			}else{
				nthLevelTopicsQuery.append(" != null ");
			}
		}
		return nthLevelTopicsQuery.toString();
	}
}
