package helper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * WebServiceHelper is responsible of sending all HTTP requests using restassured
 */
public class WebServiceHelper {


    private RequestSpecification request;


    public WebServiceHelper() {
        HashMap<String, String> Headers = new HashMap<>();
        Headers.put("Content-Type", "application/json");

        request = given();
        request.headers(Headers);
    }


    /**
     * execute is responsible of sending the actual HTTP Request
     * @param endpoint:is the endpoint inside the request that will be sent
     * @param method:request type(verb)
     * @return response of the request sent
     */
    public Response execute(String endpoint, HttpMethod method) {
        Response response = null;
        switch (method) {
            case GET: {
                response = request.get(endpoint);
                break;
            }
            case POST: {
                response = request.post(endpoint);
                break;
            }
            case DELETE: {
                response = request.delete(endpoint);
                break;
            }
            case PUT: {
                response = request.put(endpoint);
                break;
            }
        }
        return response;
    }


    public enum HttpMethod {

        GET("get"), POST("post"), DELETE("delete"), PUT("put");

        private String method;

        HttpMethod(String method) {
            this.method = method;
        }

    }
}