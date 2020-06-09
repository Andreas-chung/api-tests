package com.qa.support;

import com.qa.support.util.Util;
import okhttp3.Response;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.LinkedList;

@Component
@Configuration
@ComponentScan
@PropertySource("classpath:application-local.properties")
public class World {

    private LinkedList<Response> responseList = new LinkedList<>();

    public void addResponse(Response response) {
        responseList.add(response);
    }

    public Response getLastResponse() {
        return responseList.getLast();
    }

    public <T> T getLastResponseBody(Class<T> type) throws IOException {
        String body = getLastResponse().body().string();
        return Util.fromJson(body, type);
    }

    public void flushAll(){
        responseList.clear();
    }

}
