import java.io.*;

import org.apache.commons.csv.*;

public class Reader {
    public static void main(String[] args) {
        try (FileReader in = new FileReader("result.csv")) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
            .withFirstRecordAsHeader().parse(in);
            // System.out.println(records.size());
            for(CSVRecord record: records) {
                try {
                    if(Double.parseDouble(record.get("GPA")) >= 3.7){
                        System.out.print(record.get("name")+ " ");
                        System.out.print(record.get("email")+ " ");
                        System.out.print(record.get("GPA")+ " ");
                        System.out.println();
                    }                    
                } catch (Exception _e) {
                    //TODO: handle exception
                    System.out.println(_e.getMessage());
                }
                
            }  
        } catch (Exception e) {
            //TODO: handle exception
            e.getMessage();
        }
        
         
    }
}
