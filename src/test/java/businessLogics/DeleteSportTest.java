package businessLogics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import configuration.TestConfiguration;
import model.Competition;
import model.Sport;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DeleteSportTest extends TestConfiguration {

    private Competition testCompetition;
    private Sport testData;

    @BeforeTest
    public void createTestData() throws JsonProcessingException {

        // given
        testCompetition = new Competition("1", "test");
        testData = new Sport("666", "Tennis", true, new ArrayList<>(Arrays.asList(
                testCompetition)));
        given().body(new ObjectMapper().writeValueAsString(testData)).contentType("application/json")
                .when().post("/" + testData.getId());
    }

    @Test
    public void testDeleteSport() {

        //when
        when().delete("/" + testData.getId())

        // then
        .then().statusCode(200);
        assertThat(given().get("/" + testData.getId()).statusCode()).isEqualTo(404);
    }
}
