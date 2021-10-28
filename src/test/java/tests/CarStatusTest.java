package tests;

import helpers.ApiRequest;
import models.FrontLeftDoor;
import models.FrontRightDoor;
import models.ItemType;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CarStatusTest extends BaseTest {

    @Parameters("itemType")
    @Test
    public void ItemStatusTest (String itemType) throws ClassNotFoundException {
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
        String name = "authorization";
        String value = "Bearer " + app.getProperty("token");

        ApiRequest request = new ApiRequest().withType(reqType).withUrl(url).withHeader(name, value);

        request.execute();

        Assert.assertEquals(request.getStatusCode(), 200);

        boolean isItemOpen;

        switch (type) {
            case FRONT_LEFT_DOOR:
                isItemOpen = request.getResponseBody().as(FrontLeftDoor.class).isItemOpen();
                break;
            case FRONT_RIGHT_DOOR:
                isItemOpen = request.getResponseBody().as(FrontRightDoor.class).isItemOpen();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + itemType);
        }

        Assert.assertFalse(isItemOpen);
    }
}
