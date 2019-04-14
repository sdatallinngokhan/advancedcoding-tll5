package week12.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IOOperations {

    public List<String> readFileLines(String readingPath) {
        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get(readingPath);
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public void writeFile(String writingPath, List<String> switchedLines) {
        try {
            Path path = Paths.get(writingPath);

            Files.write(path, switchedLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
