package tests.makeUp.positive;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.makeUpDto;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.makeUp.BaseTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.core.Is.is;

public class MakeUpTest extends BaseTest {

    @Test
    public void getBrandsTest() {
       RestAssured.when().get().
                then().assertThat().statusCode(200).
                 and().body("brand[0]", is("colourpop"));
       }

    @Test
    public void getPriceTest(){
        RestAssured.given().param("brand", "colourpop").when().get().
                then().assertThat().statusCode(200).
                and().body("price[2]", is("5.5"));
    }

    @Test
    public void getProductCategoryTest(){
        RestAssured.given().param("category", "pencil").when().get().
                then().assertThat().statusCode(200).
                and().body("category",is("pencil"));
    }

    @Test
    public void getInfoFirstBrandTest(){
        String json = RestAssured.get().asString();
        JsonPath jp = new JsonPath(json);
        Map brand = jp.get("find {e -> e.brand =~ \"colourpop\"}");
        Assert.assertEquals("Lippie Pencil", brand.get("name"));
    }

    @Test
    public void getTagsTest(){
        RestAssured.given().param("tag_list", "Vegan").when().get().
                then().assertThat().statusCode(200).
                and().body("brand[0]", is("colourpop"));
    }

    @Test
    public void validateJsonSchema(){
        RestAssured.given().param("brand","pure anada").param("product_type", "mascara").
                 when().get().then().assertThat()
                .body(matchesJsonSchemaInClasspath("JsonSchema.json"));
    }

    @Test
    public void validateJsonSchemaFromTwoRequest(){
        var firstResponce = RestAssured.given().param("brand","pure anada").
                when().get().then().extract().body().jsonPath();//.getObject("id",MakeUpTest.class);
        var secondResponce = RestAssured.given().param("product_type", "mascara").
                when().get().body().jsonPath().getObject("id",makeUpDto.class);
        List<Integer> ids = firstResponce.get("id");
        System.out.println(ids);
        System.out.println(secondResponce);

        //Assert.assertEquals(firstResponce.then().extract().statusCode(), secondResponce.then().extract().statusCode());
    }
}
