package com.example.testmongo;

import com.example.testmongo.service.BugService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoSaveTest {
    @Autowired
    BugService bugService;

    @Test
    public void testInsert() throws Exception {
        bugService.bugSave(10);
    }
}
