package com.mongodb.demo;


import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * mongodb ����
 * @author Administrator
 *
 */
public class DBConnection {

	public static void main(String[] args) {
		try {
			//====== 1������collections���� ========
			//getMongoDatabase().createCollection("myFirstMongo");
			//System.out.println("���ϴ����ɹ�!");
			
			//====== 2�� ��ȡ����collection =======
			MongoCollection<Document> conCollection = getMongoDatabase().getCollection("myFirstMongo") ;
			//System.out.println("���ϻ�ȡ�ɹ������ϳ���:"+conCollection.count());
			
			// ==== 3�������в������� ==============
			/*Document document = new Document("title", "MongoDB").  
		         append("description", "database").  
		         append("likes", 100).  
		         append("by", "Fly");  
	         List<Document> documents = new ArrayList<Document>();  
	         documents.add(document);  
	         conCollection.insertMany(documents);  
	         System.out.println("�ĵ�����ɹ�");  */
		   // ====== 4����������Collection ====
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
	 * ���ݿ�����
	 * @return
	 */
	@SuppressWarnings("resource")
	public static MongoDatabase getMongoDatabase(){
		MongoClient mongoClient = new MongoClient("localhost",27017); 
		MongoDatabase mongoDatabase = mongoClient.getDatabase("mongodb") ;
		System.out.println("mongodb���ӳɹ�!"+mongoDatabase.getName());
		return mongoDatabase ;
	}
	

}
