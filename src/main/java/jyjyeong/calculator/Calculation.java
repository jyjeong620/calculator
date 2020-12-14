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

    //TODO 입력된 연산자가 유효한지 확인



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
