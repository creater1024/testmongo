package com.example.testmongo.service;

import com.example.testmongo.config.MongoConfig;
import com.example.testmongo.dao.BugMongoDao;
import com.example.testmongo.dao.BugDao;
import com.example.testmongo.entity.Bug;
import com.google.gson.Gson;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BugService {
    @Autowired
    BugDao bugDao;

    @Autowired
    BugMongoDao bugMongoDao;
    @Autowired
    MongoConfig mongoConfig;

    @Transactional(value = "MONGO_TRANSACTION_MANAGER", propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public void bugSave(int n) throws Exception {
        List<Bug> bugList = bugDao.findAll();

        for(int i = 0; i < n; i++) {
            long start = System.currentTimeMillis();
            try {
                bugMongoDao.insertCollection(bugList);

            } catch (Exception e) {
                log.error("发生异常", e);
                // 插入id与库中重复的话会报 org.springframework.dao.DuplicateKeyException 异常
            }
            long end = System.currentTimeMillis();
            log.info("批量插入耗时: {} ms", end-start);
        }
        if(10==n){
            throw new Exception("测试回滚");
        }
    }

    public Bug findBug(String id){
        return bugMongoDao.selectBug(id);
    }

}
