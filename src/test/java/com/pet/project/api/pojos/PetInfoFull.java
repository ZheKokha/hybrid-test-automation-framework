package com.pet.project.api.pojos;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetInfoFull {

    public int id;
    public CategoryPojo category;
    public String name;
    public List<String> photoUrls;
    public ArrayList<TagPojo> tags;
    public String status;
}
