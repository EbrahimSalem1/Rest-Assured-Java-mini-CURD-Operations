package base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlTest;

public class ReqresBase {

// APIBase.java has init methods for REST API operations
    public class APIBase {


        @BeforeSuite(alwaysRun = true)
        @Parameters("APIBaseURL")
        public void initSuite(@Optional String apiBaseURL) {
            RestAssured.baseURI = apiBaseURL;
        }
    }
}
