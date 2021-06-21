package adapters;

import static io.restassured.RestAssured.given;

public class SuiteAdapter extends BaseAdapter{
    String body;
    int status;

    //Allure-restasured
    public String create(String body, int status, String code) {
        return post(body,status,"https://api.qase.io/v1/suite/" + code);
    }
}
