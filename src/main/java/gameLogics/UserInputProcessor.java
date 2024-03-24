package gameLogics;

import java.util.ArrayList;
import java.util.List;

import static gameLogics.BaseRule.GAME_NUMBER_LENGTH;

public class UserInputProcessor {

    public boolean validateInputString(String userInput) {
        boolean result = true;
        userInput = userInput.trim();
        int idx = -1;
        if (userInput.length() != GAME_NUMBER_LENGTH) {
            result = false;
        }
        while (++idx < GAME_NUMBER_LENGTH) {
            if (!Character.isDigit(userInput.charAt(idx))) {
                result = false;
            }
        }
        return result;
    }

    public List<Integer> digestValidatedInputString(String userInput) {
        List<Integer> result = new ArrayList<>();
        userInput = userInput.trim();
        int idx = -1;
        while (++idx < GAME_NUMBER_LENGTH) {
            result.add(Character.getNumericValue(userInput.charAt(idx)));
        }
        return result;
    }
}
