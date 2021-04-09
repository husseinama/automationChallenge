package Base;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeSuite;

/**
 * Responsible for defining the common methods between all service tests
 */
public class BaseServiceTest extends BaseTest {


    public ResponseSpecification responseSpec;
    @BeforeSuite
    public void InitTests()
    {
        responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }
}
