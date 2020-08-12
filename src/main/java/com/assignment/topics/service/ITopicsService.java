package com.assignment.topics.service;

import java.util.Collection;

import com.assignment.topics.entity.Topic;

public interface ITopicsService {
	
	public Collection<Topic> findTopicsByLinkCount(int numOfLinkedTopics);
	
	public Collection<Topic> findTopicsWithOneChild();
	
	public Collection<Topic> findTopicsAtThirdLevel();
}
