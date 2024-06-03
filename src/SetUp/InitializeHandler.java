package SetUp;

//Handle the system flow of loading the json.
public class InitializeHandler {

    private InitJsonData builtInData;
    private LoadStatesDataJson statesObj;
    private LoadProductDataJson productObj;

    public InitializeHandler(){
        builtInData = new InitJsonData();
        statesObj = new LoadStatesDataJson();
        productObj = new LoadProductDataJson();
    }

    public void setUp() {
        statesObj.buildUP();
        builtInData.setTaxRates(statesObj.crateTaxRate());
        builtInData.setTaxExemptCategories(statesObj.createTaxExempt());
        
        productObj.buildUP();
        builtInData.setProductListCategories(productObj.crateProductListCategories());
               
    }

    public InitJsonData getBuiltInData() {
        return builtInData;
    }




}
