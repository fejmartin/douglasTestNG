package csv;

import POJO.Filters;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class DataProviderClass {

    private static Object[][] data = null;
    private static List<Filters> filtersList = null;

    public static void OBjectfromCSV2(String  filename) throws FileNotFoundException {

        String csvFile = "./src/test/java/resources/" + filename;

        filtersList = new ArrayList<>();

        try (
                Reader reader = new FileReader(csvFile);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)
            ) {

            for (CSVRecord csvRecord : csvParser) {
                String Highlights = csvRecord.get(0);
                String Marke = csvRecord.get(1);
                String Produktart = csvRecord.get(2);
                String Geschenk_fur = csvRecord.get(3);
                String Fur_Wen = csvRecord.get(4);


                Filters filter = new Filters(Highlights,Marke,Produktart,Geschenk_fur,Fur_Wen);
                filtersList.add(filter);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // return data object with the data from csv file
    public static Object[][] getCSVDataObject(String filename) throws FileNotFoundException {
        OBjectfromCSV2(filename);
        return new Object[][] { { filtersList.get(0) }, { filtersList.get(1)}, { filtersList.get(2) } };
    }

    @DataProvider(name = "getDataFromCSV")
    public static Object[][] getDataFromCSV() throws FileNotFoundException {
        return getCSVDataObject("filters.csv");
    }

}
