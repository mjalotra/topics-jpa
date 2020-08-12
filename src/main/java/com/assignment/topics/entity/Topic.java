package com.assignment.topics.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Topic implements Serializable{

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "pTopic")
	private List<Topic> subTopics = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name="SUB_TOPICS", joinColumns = @JoinColumn(name = "SUB_TOPIC_ID"), 
		inverseJoinColumns = @JoinColumn(name = "TOPIC_ID"), uniqueConstraints = @UniqueConstraint(columnNames = {"TOPIC_ID","SUB_TOPIC_ID" }))
	private Topic pTopic;
	
	@ManyToMany
	@JoinTable(name = "LINKED_TOPICS", joinColumns = @JoinColumn(name = "TOPIC_ID"), 
	inverseJoinColumns = @JoinColumn(name = "LINKED_TOPIC_ID"))
	private List<Topic> linkedTopics = new ArrayList<>();
	
	@ManyToMany(mappedBy = "linkedTopics")
	private List<Topic> siblingTopics = new ArrayList<>();;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Topic> getSubTopics() {
		return subTopics;
	}

	public void setSubTopics(List<Topic> subTopics) {
		this.subTopics = subTopics;
	}

	public List<Topic> getLinkedTopics() {
		return linkedTopics;
	}

	public void addLinkedTopics(Topic linkedTopic) {
		this.linkedTopics.add(linkedTopic);
	}

	public List<Topic> getSiblingTopics() {
		return siblingTopics;
	}

	public void setSiblingTopics(Topic siblingTopic) {
		this.siblingTopics.add(siblingTopic);
	}

	public Topic getTopics() {
		return pTopic;
	}

	public void setTopics(Topic topics) {
		this.pTopic = topics;
	}

	@Override
	public String toString() {
		return "\nTopics [id=" + id + ", name=" + name
				+ "]";
	}	
}
