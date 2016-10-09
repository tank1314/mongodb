package com.mongodb.demo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDataBaseInstance {
	
	private static MongoClient mongoClient = null ;
	private static MongoDatabase mongoDatabase = null ;
	public static MongoDatabase getInstance(){
		// 初次判斷是否为空
		if(mongoDatabase == null){
			synchronized(MongoDataBaseInstance.class){
				//当有两个线程来访问时，A、B 
				//当A进入时，B在if条件外等待 当A 执行完毕B判断instance是否为空
				if(mongoDatabase == null){
					mongoClient = new MongoClient("localhost",27017); 
					mongoDatabase = mongoClient.getDatabase("mongodb") ;
					System.out.println("=====mongodb连接成功======");
				}
			}
		}
		return mongoDatabase ;
	}
}
