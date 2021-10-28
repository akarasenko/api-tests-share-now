package tests;

import helpers.ApiRequest;
import models.ItemType;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UnauthorizedTest extends BaseTest {

    @Parameters("itemType")
    @Test
    public void UnauthorizedTest(String itemType) {
        ItemType type = ItemType.valueOf(itemType);

        String urlPart = "";
        switch (type) {
            case FRONT_LEFT_DOOR:
                urlPart = "doorstatusfrontleft";
                break;
            case FRONT_RIGHT_DOOR:
                urlPart = "doorstatusfrontright";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + itemType);
        }

        String reqType = "get";
        String url = app.getProperty("baseUrl") + app.getProperty("vehicleId") + "/resources/" + urlPart;

        ApiRequest request = new ApiRequest().withType(reqType).withUrl(url);

        request.execute();

        Assert.assertEquals(request.getStatusCode(), 401);
    }
}
