package service.jsonParser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import domain.CsvFile;
import service.csvFileOperations.CsvFileOperation;

public class JsonParserServiceImp implements JsonParserServive {

	public boolean getJsonData(String cityName) throws JSONException {

		JSONArray contentArray = null;
		JSONObject contentObject = null;
		List<CsvFile> allContenets = new ArrayList<CsvFile>();
		try {
			String content = readFromUrl(cityName);
			if (content.length() == 2) // In Case of Empty Response
				return false;

			contentArray = new JSONArray(content); // In Case of Valid Response
													// with Json Data
			contentObject = new JSONObject();
			// Iterate over Returned JSON Array To get Desired CSV file contents
			for (int i = 0; i < contentArray.length(); i++) {
				contentObject = contentArray.getJSONObject(i);
				allContenets.add(new CsvFile(contentObject.getLong("_id"), contentObject.getString("name"),
						contentObject.getString("type"),
						contentObject.getJSONObject("geo_position").getDouble("latitude"),
						contentObject.getJSONObject("geo_position").getDouble("longitude")));

			}

			CsvFileOperation.writeCsvFile(allContenets,cityName);
		} catch (MalformedURLException e) {
			System.out.println("Error while Parsing Json : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error while Parsing Json" + e.getMessage());
		}

		return true;
	}

	private String readFromUrl(String cityName) throws MalformedURLException, IOException {
		// build a URL
		String apiURL = "http://api.goeuro.com/api/v2/position/suggest/en/" + cityName;
		StringBuilder content = new StringBuilder();
		URL url = new URL(apiURL);
		Scanner scan = new Scanner(url.openStream());
		while (scan.hasNext())
			content.append(scan.nextLine());
		scan.close();

		return content.toString();
	}
}
