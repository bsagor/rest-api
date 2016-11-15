/*package sa.com.rufaida.domain;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParse {

	public static void main(String[] args) {
		String url = "http://localhost:8080/rufaida/GetAnalyzer";
		for (int i = 0; i < 1000; i++) {
			ParseData(url);
		}

	}

	private static void ParseData(String url) {
		JSONParser jsonParser = new JSONParser();
		@SuppressWarnings("unused")
		JSONObject object = jsonParser.getJSONFromUrl(url);
		
		JSONArray arr = object.getJSONArray("data");
		for (int i = 0; i < arr.length(); i++)
		{
		    String post_id = arr.getJSONObject(i).getString("Name");
		    System.out.println("Data>>>>>>"+post_id);
		}
	}

}
*/