package com.pet.project.api.pojos;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetInfoFull {

    private int id;
    private CategoryPojo category;
    private String name;
    private List<String> photoUrls;
    private ArrayList<TagPojo> tags;
    private String status;
}
