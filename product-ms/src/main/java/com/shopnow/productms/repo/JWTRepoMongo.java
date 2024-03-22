package com.shopnow.productms.repo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.shopnow.productms.conf.Mongo.MongoConf;
import jakarta.annotation.PostConstruct;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class JWTRepoMongo {
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    @Autowired
    private MongoConf mongoConf;

    @PostConstruct
    public void init() {
        this.database = mongoConf.mongoClient().getDatabase("shop-now-mongodb");
        this.collection = database.getCollection("jwtTokens", org.bson.Document.class);
    }

    public void saveJwtToken(String jwtToken) {
        org.bson.Document document = new org.bson.Document("jwtToken", jwtToken)
                .append("createdAt", System.currentTimeMillis());
        collection.insertOne(document);
    }

    public boolean isJwtTokenPresent(String jwtToken) {
        Document query = new Document("jwtToken", jwtToken);
        return collection.find(query).first() != null;
    }
}