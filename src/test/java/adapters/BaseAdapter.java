package adapters;

import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class BaseAdapter {
    Gson gson = new Gson();

    public String post(String body, int status, String url) {
        return
                given().
                        header("Token", "833f6af6f92e76d0f3c9b9af42f3c3f176a1950c").
                        header("Content-Type", "application/json").
                body(body).
                        log().all().
                when().
                        post(url).
                then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }

    public String get(int status, String url) {
        return
                given().
                        header("Token", "833f6af6f92e76d0f3c9b9af42f3c3f176a1950c").
                        header("Content-Type", "application/json").
                        log().all().
                        when().
                        get(url).
                then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }
}
