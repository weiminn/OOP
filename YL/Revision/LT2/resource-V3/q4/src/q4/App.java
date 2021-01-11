package q4;
import q4.domain.Product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.soap.Node;



/**
 * Sample Java program to read and write Excel file in Java using Apache POI
 *
 */
public class App {

    private static List<Product> readFromExcel(String filename) {
        List<Product> products = new ArrayList<>();

        try {

            File excel = new File(filename);
            FileInputStream fis = new FileInputStream(excel);
            XSSFWorkbook book = new XSSFWorkbook(fis);
            XSSFSheet sheet = book.getSheetAt(0);

            Iterator<Row> iter = sheet.iterator();

            if (iter.hasNext()) {
                iter.next(); // skip the header
            }

            // Iterating over Excel file in Java
            while (iter.hasNext()) {
                Row row = iter.next();

                String name = row.getCell(0).getStringCellValue();
                Double quantity = row.getCell(1).getNumericCellValue();
                double price = row.getCell(2).getNumericCellValue();

                Product p = new Product(name, quantity.intValue(), price);
                products.add(p);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;

    }
    public static void main(String[] args) throws JsonProcessingException {

        List<Product> result = readFromExcel("data/order.xlsx");

        String jsonString = generateJSON(result);
        System.out.println(jsonString);
    }

    private static String generateJSON(List<Product> result) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();

        /**
         * Create three JSON Objects objectNode1, objectNode2, objectNode3
         * Add all these three objects in the array
         */

        for (Product p : result) {
            ObjectNode node = mapper.createObjectNode();

            node.put("name", p.getName());
            node.put("quantity", p.getQuantity());
            node.put("price", p.getPrice());
            arrayNode.add(node);
        }



        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}