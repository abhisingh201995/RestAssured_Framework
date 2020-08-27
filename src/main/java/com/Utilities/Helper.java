package com.Utilities;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.reporters.Files;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Helper {

    private final ConfigParser configParser = ConfigParser.getConfigParser();
    private final DataPool dataPool = DataPool.getDataPool();

    public void loadTestData() throws IOException {

        Map<String,String> testDataPath= new HashMap<>();
        File folder= new File("src/main/resources/ApiTestData");

        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isFile()) {
                testDataPath.put(fileEntry.getName(),fileEntry.getCanonicalPath());
            }
        }

        HashMap<Object,JSONArray> testDataPool = new HashMap<Object, JSONArray>();
        testDataPath.forEach((k,v)->{
            try{
                File file = new File(v);
                String content = (String) Files.readFile(file);
                JSONParser jsonParser=new JSONParser();
                JSONObject jsonObject=(JSONObject) jsonParser.parse(content);
                jsonObject.forEach((key,value)->{
                    testDataPool.put(key, (JSONArray) value);

                });
            }catch (Exception e) {throw new Error("Unable to get json from files"); }
        });
        dataPool.setTestDataPool(testDataPool);
    }

    public Object[][] testNgProvider(JSONArray jsonElements){
        Object[][] testData=new Object[jsonElements.size()][];
        for(int i=0;i<jsonElements.size();i++){
            testData[i] = new Object[1];
            testData[i][0]=jsonElements;
        }
        return testData;
    }

    public void authenticationOAuth(){
        RequestSpecification specification=given().auth().preemptive().basic("","").formParam("","");
        Response response=specification.request("","").then().extract().response();
    }

    public Response sendApiRequest(String method,String url,String payload, String authToken){
        RequestSpecification spec = given();
        spec = spec.
                contentType("application/json").
                accept("application/json");
        if(payload!=null){
            spec=spec.body(payload);
        }
        if(authToken!=null){
            spec=spec.auth().oauth2(authToken);
        }
        Response response=spec.request(method,url).then().extract().response();
        return response;
    }
}
