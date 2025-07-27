package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        // Path to the CSV file
        String filePath = "dataset/dataset.csv";
        String line;
        String separator = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String header = br.readLine();
            if (header == null) {
                System.out.println("The CSV file is empty.");
                return;
            }

            System.out.println("=== Data Preview ===\n");

            // Print column headers
            String[] headers = header.split(separator);
            System.out.println("Columns:");
            for (String col : headers) {
                System.out.print(col + " ");
            }

            System.out.println("\nTotal columns: " + headers.length);
            System.out.println("\nFirst 5 Records:\n");

            int rowCount = 0;

            // Show first 5 rows
            while ((line = br.readLine()) != null && rowCount < 5) {
                String[] data = line.split(separator);
                System.out.println(String.join(" ", data));
                rowCount++;
            }

            // Count the rest
            while (br.readLine() != null) {
                rowCount++;
            }

            System.out.println("\nTotal Records (excluding header): " + rowCount);

        } catch (IOException e) {
            System.err.println("Error reading the file:");
            e.printStackTrace();
        }
    }
}
