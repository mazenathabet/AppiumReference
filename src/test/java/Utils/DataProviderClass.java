package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataProviderClass {


    @Test(dataProvider = "getData")
    public void simpleDataProviderTest(String fname, String lname, String company, String gender, String country){
        System.out.println("fname = " + fname + ", lname = " + lname + ", company = " + company + ", gender = " + gender + ", country = " + country);
    }
    @DataProvider
    public Object [] [] getData(){
        return new Object[][] {
                {"Mazen","Ahmed","Company","Male","Egypt"},
                {"Sarah","John","Company1","Female","USA"},
                {"Osama","Omar","Company2","Male","Brazil"}
        };
    }




    @Test (dataProvider = "getJsonData")
    public void JsonFileDataProviderTest(HashMap<String,String> input){
        System.out.println("first name = " + input.get("first name") + ", last name = " + input.get("last name") + ", Company = " + input.get("Company") + ", gender = " + input.get("Gender") + ", country = " + input.get("Country"));
    }
    @DataProvider
    public Object[][] getJsonData() throws IOException {
        List<HashMap<String,String>> data = getJsonData(System.getProperty("user.dir")+"/src/main/java/TestData/SimpleTestData.json");
        return new Object[][] {
                {data.get(0)},
                {data.get(1)},
                {data.get(2)},
                {data.get(3)}
        };
    }

    /**
     * We need to use the Commons-io and jackson-databind dependency from mvn repo so that we can read data the data from json files
     * and jackson-databind dependency to read the json string and write it into HashMap
     * steps :
     * 1 - parse our json file to json string using ( commons-io )
     * 2 - convert the json string to hashmap ( jackson-databind)
     * 3 - HashMap will be converted to data provider, so it can be used in the testcase
     */
    public List<HashMap<String,String >> getJsonData(String jsonFilePath) throws IOException {
        // convert json file content to json string
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(jsonContent,new TypeReference<>() {});
        return data;
    }
}
