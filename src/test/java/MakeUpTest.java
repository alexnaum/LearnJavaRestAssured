import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class MakeUpTest {

    @Test
    public void test(){
        RestAssured.when().get("http://makeup-api.herokuapp.com/api/v1/products.json?brand=maybelline").
                then().assertThat().statusCode(200);
                //and().body("brand", equals());
    }
}
