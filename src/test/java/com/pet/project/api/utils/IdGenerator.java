package com.pet.project.api.utils;

import java.util.Random;

public class IdGenerator {

    static Random rand = new Random();

    public static int getIdValue(){
        return rand.nextInt(200000);
    }
}
