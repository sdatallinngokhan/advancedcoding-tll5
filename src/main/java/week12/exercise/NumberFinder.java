package week12.exercise;

import java.util.ArrayList;
import java.util.List;

public class NumberFinder extends IOOperations {

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
                    } else if (line.length() == i + 1 && !number.equals("")) {
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
        List<String> lines = numberFinder.readFileLines(readingPath);

        List<Integer> numbers = numberFinder.getNumbersFromFile(lines);

        System.out.println("There are " + numbers.size() + " number(s)");

        Integer sumUpOfNumbers = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sumUpOfNumbers += numbers.get(i);
        }

        System.out.println("Sum up of numbers : " + sumUpOfNumbers);
    }
}
