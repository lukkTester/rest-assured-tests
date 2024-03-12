package configuration;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import utilities.PropertyLoader;

import java.io.IOException;

public class TestConfiguration {

    public TestConfiguration() {
    }

    @BeforeTest
    public void setUp() throws IOException {
        RestAssured.baseURI = PropertyLoader.loadPathProperty("sports.api.base.url");
    }
}
