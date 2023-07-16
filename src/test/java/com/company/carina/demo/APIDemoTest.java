package com.company.carina.demo;

import com.company.carina.demo.api.DeleteOrderMethod;
import com.company.carina.demo.api.GetOrderMethod;
import com.company.carina.demo.api.PostOrderMethod;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import dev.failsafe.internal.util.Assert;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APIDemoTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test()
    @MethodOwner(owner = "apidemo")
    public void testCreateOrder() throws Exception {
        LOGGER.info("POST REQUEST");
        PostOrderMethod api = new PostOrderMethod();
        api.setProperties("api/order/order.properties");
        //call to endpoints
        Response response = api.callAPIExpectSuccess();
        String id = response.jsonPath().getString("id");
        LOGGER.info(id);
        //validate the response
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "apidemo")
    public void testCreateOrderMissingSomeFields() throws Exception {
        LOGGER.info("POST REQUEST");
        PostOrderMethod api = new PostOrderMethod();
        api.setProperties("api/order/order.properties");
        //removing optional field
        api.getProperties().remove("status");
        //call to endpoints
        api.callAPIExpectSuccess();
        //validate the response
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "apidemo")
    public void testGetOrder() {
        LOGGER.info("GET REQUEST");
        GetOrderMethod getOrderMethod = new GetOrderMethod();
        getOrderMethod.setProperties("api/order/order.properties");
        Response response = getOrderMethod.callAPIExpectSuccess();
        String id = response.jsonPath().getString("id");
        LOGGER.info(id);
        getOrderMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        //validate the schema
        LOGGER.info("Checking Json Schema");
        getOrderMethod.validateResponseAgainstSchema("api/order/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "apidemo")
    public void testDeleteOrder() {
        LOGGER.info("DELETE REQUEST");
        DeleteOrderMethod deleteOrderMethod = new DeleteOrderMethod();
        deleteOrderMethod.setProperties("api/order/order.properties");
        //Sending request to delete record
        Response response = deleteOrderMethod.callAPIExpectSuccess();
        String id = response.jsonPath().getString("message");
        LOGGER.info("Deleted Order id :" + id);
        deleteOrderMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

}

