package com.pet.project.api.utils;

import com.pet.project.api.pojos.CategoryPojo;
import com.pet.project.api.pojos.PetInfoFull;
import com.pet.project.api.pojos.TagPojo;

import java.util.ArrayList;
import java.util.Arrays;

public class PetGenerator {

    public static PetInfoFull getSimplePet(int id){

        ArrayList<TagPojo> tagPojos = new ArrayList<>();
        tagPojos.add(TagPojo.builder()
                .id(33)
                .name("tagName")
                .build());

        return PetInfoFull.builder()
                .category(CategoryPojo.builder()
                        .id(5)
                        .name("Cats")
                        .build())
                .tags(tagPojos)
                .photoUrls(Arrays.asList("photoUrl1", "photoUrl2"))
                .id(id)
                .name("Jinny")
                .status("Unavailable")
                .build();

    }
}
