--initital startup sample data for topics
--insert topics data
insert into topic(id, name) values (10001, 'Root-Topic');
insert into topic(id, name) values (10002, 'Topic1');
insert into topic(id, name) values (10003, 'Topic2');
insert into topic(id, name) values (10004, 'Root-Topic2');
insert into topic(id, name) values (10005, 'Topic3');
insert into topic(id, name) values (10006, 'Topic4');
insert into topic(id, name) values (10007, 'Topic5');
insert into topic(id, name) values (10008, 'Topic6');
insert into topic(id, name) values (10009, 'Topic7');
insert into topic(id, name) values (10010, 'Topic8');
insert into topic(id, name) values (10011, 'Topic9');
insert into topic(id, name) values (10012, 'Topic10');
insert into topic(id, name) values (10013, 'Topic11');

--insert sub-topics data, 
--here 10006 has exact one child and one parent
--10012, 10010, 10005,10008, 10011 are kept at 3rd heirarchy level
insert into sub_topics(topic_id, sub_topic_id) values (10001, 10013);
insert into sub_topics(topic_id, sub_topic_id) values (10001, 10002);
insert into sub_topics(topic_id, sub_topic_id) values (10001, 10009);
insert into sub_topics(topic_id, sub_topic_id) values (10002, 10012);
insert into sub_topics(topic_id, sub_topic_id) values (10002, 10010);
insert into sub_topics(topic_id, sub_topic_id) values (10004, 10006);
insert into sub_topics(topic_id, sub_topic_id) values (10004, 10007);
insert into sub_topics(topic_id, sub_topic_id) values (10007, 10008);
insert into sub_topics(topic_id, sub_topic_id) values (10007, 10011);
insert into sub_topics(topic_id, sub_topic_id) values (10006, 10005);

--insert statements for linked topics
--here 10001, are linked with atleast with 3 topics
insert into linked_topics(topic_id, linked_topic_id) values (10001, 10002);
insert into linked_topics(topic_id, linked_topic_id) values (10001, 10004);
insert into linked_topics(topic_id, linked_topic_id) values (10001, 10012);
insert into linked_topics(topic_id, linked_topic_id) values (10001, 10013);
insert into linked_topics(topic_id, linked_topic_id) values (10004, 10001);
insert into linked_topics(topic_id, linked_topic_id) values (10004, 10013);
;
insert into linked_topics(topic_id, linked_topic_id) values (10002, 10001);
insert into linked_topics(topic_id, linked_topic_id) values (10012, 10001);
insert into linked_topics(topic_id, linked_topic_id) values (10013, 10001);
insert into linked_topics(topic_id, linked_topic_id) values (10013, 10004);




