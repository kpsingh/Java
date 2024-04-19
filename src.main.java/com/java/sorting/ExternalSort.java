package com.java.sorting;

import java.io.*;
import java.util.*;

public class ExternalSort {

    // Method to sort a chunk of data
    private static void sortChunk(List<String> chunk) {
        Collections.sort(chunk);
    }

    // Method to merge sorted chunks
    private static void mergeSortedChunks(List<String> sortedChunks, String outputFile) throws IOException {
        PriorityQueue<BufferedReader> pq = new PriorityQueue<>((a, b) -> {
            try {
                return a.readLine().compareTo(b.readLine());
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        });

        // Open readers for each sorted chunk
        for (String chunkFile : sortedChunks) {
            BufferedReader reader = new BufferedReader(new FileReader(chunkFile));
            pq.add(reader);
        }

        // Open writer for output file
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        // Merge sorted chunks
        while (!pq.isEmpty()) {
            BufferedReader reader = pq.poll();
            String line = reader.readLine();
            if (line != null) {
                writer.write(line);
                writer.newLine();
                pq.add(reader);
            } else {
                reader.close();
            }
        }

        // Close writer
        writer.close();
    }

    // Method to sort large file with limited memory
    public static void externalSort(String inputFile, String outputFile, int chunkSize) throws IOException {
        // Open reader for input file
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        List<String> chunk = new ArrayList<>();
        List<String> sortedChunks = new ArrayList<>();

        String line;
        int chunkNum = 0;

        // Read data in chunks, sort, and write to temporary files
        while ((line = reader.readLine()) != null) {
            chunk.add(line);
            if (chunk.size() >= chunkSize) {
                sortChunk(chunk);
                String chunkFile = "chunk" + chunkNum + ".tmp";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(chunkFile))) {
                    for (String item : chunk) {
                        writer.write(item);
                        writer.newLine();
                    }
                }
                sortedChunks.add(chunkFile);
                chunk.clear();
                chunkNum++;
            }
        }

        // Sort and write remaining data to temporary file
        if (!chunk.isEmpty()) {
            sortChunk(chunk);
            String chunkFile = "chunk" + chunkNum + ".tmp";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(chunkFile))) {
                for (String item : chunk) {
                    writer.write(item);
                    writer.newLine();
                }
            }
            sortedChunks.add(chunkFile);
        }

        // Close reader
        reader.close();

        // Merge sorted chunks
        mergeSortedChunks(sortedChunks, outputFile);

        // Delete temporary files
        for (String chunkFile : sortedChunks) {
            File file = new File(chunkFile);
            file.delete();
        }
    }

    public static void main(String[] args) {
        String inputFile = "input.txt"; // Replace with your input file path
        String outputFile = "output.txt"; // Replace with your output file path
        int chunkSize = 100000; // Adjust chunk size based on available memory

        try {
            externalSort(inputFile, outputFile, chunkSize);
            System.out.println("File sorted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
