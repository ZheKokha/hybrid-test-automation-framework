package com.pet.project.api.utils;

import com.pet.project.api.services.PetService;
import com.pet.project.api.services.StoreService;

public class RestWrapper {

    public PetService petService;
    public StoreService storeService;

    public RestWrapper(){
        petService = new PetService();
        storeService = new StoreService();
    }

}
