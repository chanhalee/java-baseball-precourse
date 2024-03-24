package cli;

import gameLogics.BaseRule;
import gameLogics.UserInputProcessor;

import java.util.List;
import java.util.Scanner;

import static gameLogics.BaseRule.GAME_NUMBER_LENGTH;
public class CLIGameUI {
    private final Scanner scanner;
    private final UserInputProcessor userInputProcessor;


    public CLIGameUI() {
        this.scanner = new Scanner(System.in);
        userInputProcessor = new UserInputProcessor();
    }

    public List<Integer> getPitch(){
        boolean flag = true;
        List<Integer> result = null;
        while (flag) {
            System.out.print("숫자를 입력해 주세요 : ");
            String userInputString = scanner.nextLine();
            if (!userInputProcessor.validateInputString(userInputString)){
                System.out.println("[ERROR] Wrong input!");
                continue;
            }
            result = userInputProcessor.digestValidatedInputString(userInputString);
        }
        return result;
    }

    public void printPitchResult(int strike, int ball) {
        if (strike > 0) {
            System.out.printf("%d스트라이크 ", strike);
        }
        if (ball > 0) {
            System.out.printf("%d볼", ball);
        }
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.print("\n");
    }

    public void printEndMessage(){
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 끝\n", GAME_NUMBER_LENGTH);
    }

    public void askContinue(){
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInputString = scanner.nextLine();

    }


}
