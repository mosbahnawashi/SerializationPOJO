package googleMapsSerialization;

import java.util.ArrayList;
import java.util.List;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class SpecBuilderTest {

	public static void main(String[] args) {

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

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();

		ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();

		RequestSpecification res = given().spec(req).body(place);

		Response response = res.when().post("/maps/api/place/add/json").then().spec(resSpec).extract().response();

		String stringResponse = response.asString();
		System.out.println(stringResponse);

	}

}
