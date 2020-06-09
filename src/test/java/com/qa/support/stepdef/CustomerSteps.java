package com.qa.support.stepdef;

import com.qa.models.Customer;
import com.qa.support.World;
import com.qa.support.rest.Paths;
import com.qa.support.rest.RestClient;
import com.qa.support.util.Util;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;


public class CustomerSteps {

    @Autowired
    private RestClient restClient;

    @Autowired
    private Util util;

    @Autowired
    private World world;

    @When("the user attempts to retrieve their details")
    public void retrieveCustomerDetails() {
        restClient.get(Paths.CUSTOMER_DETAILS);
    }

    @And("the user details includes the following:")
    public void theUserCustomerShouldIncludeTheFollowing(DataTable dt) throws IOException {
        Map<String, String> data = dt.asMaps().get(0);
        Customer customer = world.getLastResponseBody(Customer.class);
        data.forEach((k, v) -> Assert.assertEquals(v, customer.getProperty(k)));
    }
}
