package eapli.base.jobApplication.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WordCounterRunnable implements Runnable{

    private Map<String, List<String>> occurrences;
    private String filePath;
    private List<String> wordExceptions = Arrays.asList("THE", "OF", "A", "TO", "AND", "FOR", "IS", "WAS", "THAT",
            "THERE", "WITH", "COM", "END", "AN", "A");

    public WordCounterRunnable(Map<String, List<String>> occurrences, String filePath){
        this.occurrences = occurrences;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    word = word.toUpperCase();
                    if (!word.isEmpty() && !wordExceptions.contains(word)) {
                        synchronized (occurrences){
                            List<String> fileList = occurrences.get(word);
                            if (fileList == null) {
                                fileList = new ArrayList<>();
                                occurrences.put(word, fileList);
                            }
                            fileList.add(filePath);
                        }
                    }
                }
            }
            System.out.printf("Thread processing file %s has finished.%n", filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
