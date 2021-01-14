package jyjyeong.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class CalculationTest {



    @Test
    void splitTest(){
        Calculation calculation = new Calculation("1 + 2 - 3 * 2");
        List<String> inputs = calculation.getInput();

        System.out.println("출력 : ");
        for(String data : inputs){
            System.out.println(data + " ");
        }
        System.out.println();

    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void afads(){

    }


}