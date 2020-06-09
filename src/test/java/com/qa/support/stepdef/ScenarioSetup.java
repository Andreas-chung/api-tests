package com.qa.support.stepdef;

import com.qa.support.World;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = World.class)
@Slf4j
public class ScenarioSetup {

    @Autowired
    private World world;

    @Before
    public void testSetup(){
        log.info("Starting tests...");
    }

    @After
    public void testTearDown(){
        log.info("Tearing down tests...");
        world.flushAll();
    }
}
