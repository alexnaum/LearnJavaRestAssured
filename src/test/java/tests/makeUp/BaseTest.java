package tests.makeUp;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

import static common.config.URL;

public class BaseTest {
    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI = URL;
    }
}
