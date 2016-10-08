package com.mongodb.demo;


import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * mongodb 连接
 * @author Administrator
 *
 */
public class DBConnection {

	public static void main(String[] args) {
		try {
			//====== 1、创建collections集合 ========
			//getMongoDatabase().createCollection("myFirstMongo");
			//System.out.println("集合创建成功!");
			
			//====== 2、 获取集合collection =======
			MongoCollection<Document> conCollection = getMongoDatabase().getCollection("myFirstMongo") ;
			//System.out.println("集合获取成功！集合长度:"+conCollection.count());
			
			// ==== 3、集合中插入数据 ==============
			/*Document document = new Document("title", "MongoDB").  
		         append("description", "database").  
		         append("likes", 100).  
		         append("by", "Fly");  
	         List<Document> documents = new ArrayList<Document>();  
	         documents.add(document);  
	         conCollection.insertMany(documents);  
	         System.out.println("文档插入成功");  */
		   // ====== 4、遍历集合Collection ====
			FindIterable<Document> findIterable = conCollection.find() ;
			MongoCursor<Document> mongoCursor = findIterable.iterator();
			while (mongoCursor.hasNext()) {
				System.out.println(mongoCursor.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 数据库连接
	 * @return
	 */
	@SuppressWarnings("resource")
	public static MongoDatabase getMongoDatabase(){
		MongoClient mongoClient = new MongoClient("localhost",27017); 
		MongoDatabase mongoDatabase = mongoClient.getDatabase("mongodb") ;
		System.out.println("mongodb连接成功!"+mongoDatabase.getName());
		return mongoDatabase ;
	}
	

}
