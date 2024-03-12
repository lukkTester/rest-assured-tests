package businessLogics;

import configuration.TestConfiguration;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static org.assertj.core.api.Assertions.assertThat;

public class GetSpecificSportTest extends TestConfiguration {

    @Test
    public void getSportById() {

        // given
        var testId = 4;

        // when
        Response resp = get("/" + testId);

        // then
        assertThat(resp.statusCode()).isEqualTo(200);
        assertThat(resp.jsonPath().getString("id")).isEqualTo("4");
        assertThat(resp.jsonPath().getString("name")).isEqualTo("Sumo");
        assertThat(resp.jsonPath().getString("active")).isEqualTo("false");
    }
}
