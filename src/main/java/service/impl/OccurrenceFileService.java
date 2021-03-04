package service.impl;

import exception.MissingPathArgumentException;
import service.FileService;
import service.WordService;
import util.WordChecker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OccurrenceFileService implements FileService {

    private final WordService wordService;

    public OccurrenceFileService(WordService wordService) {
        this.wordService = wordService;
    }

    private Map<Integer, Integer> getLineAndProcessedData(String[] args) throws Exception {
        Map<Integer, Integer> lineResultMap = new HashMap<>();

        // Get file
        File readFile = new File(getPath(args));

        // read file
        Scanner reader = new Scanner(readFile);

        // iterate
        int lineCount = 1;

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            WordChecker.checkString(data.trim());
            lineResultMap.put(lineCount, wordService.determineNumberOfDeletion(data));
            lineCount++;

        }
        reader.close();

        return lineResultMap;
    }

    private void createNewLineAndWriteLineDataInformation(Map<Integer, Integer> lineDataMap) throws IOException {
        FileWriter myWriter = new FileWriter("result.txt");
        lineDataMap.forEach((key, value) -> {
            try {
                myWriter.write(key + "- " + value + "\n");
            } catch (IOException e) {
                System.out.println("Line can't be written");
            }
        });

        myWriter.close();
    }

    @Override
    public void getFileAndProcess(String[] args) throws Exception {
        try {
            createNewLineAndWriteLineDataInformation(getLineAndProcessedData(args));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    private String getPath(String[] args) throws Exception {
        if (args.length == 0) {
            throw new MissingPathArgumentException();
        }

        return args[0];
    }
}
