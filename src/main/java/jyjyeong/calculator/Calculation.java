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
    private String nowOperator = "";
    private static final int NUMBER = 0;
    private static final int OPERATOR = 1;

    public Calculation(String input) {
        this.input = splitInput(input);
    }

    /**
     * 계산하는 함수
     */
    public int calculate() {

        if(isNumberFormat(input.get(0))) {
            this.total = convertNumber(input.get(0));
        }

        for(int i = 1; i < input.toArray().length; i++) {
            distribute(input.get(i), i);
        }
        return this.total;
    }

    /**
     * 문자 숫자 분리하여 처리하는 함수
     */
    private void distribute(String data, int location) {

        if(isNumberData(data, location)) {
            calculatorTotal(convertNumber(data));
            return;
        }
        if(isOperatorData(data, location)) {
            saveOperator(data);
            return;
        }
        throw new IllegalArgumentException("입력 값이 null 이거나 빈 공백 문자입니다");
    }

    /**
     * 지정된 위치의 데이터가 연산자인지 확인
     */
    private boolean isOperatorData(String data, int location) {
        return location % 2 == OPERATOR && isOperator(data);
    }

    /**
     * 지정된 위치의 데이터가 숫자인지 확인
     */
    private boolean isNumberData(String data, int location) {
        return location % 2 == NUMBER && isNumberFormat(data);
    }

    /**
     * 숫자인지 확인 하는 메소드
     */
    private boolean isNumberFormat(String number) {
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
        return Operator.valueOfOperator(operator) != null;
    }

    /**
     * 입력된 값을 현재 연산지로 지정한다
     */
    private void saveOperator(String operator) {
        this.nowOperator = operator;
    }

    /**
     * 값을 받아와 최종 값에 추가해준다
     */
    private void calculatorTotal(int num) {
        this.total = Operator.valueOfOperator(this.nowOperator).calculate(this.total, num);
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
