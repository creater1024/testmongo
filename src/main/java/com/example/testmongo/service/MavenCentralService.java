package com.example.testmongo.service;

import com.example.testmongo.dao.MavenCentral1Dao;
import com.example.testmongo.dao.MavenCentralDao;
import com.example.testmongo.entity.MavenCentral;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class MavenCentralService {
    @Autowired
    MavenCentralDao mavenCentralDao;
    @Autowired
    MavenCentral1Dao mavenCentral1Dao;

    @Transactional(value = "MONGO_TRANSACTION_MANAGER", propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public void mavenCentralSave(int n) throws Exception {
        List<MavenCentral> mavenCentrals=mavenCentralDao.findAll();
//        for(int i=0;(i+1)*10000<bugList.size();i++){
//            List<Bug> list=bugList.subList(i,(i+1)*10000);
//
//        }
        long start = System.currentTimeMillis();
        try {
            mavenCentral1Dao.insertMaven(mavenCentrals);

        } catch (Exception e) {
            log.error("插入数据异常", e);
        }
        long end = System.currentTimeMillis();

        log.info("批量插入耗时: {} ms ", end-start);
        if(1==n){
            throw new Exception("测试回滚");
        }
    }

}
