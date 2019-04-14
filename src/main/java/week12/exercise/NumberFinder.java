package week12.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NumberFinder {

    public List<String> getFileContent(String readingPath) {
        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get(readingPath);
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    private List<Integer> getNumbersFromFile(List<String> lines) {
        List<Integer> numbers = new ArrayList<>();

        lines.stream().forEach(line -> {
            String number = "";
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    number = number + line.charAt(i);
                    if (line.length() != i + 1 && !Character.isDigit(line.charAt(i + 1))) {
                        numbers.add(Integer.parseInt(number));
                        number = "";
                    }
                }
            }
        });

        return numbers;
    }

    public static void main(String[] args) {
        NumberFinder numberFinder = new NumberFinder();

        String readingPath = "/Users/gokhanpolat/Developer/advancedCoding-tll5/numbers.txt";
        List<String> lines = numberFinder.getFileContent(readingPath);

        List<Integer> numbers = numberFinder.getNumbersFromFile(lines);

        System.out.println("There are " + numbers.size() + " number(s)");

        Integer sumUpOfNumbers = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sumUpOfNumbers += numbers.get(i);
        }

        System.out.println("Sum up of numbers : " + sumUpOfNumbers);
    }

}