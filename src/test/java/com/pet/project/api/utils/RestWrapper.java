package com.pet.project.api.utils;

import com.pet.project.api.services.PetService;

public class RestWrapper {

    public PetService petService;

    public RestWrapper(){
        petService = new PetService();
    }

}
