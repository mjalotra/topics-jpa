package com.assignment.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.assignment.topics.service.ITopicsService;

@SpringBootApplication
public class TopicsApplication implements CommandLineRunner{

	@Autowired
	private ITopicsService topicsService;
	
	public static void main(String[] args) {
		SpringApplication.run(TopicsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("======== Assigment output =========");
//		find all Topic which are linked with at least three Topics
		System.out.println("\nPoint 4 :: Linked topics \n"+ topicsService.findTopicsByLinkCount(3));
		
//		Topic which are having one child and one parent
		System.out.println("\nPoint 5 :: One Child, one parent is by default with one to many \n"+ topicsService.findTopicsWithOneChild());
		
//		Topic which are placed at 3rd level in the hierarchy
		System.out.println("\nPoint 6 :: 3rd Level in heirrarchy\n"+ topicsService.findTopicsAtThirdLevel());
	}

}
