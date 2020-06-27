/*
 * Player.java            3.0       2020-06-25
 *
 * Copyright (c) 2020 Yeonwoo Cho
 * ComputerScience, ProgrammingLanguage, Java, Seoul, KOREA
 * All rights reserved
 */

package com.baseball.yeonwoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Player.class
 * 게임을 하는 클래스
 *
 * @author 조연우
 * @version 3.0     2020년 6월 25일
 */

public class Player {
    public static final int NUMBER_LENGTH = 3;
    public static final char BOUNDARY_ONE = '1';
    public static final char BOUNDARY_NINE = '9';

    String myAnswer = "";

    public List<Character> playerAnswer = new ArrayList<Character>();
    private Scanner scan = new Scanner(System.in);

    public List<Character> inputAnswer() {
        playerAnswer.clear();

        System.out.print("input three numbers : ");
        myAnswer = scan.nextLine();

        if (isInvalidRange(myAnswer) || (isInvalidLength(myAnswer)) || (isDuplication(myAnswer))) {
            isSomethingWrong();
        }
        for (int storeNumberIndex = 0; storeNumberIndex < myAnswer.length(); storeNumberIndex++) {
            playerAnswer.add(myAnswer.charAt(storeNumberIndex));
        }
        return playerAnswer;
    }

    private boolean isInvalidRange(String myAnswer) {
        char[] tempMyAnswer = myAnswer.toCharArray();

        for (int findWrongNumberIndex = 0; findWrongNumberIndex < NUMBER_LENGTH; findWrongNumberIndex++) {
            if ((tempMyAnswer[findWrongNumberIndex] < (char) BOUNDARY_ONE) || (tempMyAnswer[findWrongNumberIndex] > (char) BOUNDARY_NINE)) {
                return true;
            }
        }
        return false;
    }

    private boolean isInvalidLength(String myAnswer) {
        if (myAnswer.length() != NUMBER_LENGTH) {
            return true;
        }
        return false;
    }

    private boolean isDuplication(String myAnswer) {
        char[] tempMyAnswer = myAnswer.toCharArray();

        for (int findSameNumberIndex = 0; findSameNumberIndex < myAnswer.length() - 1; findSameNumberIndex++) {
            for (int compareSameNumberIndex = findSameNumberIndex + 1; compareSameNumberIndex < myAnswer.length(); compareSameNumberIndex++) {
                if (tempMyAnswer[findSameNumberIndex] == tempMyAnswer[compareSameNumberIndex]) {
                    return true;
                }
            }
        }
        return false;
    }

    private void isSomethingWrong() {
        System.out.println("input again");
        scan = new Scanner(System.in);
        inputAnswer();
    }
}

