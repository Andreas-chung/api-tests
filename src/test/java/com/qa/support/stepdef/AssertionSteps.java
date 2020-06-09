package com.qa.support.stepdef;

import com.qa.support.World;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class AssertionSteps {

    @Autowired
    private World world;


    @Then("the user receives an OK response")
    public void receivesOk() {
        Assert.assertEquals(200, world.getLastResponse().code());
    }

    @Then("the user receives an Unauthorised response")
    public void receivesUnauthorised() {
        Assert.assertEquals(401, world.getLastResponse().code());
    }
}
