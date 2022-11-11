package cz.spsmb;

import cz.spsmb.model.CsvRow;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private static final String splitter = ";";

    public static void main(String[] args) {
        System.out.println(loadCsv());

    }

    public static List<CsvRow> loadCsv() {
        List<CsvRow> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\christian.abraham\\Desktop\\student.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] values = line.split(splitter);
                CsvRow row = new CsvRow();

                row.setId(Long.parseLong(values[0]));
                row.setName(((values[1])));
                row.setCountry(values[2]);
                records.add(row);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
