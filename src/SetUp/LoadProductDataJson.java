package SetUp;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// To load and save the  product categories json file.
public class LoadProductDataJson {

    private JSONArray jsonData;

    public void buildUP() {
        String jsonFilePath = "./JsonData/ProductData.json";

        try {
            // parsing file "StatesData.json"
            Object obj = new JSONParser().parse(new FileReader(jsonFilePath));

            // typecasting obj to JSONObject
            jsonData = (JSONArray) obj;

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }
    }

    public Map<String, String> crateProductListCategories() {
        Map<String, String> productListCategories = new HashMap<>();

        for (Object item : jsonData) {
            JSONObject jsonObject = (JSONObject) item;

            String name = (String) jsonObject.get("Name");
            String categories = (String) jsonObject.get("Categories");
            productListCategories.put(name, categories);
        }
        return productListCategories;
    }
}
