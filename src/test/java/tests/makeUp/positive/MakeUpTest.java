package tests.makeUp.positive;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.makeUpDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.makeUp.BaseTest;

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
    public void getItemsByCategoryBrands() throws JsonProcessingException {
        makeUpDto newThing = new makeUpDto();
        //newThing.
        String json = RestAssured.get().asString();
        ObjectMapper mapper = new ObjectMapper();
        makeUpDto thing = mapper.readValue(json, makeUpDto.class);
        System.out.println(json);
    }

    @Test
    public void validateJsonSchema(){
        RestAssured.given().param("brand","pure anada").param("product_type", "mascara").
                 when().get().then().assertThat()
                .body(matchesJsonSchemaInClasspath("JsonExample.json"));
    }
}
