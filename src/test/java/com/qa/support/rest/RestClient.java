package com.qa.support.rest;

import com.qa.support.World;
import com.qa.support.util.Util;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Optional;

import static java.lang.String.format;


@Slf4j
@Component
public class RestClient {

    @Value("${baseUrl}")
    private String baseUrl;

    @Autowired
    private World world;

    private OkHttpClient client;

    @PostConstruct
    private void init() {
        client = new OkHttpClient();
    }

    public Response get(String path) {
        return sendRequest("GET", path, Optional.empty());
    }

    public <T> Response post(String path, T  body) {
        String json = body.getClass().equals(String.class) ? body.toString() : Util.toJson(body);
        return sendRequest("POST", path, Optional.of(json));
    }

    private Response sendRequest(String method, String path, Optional<String> json) {
        RequestBody body = json.isPresent() ? RequestBody.create(json.get(), MediaType.get("application/json; charset=utf-8")) : null;
        Request request = new Request.Builder()
                .url(baseUrl + path)
                .method(method, body)
                .build();

        try {
            log.info(format("Sending %s request - %s", request.method(), request.url()));
            Response response = client.newCall(request).execute();
            log.info(format("Received %s - %s", response.code(), response.request().url()));
            world.addResponse(response);
            return response;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
