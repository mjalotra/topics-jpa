package com.assignment.topics.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.topics.entity.Topic;

@Repository
public interface TopicsJpaRepository extends JpaRepository<Topic, Long> {
	
	@Query("select t from Topic t where size(t.linkedTopics) >= :linkedTopicCounts")
	public Collection<Topic> findTopicsByLinkCount(@Param("linkedTopicCounts") int linkedTopicCounts);
	
	@Query("select t from Topic t where size(t.subTopics) = 1")
	public Collection<Topic> findTopicsWithOneChildAndParent();
	
	@Query("select t from Topic t where t.pTopic != null and t.pTopic.pTopic != null and t.pTopic.pTopic.pTopic = null")
	public Collection<Topic> findTopicsAtThirdLevel();
	
	
}
