package helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

public class ApiRequest {

    private RequestSpecification request;
    private String url;
    private String type;
    private String requestBody;
    private ResponseBodyExtractionOptions responseBody;
    private int responseCode;

    public ApiRequest() {
        this.request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }

    public ApiRequest withType (String requestType) {
        this.type = requestType.toLowerCase();
        return this;
    }

    public ApiRequest withHeader (String name, String value) {
        this.request.header(name, value);
        return this;
    }

    public ApiRequest withUrl (String url) {
        this.url = url;
        return this;
    }

    public ApiRequest withBody(String body) {
        this.requestBody = body;
        this.request.body(body);
        return this;
    }

    public void execute () {
        Response resp = null;

        if (this.type == "get") {
            resp = request.get(this.url);
        }

        if (this.type == "post") {
            resp = request.post(this.url);
        }

        if (this.type == "delete") {
            resp = request.delete(this.url);
        }

        responseCode = resp.statusCode();
        responseBody = resp.body();
    }

    public int getStatusCode() {
        return this.responseCode;
    }

    public ResponseBodyExtractionOptions getResponseBody() {
        return this.responseBody;
    }
}
