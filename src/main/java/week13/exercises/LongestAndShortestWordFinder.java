package week13.exercises;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class LongestAndShortestWordFinder {

    public List<String> readFile() {
        List<String> lines = new LinkedList<>();
        try {
            Path path = Paths.get("/Users/gokhanpolat/Developer/advancedCoding-tll5/updatedRss.txt");

            lines = Files.readAllLines(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lines;
    }

    private void printLongestAndShortestWord(List<String> lines) {
        String shortestWord = lines.get(0).split(" ")[0];
        int shortestWordLetterCount = shortestWord.length();

        String longestWord = lines.get(0).split(" ")[0];
        int longestWordLetterCount = longestWord.length();

        for (String line : lines) {
            String[] words = line.split(" ");

            for (String word : words) {
                word = word.trim();
                if (word.length() != 1 && !isDigit(word)) {
                    if (word.length() < shortestWordLetterCount) {
                        shortestWord = word;
                        shortestWordLetterCount = shortestWord.length();
                    }

                    if (word.length() > longestWordLetterCount) {
                        longestWord = word;
                        longestWordLetterCount = longestWord.length();
                    }
                }
            }
        }

        System.out.println("Shortest word is : " + shortestWord);
        System.out.println("Longest word is : " + longestWord);
    }

    private boolean isDigit(String word) {
        for (char c : word.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestAndShortestWordFinder longestAndShortestWordFinder = new LongestAndShortestWordFinder();

        List<String> lines = longestAndShortestWordFinder.readFile();

        longestAndShortestWordFinder.printLongestAndShortestWord(lines);
    }
}
