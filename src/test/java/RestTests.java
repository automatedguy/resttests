import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.hasItems;

public class RestTests {

    @Test
    public void getEmployeeTest(){
        get("http://dummy.restapiexample.com/api/v1/employees").then().statusCode(200).assertThat()
                .body("data.employee_name", hasItems("Tiger Nixon"));
    }
}
