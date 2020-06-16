package googleMapsSerialization;

import java.util.ArrayList;
import java.util.List;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class SerializationTest {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		AddPlace place = new AddPlace();
		place.setAccuracy(50);
		place.setAddress("4232 St Paul Way #104 Concord, CA 94518");
		place.setLanguage("Arabic");
		place.setName("Mosbah Esra Adam Mera Mohammad Yaseen");
		place.setPhone_number("(415) 860-4897");
		place.setWebsite("https://www.jordanfirst.com");

		List<String> myList = new ArrayList<String>();
		myList.add("Contra Costa Community Park");
		myList.add("Concord Community Park");
		place.setTypes(myList);

		Location location = new Location();
		location.setLat(-38.38777);
		location.setLng(-33.44111);
		place.setLocation(location);

		Response response = given().log().all().queryParam("key", "qaclick123").body(place).when()
				.post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().response();

		String stringResponse = response.asString();
		System.out.println(stringResponse);

	}

}
