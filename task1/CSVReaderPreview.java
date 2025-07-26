package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        String filePath = "dataset/dataset.csv";
        String line;
        int totalRecords = 0;
        int columnCount = 0;

        System.out.println("=== Data Preview ===\n");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read header
            if ((line = br.readLine()) != null) {
                String[] headers = line.split(",");
                columnCount = headers.length;

                System.out.println("Columns:");
                for (String header : headers) {
                    System.out.print(header + "\t");
                }
                System.out.println("\nTotal Columns: " + columnCount + "\n");
                System.out.println("First 5 Records:");
            }

            // Read and print first 5 records
            int recordCount = 0;
            while ((line = br.readLine()) != null) {
                totalRecords++;
                if (recordCount < 5) {
                    String[] fields = line.split(",");
                    for (String field : fields) {
                        System.out.print(field + "\t");
                    }
                    System.out.println();
                    recordCount++;
                }
            }

            System.out.println("\nTotal Records (excluding header): " + totalRecords);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
