package dataFormat;

import configuration.TestConfiguration;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddSportWithMissingBodyTest extends TestConfiguration {

    @Test
    public void postNewSportWitMissingBody() {

        // given
        given().contentType("application/json")
                .body("")

        // when
        .when().post("/998")

        // then
        .then().statusCode(400);
    }
}
