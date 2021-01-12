package jyjyeong.calculator;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Calculation {
    private final List<String> input;
    private final String ADD = "+";
    private final String SUB = "-";
    private final String MUL = "*";
    private final String DIV = "/";

    private int total = 0;
    private static String nowOperator = "";

    public Calculation(String input) {
        this.input = splitInput(input);
    }

    /**
     * 계산하는 함수
     * @return
     */
    public int calculate() {

        if(isNumberData(input.get(0))) {
            this.total = convertNumber(input.get(0));
        }

        for(int i = 1; i < input.toArray().length; i++) {
            cal(input.get(i));
        }
        return this.total;
    }

    private void cal(String data){
        if(data == null || data.equals(" ")){
            throw new IllegalArgumentException("입력 값이 null 이거나 빈 공백 문자입니다");
        }
        if(isNumberData(data)) {
            System.out.println("숫자입니다!!!1");
            calculatorTotal(convertNumber(data));
        }
        if(isOperator(data)) {
            System.out.println("문자입니다!!!!");
            saveOperator(data);
        }
    }

    /**
     * 숫자인지 확인 하는 메소드
     */
    private boolean isNumberData(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     *  입력된 문자 숫자로 변환
     */
    private int convertNumber(String number) {
        try{
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            throw new NumberFormatException();
        }
    }

    /**
     * 입력된 연산자가 유효한지 확인
     */
    private boolean isOperator(String operator) {
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
    private void saveOperator(String operator) {
        nowOperator = operator;
    }

    /**
     * 값을 받아와 최종 값에 추가해준다
     */
    private void calculatorTotal(int num) {
        total = Operator.valueOfOperator(nowOperator).calculate(total, num);
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
