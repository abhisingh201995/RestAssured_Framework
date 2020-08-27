package com.Tests.ApiTest;


import com.Utilities.DataLoader;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.testng.annotations.Test;


@Test(groups = "authTestSuit")
public class SampleApi extends BaseConfiguration {

    @Test(dataProvider="userTestDataProvider")
    public void authTest(final JSONArray testData){
        DataLoader dataLoader=new DataLoader(testData);
        Response response=helper.sendApiRequest(dataLoader.getMethod(),dataLoader.getUrl(),dataLoader.getPayload(),null);
        response.prettyPrint();
        dataPool.setAccessToken(response.path("token"));
    }

    @Test(dataProvider="userTestDataProvider")
    public void usertest(final JSONArray testData){
        DataLoader dataLoader=new DataLoader(testData);

    }
}
