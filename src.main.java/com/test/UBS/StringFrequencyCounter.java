package com.test.UBS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StringFrequencyCounter {

    public static void countStringFrequency(String filePath, String searchString) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;
            Map<Integer, Integer> frequencyMap = new HashMap<>(); // Map to store frequency counts for each line

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                int frequency = countOccurrences(line, searchString); // Count occurrences of the search string in the line
                frequencyMap.put(lineNumber, frequency); // Store frequency count for the current line
                lineNumber++; // Move to the next line
            }

            // Output frequency counts for each line
            for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                System.out.println("Line " + entry.getKey() + ": " + entry.getValue() + " occurrences");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countOccurrences(String line, String searchString) {
        int count = 0;
        int index = line.indexOf(searchString);
        while (index != -1) {
            count++;
            index = line.indexOf(searchString, index + 1); // Move to the next occurrence
        }
        return count;
    }

    public static void main(String[] args) {
        String filePath = "input.txt"; // Replace with your file path
        String searchString = "example"; // Replace with the string you want to count the frequency of
        countStringFrequency(filePath, searchString);
    }
}
