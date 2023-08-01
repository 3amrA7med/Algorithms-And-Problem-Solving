package com.playground.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneLetterCombinations {

    private Map<Character, char[]> phoneLettersDirectory;

    PhoneLetterCombinations() {
        this.phoneLettersDirectory = new HashMap<>();
        this.phoneLettersDirectory.put('2', new char[]{'a', 'b', 'c'});
        this.phoneLettersDirectory.put('3', new char[]{'d', 'e', 'f'});
        this.phoneLettersDirectory.put('4', new char[]{'g', 'h', 'i'});
        this.phoneLettersDirectory.put('5', new char[]{'j', 'k', 'l'});
        this.phoneLettersDirectory.put('6', new char[]{'m', 'n', 'o'});
        this.phoneLettersDirectory.put('7', new char[]{'p', 'q', 'r', 's'});
        this.phoneLettersDirectory.put('8', new char[]{'t', 'u', 'v'});
        this.phoneLettersDirectory.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    List<String> result;

    /**
     * -ms Beats 100.00%
     * 40.77mb Beats 98.81%
     */
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if(digits.length() == 0) return result;
        letterCombinationsRec(digits.toCharArray(), 0, new char[digits.length()]);
        return result;
    }

    public void letterCombinationsRec(char[] digits, int index, char[] combination) {
        if(index == digits.length) {
            result.add(new String(combination));
            return;
        }

        char[] possibleValues = phoneLettersDirectory.get(digits[index]);
        for(int i = 0; i < possibleValues.length; i++) {
            combination[index] = possibleValues[i];
            letterCombinationsRec(digits, index + 1, combination);
        }
    }

    /*
    private Map<String, List<String>> phoneLettersDirectory;

    PhoneLetterCombinations() {
        this.phoneLettersDirectory = new HashMap<>();
        this.phoneLettersDirectory.put("2", new ArrayList<>(){{add("a");add("b");add("c");}});
        this.phoneLettersDirectory.put("3", new ArrayList<>(){{add("d");add("e");add("f");}});
        this.phoneLettersDirectory.put("4", new ArrayList<>(){{add("g");add("h");add("i");}});
        this.phoneLettersDirectory.put("5", new ArrayList<>(){{add("j");add("k");add("l");}});
        this.phoneLettersDirectory.put("6", new ArrayList<>(){{add("m");add("n");add("o");}});
        this.phoneLettersDirectory.put("7", new ArrayList<>(){{add("p");add("q");add("r");add("s");}});
        this.phoneLettersDirectory.put("8", new ArrayList<>(){{add("t");add("u");add("v");}});
        this.phoneLettersDirectory.put("9", new ArrayList<>(){{add("w");add("x");add("y");add("z");}});
    }


    public List<String> getCombinations(String digits) {
        return this.getRecursion(digits, 0, new ArrayList<>(), "");
    }

    private List<String> getRecursion(String digits, int index, List<String> result, String accumulatedResult){
        if(index == digits.length()) {
            result.add(accumulatedResult);
            return result;
        }
        List<String> numberLetters = this.phoneLettersDirectory.get(digits.substring(index, index + 1));
        for(int i = 0; i< numberLetters.size(); i++ ) {
            result = this.getRecursion(digits, index + 1, result, accumulatedResult + numberLetters.get(i));
        }
        return result;
    }
    */
}
