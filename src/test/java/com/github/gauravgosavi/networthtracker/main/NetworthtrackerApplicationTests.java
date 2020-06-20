package com.github.gauravgosavi.networthtracker.main;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
class NetworthtrackerApplicationTests {

    @Test
    void contextLoads() {
        Assert.assertTrue(true);
        //Sample test
    }

}
