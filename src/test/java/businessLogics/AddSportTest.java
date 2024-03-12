package businessLogics;

import com.fasterxml.jackson.databind.ObjectMapper;
import configuration.TestConfiguration;
import model.Competition;
import model.Sport;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class AddSportTest extends TestConfiguration {

    private Sport newSport;

    @Test
    public void postNewSport() throws IOException {

        // given
        List<Competition> competitions = new ArrayList<>();
        competitions.add(new Competition("C_11", "Wimbledon"));
        competitions.add(new Competition("C_12", "French Open"));
        newSport = new Sport("115", "Tennis", true, competitions);
        var requestBody = new ObjectMapper().writeValueAsString(newSport);

        var resp = given()
                .body(requestBody)
                .contentType("application/json")

        //when
        .when().post("/" + newSport.getId());

        // then
        assertThat(resp.statusCode()).isEqualTo("201");
        assertThat(given().get("/" + newSport.getId()).jsonPath().getString("name")).isEqualTo("Tennis");
    }

    @AfterTest
    public void cleanUp() {

        delete("/" + newSport.getId())
                .then()
                .statusCode(200);
    }
}
