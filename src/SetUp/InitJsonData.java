package SetUp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Object for storing tax rates and product categories
public class InitJsonData {

    private Map<String, Double> taxRates = new HashMap<>();
    private Map<String, List<String>> taxExemptCategories = new HashMap<>();
    
    private Map<String, String> productListCategories = new HashMap<>();

    public Double getTaxRatesByID(String location) {
        return taxRates.get(location);
    }

    public void setTaxRates(Map<String, Double> taxRates) {
        this.taxRates = taxRates;
    }

    public void setProductListCategories(Map<String, String> productList) {
        this.productListCategories = productList;
    }

    public List<String> getTaxExemptCategoriesByID(String location) {
        return taxExemptCategories.get(location);
    }

    public void setTaxExemptCategories(Map<String, List<String>> taxExemptCategories) {
        this.taxExemptCategories = taxExemptCategories;
    }

    public String getProductListCategoriesByID(String name) {
        return productListCategories.get(name);
    }

}
