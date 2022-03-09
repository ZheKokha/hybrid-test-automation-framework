package com.pet.project.api.utils;

import com.pet.project.api.pojos.StorePojo;
import org.bouncycastle.util.Store;

public class OrderGenerator {

    public static StorePojo getSimpleOrder() {
        return StorePojo.builder()
                .id(1)
                .petId(12)
                .quantity(1)
                .status("booked")
                .complete(true)
                .build();
    }
}
