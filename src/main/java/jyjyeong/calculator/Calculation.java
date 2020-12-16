package jyjyeong.calculator;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Calculation {
    private final List<String> input;
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String MUL = "*";
    private static final String DIV = "/";

    private static int total = 0;
    private static String nowOperator = "";

    public Calculation(String input) {
        this.input = splitInput(input);
    }

    /**
     * 계산하는 함수
     * @return
     */
    public int calculate() {

        return 0;
    }

    //TODO 입력된 문자가 숫자인지 연산자인지 확인

    /**
     * 입력된 연산자가 유효한지 확인
     */
    private boolean isOperator(String operator){
        boolean isOperator = false;
        if(ADD.equals(operator)){
            isOperator = true;
        }
        if(SUB.equals(operator)){
            isOperator = true;
        }
        if(MUL.equals(operator)){
            isOperator = true;
        }
        if(DIV.equals(operator)){
            isOperator = true;
        }
        return isOperator;
    }

    /**
     * 입력된 값을 현재 연산지로 지정한다
     */
    private void saveOperator(String operator){
        nowOperator = operator;
    }

    /**
     * 값을 받아와 최종 값에 추가해준다
     */
    private void plusTotal(int num){
        total += num;
    }

    /**
     * input 데이터를 공백으로 나눠 List 에 담는다
     */
    private List<String> splitInput(String input){
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
