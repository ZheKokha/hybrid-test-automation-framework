package com.pet.project.api.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class RestService {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    protected RequestSpecification REQUEST_SPECIFICATION;

    protected abstract String getBasePath();

    public RestService(){

        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(getBasePath())
                .setContentType(ContentType.JSON)
                .build();
    }
}
