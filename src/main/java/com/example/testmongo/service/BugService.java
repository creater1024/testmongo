package com.example.testmongo.service;

import com.example.testmongo.dao.BugDaoImpl;
import com.example.testmongo.dao.BugDao;
import com.example.testmongo.entity.Bug;
import com.google.gson.Gson;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BugService {
    @Autowired
    BugDao bugDao;

    @Autowired
    BugDaoImpl bugDaoImpl;

//    public void insert(int n){
//        List<Bug> bugList=bugDao.findAll();
//        Gson gson = new Gson();
//        List<Document> list=new ArrayList<>();
//        for (int i = 0; i < bugList.size(); i++) {
//            String json = gson.toJson(bugList.get(i));
//            Document doc = Document.parse( json);
//            list.add(doc);
//        }
//        long start = System.currentTimeMillis();
//        final MongoClient client = MongoClients.create("mongodb://10.95.14.38:27018");
//        MongoCollection<Document> coll1 = client.getDatabase("oscert").getCollection("bug");
//        try (ClientSession session = client.startSession()) {
//            try {
//                session.startTransaction();
//                coll1.insertMany(session, list);
//                if(1==n){
//                    throw new Exception("测试回滚");
//                }
////
////                coll1.insertOne(session, new Document("2",31));
//                session.commitTransaction();
//            } catch (Exception e) {
//                System.out.println("异常了:" + e);
//                session.abortTransaction();
//            }
//            long end = System.currentTimeMillis();
//            // System.out.println("resUsers.size:"+resUsers.size());
//            System.out.println("批量插入耗时: " + (end - start) + " ms");
//        }
//    }
//
//    @Transactional(value = "MONGO_TRANSACTION_MANAGER", propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
//    public void bugSave(int n) throws Exception {
////        List<Bug> bugList=bugDao.findAll();
////        for(int i=0;(i+1)*10000<bugList.size();i++){
////            List<Bug> list=bugList.subList(i,(i+1)*10000);
////
////        }
//        for(int i=0;i<n;i++){
//            long start = System.currentTimeMillis();
//            try {
//                bugDaoImpl.insertCollection(bugList);
//
//            } catch (Exception e) {
//                System.out.println("异常了:"+e);
//                // 插入id与库中重复的话会报 org.springframework.dao.DuplicateKeyException 异常
//            }
//            long end = System.currentTimeMillis();
//            // System.out.println("resUsers.size:"+resUsers.size());
//            System.out.println("批量插入耗时: "+(end-start)+" ms");
//        }
//        if(10==n){
//            throw new Exception("测试回滚");
//        }
//    }
    public Bug findBug(){
        return bugDaoImpl.selectBug("5db26fab758c813980d66689");
    }


    public void test(){
        int idstart=0;
        int idend=1000;
        while (idend<40000) {
            List<Bug> bugPage = bugDao.findAll(idstart,idend);
            bugDaoImpl.insertCollection(bugPage);
            idstart+=1000;
            idend+=1000;
        }
    }
}
