package util;

import exception.InvalidCharacterException;
import exception.MaximumCharacterLengthException;
import exception.MinimumCharacterLengthException;

public class WordChecker {

    private static final int MIN_LENGTH = 1;

    private static final int MAX_LENGTH = 300000;


    public static void checkString(String str) throws MinimumCharacterLengthException,
            MaximumCharacterLengthException, InvalidCharacterException {

        if(str.length() < MIN_LENGTH)
            throw new MinimumCharacterLengthException();

        if(str.length() > MAX_LENGTH)
            throw new MaximumCharacterLengthException();

        if(!isAllLetters(str))
            throw new InvalidCharacterException();

    }

    private static boolean isAllLetters(String str) {
        return str.toLowerCase().chars().allMatch(Character::isLetter);
    }

}
