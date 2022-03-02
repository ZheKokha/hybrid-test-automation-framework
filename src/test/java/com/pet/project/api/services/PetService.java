package com.pet.project.api.services;

import com.pet.project.api.pojos.DeleteResponse;
import com.pet.project.api.pojos.PetInfoFull;

import static io.restassured.RestAssured.given;

public class PetService extends RestService{

    @Override
    protected String getBasePath() {
        return "/pet";
    }

    public PetService() {
        super();
    }

    public PetInfoFull addNewPet(PetInfoFull request){
        return given().spec(REQUEST_SPECIFICATION).body(request).post().as(PetInfoFull.class);
    }

    public PetInfoFull getPet(int id){
        return given().spec(REQUEST_SPECIFICATION)
                .get("/" + id)
                .as(PetInfoFull.class);
    }

    public DeleteResponse deletePet(int id){
        return given().spec(REQUEST_SPECIFICATION)
                .delete("/" + id)
                .as(DeleteResponse.class);
    }
}
