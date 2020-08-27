package com.Tests.ApiTest;

import com.Utilities.DataLoader;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.testng.annotations.Test;

@Test(groups = "authTest2")
public class SampleTest2 extends BaseConfiguration {

    @Test(dataProvider="userTestDataProvider")
    public void userTest2(final JSONArray testData){
        DataLoader dataLoader=new DataLoader(testData);

    }


}
