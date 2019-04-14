package week12.exercise;

import java.util.LinkedList;
import java.util.List;

public class LineReverser extends IOOperations { // inheritance

//    IOOperations ioOperations = new IOOperations(); composition

    private List<String> switchLines(List<String> lines) {
        List<String> switchedLines = new LinkedList<>(); // polymorphism
        for (int i = lines.size() - 1; i >= 0; i--) {
            String reversedLine = new StringBuilder(lines.get(i)).reverse().toString();
            switchedLines.add(reversedLine);
        }

        return switchedLines;
    }

    public static void main(String[] args) {
        LineReverser lineReverser = new LineReverser();

        String readingPath = "/Users/gokhanpolat/Developer/advancedCoding-tll5/fileContent.txt";
        List<String> lines = lineReverser.readFileLines(readingPath);

        List<String> switchedLines = lineReverser.switchLines(lines);

        String writingPath = "/Users/gokhanpolat/Developer/advancedCoding-tll5/reversedFileContent.txt";
        lineReverser.writeFile(writingPath, switchedLines);
    }

}
