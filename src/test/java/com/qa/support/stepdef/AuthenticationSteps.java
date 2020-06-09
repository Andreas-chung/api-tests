package com.qa.support.stepdef;

import com.qa.models.LoginDetails;
import com.qa.support.rest.RestClient;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

import static com.qa.support.rest.Paths.LOGIN;

public class AuthenticationSteps {

    @Autowired
    private RestClient restClient;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @When("the following user attempts to login:")
    public void loginWithData(DataTable dt) {
        Map<String, String> data = dt.asMaps().get(0);
        login(new LoginDetails(data.get("username"), data.get("password")));
    }

    @Given("a logged in user")
    public void aLoggedInUser() {
        login(new LoginDetails(username, password));
    }

    public Response login(Object body) {
        return restClient.post(LOGIN, body);
    }
}
