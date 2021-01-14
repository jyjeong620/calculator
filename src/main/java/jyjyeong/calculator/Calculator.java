package jyjyeong.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    Scanner scan = new Scanner(System.in);

    /**
     *  시작
     */
    public void run(){
        String input = inputView();
        System.out.println("입력 값 : " + input);
        Calculation calculation = new Calculation(input);
        System.out.println("결과 값 : " + calculation.calculate());
    }

    private String inputView() {
        System.out.print("문자를 입력해주세요 : ");
        return scan.nextLine();
    }


    /**
     * input 데이터를 공백으로 나눠 List 에 담는다
     */
    private List<String> splitInput(String input) {
        List<String> inputs = new ArrayList<>();

        Collections.addAll(inputs, input.split(" "));
        /*
         *  for (String datas : data) {
         *     inputs.add(datas);
         *  }
         */
        return inputs;
    }
}
