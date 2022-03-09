package com.pet.project.api.test;

import com.pet.project.api.pojos.DeleteResponse;
import com.pet.project.api.pojos.StorePojo;
import com.pet.project.api.utils.OrderGenerator;
import com.pet.project.api.utils.RestWrapper;
import org.apache.hc.core5.util.Timeout;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StoreTest {

    private static RestWrapper restWrapper;

    @BeforeTest
    public static void prepareClient() throws InterruptedException {
        restWrapper = new RestWrapper();
        Timeout.ofSeconds(3).sleep();
    }

    @Test(description = "create new order in the store", priority = 1)
    public void createNewOrder() {
        StorePojo request = OrderGenerator.getSimpleOrder();
        StorePojo storeOrderResponse = restWrapper.storeService.addNewOrder(request);

        Assertions.assertThat(storeOrderResponse)
                .isNotNull()
                .extracting(StorePojo::getId)
                .isEqualTo(1);
    }
    @Test(description = "retrieve order information by id", priority = 2)
    public void getOrderById() {

        StorePojo petInfo = restWrapper.storeService.getOrderById(1);

        Assertions.assertThat(petInfo)
                .isNotNull()
                .extracting(StorePojo::getId)
                .isEqualTo(1);
    }

    @Test(description = "delete order information by id", priority = 3)
    public void deletePetById() {

        DeleteResponse petInfo = restWrapper.storeService.deleteOrderById(1);

        Assertions.assertThat(petInfo)
                .isNotNull()
                .extracting(DeleteResponse::getMessage)
                .isEqualTo(String.valueOf(1));
    }

}
