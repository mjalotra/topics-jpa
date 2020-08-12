package com.assignment.topics.service.impl;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.topics.entity.Topic;
import com.assignment.topics.repository.TopicsJpaRepository;
import com.assignment.topics.service.ITopicsService;

@Service
public class TopicsServiceImpl implements ITopicsService{
	
	@Autowired
	private TopicsJpaRepository topicsJpaRepository;
	
//	@Autowired
//	private QueryBuilder queryBuilder;
	
	@Transactional
	public Collection<Topic> findTopicsByLinkCount(int numOfLinkedTopics) {
		if(numOfLinkedTopics<=0) {
			throw new IllegalArgumentException("criteria for number of linked topics failed. Expected count greater than 0");
		}
		return topicsJpaRepository.findTopicsByLinkCount(numOfLinkedTopics);
	}
	
	@Transactional
	public Collection<Topic> findTopicsWithOneChild() {
		return topicsJpaRepository.findTopicsWithOneChildAndParent();
	}
	
	@Transactional
	public Collection<Topic> findTopicsAtThirdLevel() {
//		String nthLevelQuery = queryBuilder.buildNthLevelQuery(level);
		return topicsJpaRepository.findTopicsAtThirdLevel();
	}
	
}
