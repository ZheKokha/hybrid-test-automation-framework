package com.pet.project.api.test;

import com.pet.project.api.pojos.DeleteResponse;
import com.pet.project.api.pojos.PetInfoFull;
import com.pet.project.api.utils.IdGenerator;
import com.pet.project.api.utils.PetGenerator;
import com.pet.project.api.utils.RestWrapper;
import org.apache.hc.core5.util.Timeout;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PetTest {

    private static final int ID = IdGenerator.getIdValue();
    private static RestWrapper restWrapper;

    @BeforeTest
    public static void prepareClient() throws InterruptedException {
        restWrapper = new RestWrapper();
        Timeout.ofSeconds(3).sleep();
    }

    @Test(description = "create new pet", priority = 1)
    public void createNewPet() {
        PetInfoFull request = PetGenerator.getSimplePet(ID);
        PetInfoFull petInfoFullResponse = restWrapper.petService.addNewPet(request);

        Assertions.assertThat(petInfoFullResponse)
                .isNotNull()
                .extracting(PetInfoFull::getId)
                .isEqualTo(ID);
    }

    @Test(description = "retrieve pet information by id", priority = 2)
    public void getPetById() {

        PetInfoFull petInfo = restWrapper.petService.getPet(ID);

        Assertions.assertThat(petInfo)
                .isNotNull()
                .extracting(PetInfoFull::getId)
                .isEqualTo(ID);
    }

    @Test(description = "delete pet information by id", priority = 3)
    public void deletePetById() {

        DeleteResponse petInfo = restWrapper.petService.deletePet(ID);

        Assertions.assertThat(petInfo)
                .isNotNull()
                .extracting(DeleteResponse::getMessage)
                .isEqualTo(String.valueOf(ID));
    }
}
