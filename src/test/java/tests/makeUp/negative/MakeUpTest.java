package tests.makeUp.negative;

import io.restassured.RestAssured;
import org.hamcrest.text.IsEmptyString;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.makeUp.BaseTest;

import static common.config.URL;
import static org.hamcrest.core.Is.is;

public class MakeUpTest extends BaseTest {
    @Test
    public void setIncorrectBrandNameTest() {
        RestAssured.given().param("brand", "1234").when().get().
                then().assertThat().statusCode(200).
                and().body(IsEmptyString.emptyOrNullString());
    }

    @Test
    public void setIncorrectUrlTest() {
        RestAssured.given().when().get("/asda").
                then().assertThat().statusCode(404);
    }

    @Test
    public void setIncorrectProtocol() {
        RestAssured.given().when().post().
                then().assertThat().statusCode(422)
                .and().body("error", is("Unprocessable Entity"));
    }
}
