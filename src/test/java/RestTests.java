

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.hasItems;

public class RestTests {

    @Test(priority = 1)
    public void postPersonTest(){

        JSONObject jsonBody = new JSONObject();
        jsonBody.put("nickname", "AAAAAA");
        jsonBody.put("first_name", "AAAAAA");
        jsonBody.put("last_name", "trtrtrrtr");
        jsonBody.put("birth_date", "2020-03-01");
        jsonBody.put("creation_date",  "2020-03-11");
        jsonBody.put("active",  true);
        jsonBody.put("sex",  "M");

        with().body(jsonBody.toString())
                .header("Content-Type", "application/json")
                .contentType("application/json").accept("*/*")
                .when()
                .post("http://127.0.0.1:8000/person/")
                .then()
                .statusCode(201);

    }

    @Test(priority = 2)
    public void getPersonTest(){
        get("http://127.0.0.1:8000/person/").then().statusCode(200).assertThat()
                .body("results.first_name", hasItems("AAAAAA"))
                .body("results.last_name", hasItems("trtrtrrtr"));
    }

    @Test(priority = 3)
    public void putPersonTest(){

        JSONObject jsonBody = new JSONObject();
        jsonBody.put("nickname", "updated");
        jsonBody.put("first_name", "updated");
        jsonBody.put("last_name", "updated");
        jsonBody.put("birth_date", "2020-03-01");
        jsonBody.put("creation_date",  "2020-03-11");
        jsonBody.put("active",  true);
        jsonBody.put("sex",  "M");

        with().body(jsonBody.toString())
                .header("Content-Type", "application/json")
                .contentType("application/json").accept("*/*")
                .when()
                .put("http://127.0.0.1:8000/person/1/")
                .then()
                .statusCode(200);

    }

    @Test(priority = 4)
    public void deletePersonTest(){

        delete("http://127.0.0.1:8000/person/1/").then().statusCode(204);

    }

}
