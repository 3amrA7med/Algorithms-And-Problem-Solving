package com.playground.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneLetterCombinations {

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

    /**
     * @param digits
     * @return
     */
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
}
