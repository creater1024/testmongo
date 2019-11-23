package com.example.testmongo.service;

//import com.example.testmongo.config.MongoConfig;
import com.example.testmongo.dao.UserDao;
import com.example.testmongo.entity.User;
import com.google.gson.Gson;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
//    @Autowired
//    MongoConfig mongoConfig;

//    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void insertList() {
        ArrayList<User> users = new ArrayList<User>();
        List<Document> list=new ArrayList<>();
        Gson gson = new Gson();
        for (int i = 0; i < 5000; i++) {
            User user = new User("collection" + i, "name" + i, "jklh" + i);
            if (i == 4999) {
                user.setPassword(null);
            }
            String json = gson.toJson(user);
            Document doc = Document.parse(json);
            list.add(doc);
        }
        long start = System.currentTimeMillis();
        List<User> resUsers = null;
        final MongoClient client = MongoClients.create("mongodb://10.95.14.38:27018");
        MongoCollection<Document> coll1 = client.getDatabase("oscert").getCollection("manager");
        try (ClientSession session = client.startSession()) {
            try {
                session.startTransaction();
                coll1.insertMany(session, list);
//                int i=14/0;
//                coll1.insertOne(session, new Document("2",31));
                session.commitTransaction();
            } catch (Exception e) {
                System.out.println("异常了:" + e);
//                userDao.deleteUser(users.get(20));
                session.abortTransaction();
            }
            long end = System.currentTimeMillis();
            // System.out.println("resUsers.size:"+resUsers.size());
            System.out.println("批量插入耗时: " + (end - start) + " ms");
        }
    }

    public void insert(User user){
        try{
            User inUser=userDao.insertUser(user);
        }
        catch (Exception e) {
            System.out.println("异常了:"+e);
            // 插入id与库中重复的话会报 org.springframework.dao.DuplicateKeyException 异常
        }
        System.out.println(user);
    }

    @Transactional(value = "MONGO_TRANSACTION_MANAGER", propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public void bathSave(Boolean rollBack) throws Exception {
        ArrayList<User> users = new ArrayList<User>();
        for (int i = 0; i < 5000; i++) {
            User user = new User("collection"+i,"name"+i,"jklh"+i);
            if(i==4999){
                user.setPassword(null);
            }
            users.add(user);
        }
        long start = System.currentTimeMillis();
        List<User> resUsers = null;
        try {
            resUsers = userDao.insertCollection(users);
//            for(int i=0; i<users.size(); i++){
//                userDao.insertUser(users.get(i));
//                if(i==20){
//                    throw new Exception("测试回滚");
//                }
//            }
        } catch (Exception e) {
            System.out.println("异常了:"+e);
            // 插入id与库中重复的话会报 org.springframework.dao.DuplicateKeyException 异常
        }
        long end = System.currentTimeMillis();
        // System.out.println("resUsers.size:"+resUsers.size());
        System.out.println("批量插入耗时: "+(end-start)+" ms");
    }

}
