package com.pet.project.api.steps;

import com.pet.project.api.pojos.PetInfoFull;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PetSteps {

    private PetInfoFull petInfoFullResponse;

    public PetInfoFull getPetCreateResponse(PetInfoFull petInfoFullRequest) {
        petInfoFullResponse = given().body(petInfoFullRequest).post().as(PetInfoFull.class);
        return petInfoFullResponse;
    }

    public PetInfoFull getPetInfoResponse(PetInfoFull petInfoFullRequest) {
        petInfoFullResponse = given().body(petInfoFullRequest).post().as(PetInfoFull.class);
        return petInfoFullResponse;
    }

}
