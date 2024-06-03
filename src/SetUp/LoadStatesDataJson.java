package SetUp;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// To load and save the  tax rates json file.
public class LoadStatesDataJson {
    
    private JSONArray jsonData;
    
    public void buildUP(){
        String jsonFilePath = "./JsonData/StatesData.json";

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
    
    
    public Map<String, Double> crateTaxRate() {
        Map<String, Double> taxRates = new HashMap<>();
        
        for (Object item : jsonData) {
            JSONObject jsonObject = (JSONObject) item;

            String state = (String) jsonObject.get("Location");
            double taxRate = (double) jsonObject.get("TaxRate");
            taxRates.put(state, taxRate);
        }
        return taxRates;        
    }
    
    public Map<String, List<String>> createTaxExempt() {
        Map<String, List<String>> taxExemptCategories = new HashMap<>();
        
        for (Object item : jsonData) {
            JSONObject jsonObject = (JSONObject) item;

            String state = (String) jsonObject.get("Location");
            List<String> temp = new ArrayList<>();
            JSONArray exemptCategories = (JSONArray) jsonObject.get("ExemptList");
            for (Object category : exemptCategories) {
                temp.add((String) category);
            }
            taxExemptCategories.put(state, temp);
        }
        return taxExemptCategories;  
    }
}

