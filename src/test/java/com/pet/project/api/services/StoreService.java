package com.pet.project.api.services;

import com.pet.project.api.pojos.DeleteResponse;
import com.pet.project.api.pojos.PetInfoFull;
import com.pet.project.api.pojos.StorePojo;

import static io.restassured.RestAssured.given;

public class StoreService extends RestService {

    @Override
    protected String getBasePath() {
        return "/store";
    }

    public StoreService() {
        super();
    }

    public StorePojo addNewOrder(StorePojo request){
        return given().spec(REQUEST_SPECIFICATION).body(request).log().all().post("/order").as(StorePojo.class);
    }

    public StorePojo getOrderById(int id){
        return given().spec(REQUEST_SPECIFICATION)
                .log().all()
                .get("/order/" + id)
                .as(StorePojo.class);
    }

    public DeleteResponse deleteOrderById(int id){
        return given().spec(REQUEST_SPECIFICATION)
                .log().all()
                .delete("/order/" + id)
                .as(DeleteResponse.class);
    }
}
