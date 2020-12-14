package jyjyeong.calculator;

import java.util.Scanner;

public class Calculator {
    Scanner scan = new Scanner(System.in);

    /**
     *  시작
     */
    public void run(){
        System.out.print("문자를 입력해주세요 : ");
        String input = scan.nextLine();
        System.out.println("입력 값 : " + input);
        Calculation calculation = new Calculation(input);
        System.out.println("결과 값 : " );
    }
}
