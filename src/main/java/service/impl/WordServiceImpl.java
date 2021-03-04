package service.impl;

import service.WordService;

import java.util.HashSet;
import java.util.Set;

public class WordServiceImpl implements WordService {

    private static final int LOWERCASE_A_INDEX = 'a';

    public int determineNumberOfDeletion(String word) {

        // there are 26 letters from a to z in English
        // ascii value of lowercase a is 97.
        // index of array represents ascii value of character - 97 and value represent number of times
        int[] characterOccurrenceArray = new int[26]; // fills index with default value (0)

        // fills index with number of occurrences
        initializeCharacterOccurrenceArray(characterOccurrenceArray, word);

        // calculate number deletions and return
        return calculateMinimumRequiredDeletionCount(characterOccurrenceArray);
    }

    private void initializeCharacterOccurrenceArray(int[] characterOccurrenceArray, String word) {
        for (char character : word.toLowerCase().toCharArray()) {
            int indexOfChar = character - LOWERCASE_A_INDEX;
            int characterCountOfChar = characterOccurrenceArray[indexOfChar];
            characterOccurrenceArray[indexOfChar] = characterCountOfChar + 1;
        }
    }

    private int calculateMinimumRequiredDeletionCount(int[] characterOccurrenceArray) {
        int letterCount = 0;
        Set<Integer> occurrenceSet = new HashSet<Integer>();
        for (int countOfCharacter : characterOccurrenceArray) {
            // Only unique values can be added to set, if you try add non unique values, it returns false
            while (countOfCharacter != 0 && !occurrenceSet.add(countOfCharacter)) {
                letterCount++;
                countOfCharacter--;
            }
        }

        return letterCount;
    }
}
