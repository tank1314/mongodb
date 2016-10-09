package com.mongodb.demo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDataBaseInstance {
	
	private static MongoClient mongoClient = null ;
	private static MongoDatabase mongoDatabase = null ;
	public static MongoDatabase getInstance(){
		// �����Д��Ƿ�Ϊ��
		if(mongoDatabase == null){
			synchronized(MongoDataBaseInstance.class){
				//���������߳�������ʱ��A��B 
				//��A����ʱ��B��if������ȴ� ��A ִ�����B�ж�instance�Ƿ�Ϊ��
				if(mongoDatabase == null){
					mongoClient = new MongoClient("localhost",27017); 
					mongoDatabase = mongoClient.getDatabase("mongodb") ;
					System.out.println("=====mongodb���ӳɹ�======");
				}
			}
		}
		return mongoDatabase ;
	}
}
