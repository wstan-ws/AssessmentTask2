package word;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class WordDistribution {

    private Map<String, Map<String, Integer>> word = new HashMap<>();
    private String currWord;
    private String nextWord;

    public void parse(File file) throws Exception {
        try(FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            String line = "";

            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z]", " ").trim().toLowerCase();
                String[] words = line.split(" ");
                for (int i = 0; i < (words.length - 1); i++) {
                    currWord = words[i];
                    nextWord = words[i + 1];
                    if (word.containsKey(currWord)) {
                        if (word.get(currWord).containsKey(nextWord)) {
                            Integer number = word.get(currWord).get(nextWord);
                            number++;
                        } else {
                            word.get(currWord).put(nextWord, 1);
                        }
                    } else {
                        Map<String, Integer> newWord = new HashMap<>();
                        newWord.put(nextWord, 1);
                        word.put(currWord, newWord);
                    }
                }
            }
        }
    }
    
    public void print() {
        for (String thisWord : word.keySet()) {
            System.out.printf("%s\n", thisWord);
            System.out.printf("\t%s\n", word.get(thisWord));
        }
    }
}