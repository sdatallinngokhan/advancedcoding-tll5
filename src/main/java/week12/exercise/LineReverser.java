package week12.exercise;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LineReverser {

    public List<String> getFileLines(String readingPath) {
        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get(readingPath);
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private List<String> switchLines(List<String> lines) {
        List<String> switchedLines = new LinkedList<>();
        for (int i = lines.size()-1; i>=0; i--){
            String reversedLine = new StringBuilder(lines.get(i)).reverse().toString();
            switchedLines.add(reversedLine);
        }

        return switchedLines;
    }

    public void writeFile(String writingPath, List<String> switchedLines) {
        try {
            Path path = Paths.get(writingPath);

            Files.write(path, switchedLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LineReverser lineReverser = new LineReverser();

        String readingPath = "/Users/gokhanpolat/Developer/advancedCoding-tll5/fileContent.txt";
        List<String> lines = lineReverser.getFileLines(readingPath);

        List<String> switchedLines = lineReverser.switchLines(lines);

        String writingPath = "/Users/gokhanpolat/Developer/advancedCoding-tll5/reversedFileContent.txt";
        lineReverser.writeFile(writingPath, switchedLines);
    }

}
