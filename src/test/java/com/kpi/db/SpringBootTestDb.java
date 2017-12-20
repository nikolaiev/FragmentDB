package com.kpi.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vladyslav on 19.12.17.
 */
@SpringBootTest
@ContextConfiguration(classes = Lab5Application.class)
@Transactional("transactionManager")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringBootTestDb {

    @Test
    public void contextLoads() {
    }
}