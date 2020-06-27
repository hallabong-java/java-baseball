/*
 * Computer.java            3.1      2020-06-26
 *
 * Copyright (c) 2020 Yeonwoo Cho
 * ComputerScience, ProgrammingLanguage, Java, Seoul, KOREA
 * All rights reserved
 */

package com.baseball.yeonwoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Computer.class
 * 게임을 진행하는 클래스
 *
 * @author 조연우
 * @version 3.1     2020년 6월 26일
 */

public class Computer {
    private static final int NUMBER_LENGTH = 3;
    private static final int INITIALIZE = 0;
    private static final int PLAY_AGAIN = 1;
    private static final int GAME_DONE = 2;
    private static final int FINISH_GAME_STRIKES = 3;
    private static final int COUNT_IS_ZERO = 0;
    private static final int UPPER_BOUNDARY_NUMBER = 9;
    private static final int LOWER_BOUNDARY_NUMBER = 1;

    private static final char ZERO = '0';

    private Player newPlayer;

    private List<Character> computerAnswer = new ArrayList<>();
    private List<Character> playerInput = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);

    public Computer() {
        newPlayer = new Player();
    }

    public void gameStart() {    //처음 시작
        makeAnswer();
    }

    private void makeAnswer() {
        Random random = new Random();
        for (int generatingNumberIndex = 0; generatingNumberIndex < NUMBER_LENGTH; generatingNumberIndex++) {
            char number = (char)(random.nextInt(UPPER_BOUNDARY_NUMBER) + LOWER_BOUNDARY_NUMBER + ZERO);
            if (computerAnswer.contains(number)) {
                generatingNumberIndex--;
            } else {
                computerAnswer.add(number);
            }
        }
        System.out.print(computerAnswer);
        getNewInput();
    }

    private void getNewInput() {
        playerInput = newPlayer.inputAnswer();
        printHint();
    }

    private void printHint() {
        int strike = INITIALIZE;
        int ball = INITIALIZE;
        for (int findHintIndex = 0; findHintIndex < NUMBER_LENGTH; findHintIndex++) {
            if (computerAnswer.get(findHintIndex) == playerInput.get(findHintIndex)) {
                strike++;
            } else {
                ball += countBall(findHintIndex);
            }
        }
        if (strike == FINISH_GAME_STRIKES) {
            isRight();
        } else if ((ball == COUNT_IS_ZERO) && (strike == COUNT_IS_ZERO)) {
            System.out.println("nothing");
            getNewInput();
        } else if (strike == COUNT_IS_ZERO) {
            System.out.println(ball + "ball");
            getNewInput();
        } else if (ball == COUNT_IS_ZERO) {
            System.out.println(strike + "strike");
            getNewInput();
        } else {
            System.out.println(strike + "strike " + ball + "ball");
            getNewInput();
        }
    }

    private int countBall(int findHintComputerIndex) {
        int countBall = INITIALIZE;
        for (int findHintInPlayerIndex = 0; findHintInPlayerIndex < NUMBER_LENGTH; findHintInPlayerIndex++) {
            if (computerAnswer.get(findHintComputerIndex) == playerInput.get(findHintInPlayerIndex)) {
                countBall++;
            }
        }
        return countBall;
    }

    private void isRight() {
        System.out.println("You Win! Game Finish");
        System.out.print("if you want restart-> " + PLAY_AGAIN + " done -> " + GAME_DONE + " : ");
        playAgainOrDone();
    }

    private void playAgainOrDone() {
        int playAgainNumber = scan.nextInt();
        if (playAgainNumber == PLAY_AGAIN) {
            Computer newComputer = new Computer();
            newComputer.gameStart();
        } else if (playAgainNumber == GAME_DONE) {
            System.exit(0);
        } else {
            System.out.print("wrong number. input again : ");
            playAgainOrDone();
        }
    }
}
