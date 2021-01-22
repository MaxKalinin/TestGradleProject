package calculatorTests;

import static org.assertj.core.api.Assertions.*;

import calculator.Calculator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Tests {
    private static Calculator calculator;

    @BeforeAll
    static void createCalculatorInstance(){
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({
            "3+2+7",
            "3-(2+7)",
            "=5+4",
            "5",
            "9++76"
    })
    @DisplayName("Testing illegal statement")
    void testIllegalStatement(String input){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.inputProcessor(input));
    }

    @ParameterizedTest
    @CsvSource({
            "3+2, 5",
            "0+2, 2",
            "0+0, 0",
            "7+0, 7",
            "13+3, 16",
            "7+13, 20",
            "12+14, 26"
    })
    @DisplayName("Adding function positive testing")
    void testSumWithMultiArgSource(String input, int expectedResult) {
        calculator.inputProcessor(input);
        assertThat(calculator.getResult()).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "0-0, 0",
            "0-2, -2",
            "3-0, 3",
            "7-3, 4",
            "1-3, -2",
            "17-3, 14",
            "1-14, -13",
            "24-22, 2"
    })
    @DisplayName("Differ function positive testing")
    void testDifferWithMultiArgSource(String input, int expectedResult) {
        calculator.inputProcessor(input);
        assertThat(calculator.getResult()).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "0*0, 0",
            "0*2, 0",
            "3*0, 0",
            "7*3, 21",
            "11*3, 33",
            "1*14, 14",
            "24*22, 528"
    })
    @DisplayName("Multiply function positive testing")
    void testMultiplyWithMultiArgSource(String input, int expectedResult) {
        calculator.inputProcessor(input);
        assertThat(calculator.getResult()).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "0/0",
            "8/0",
            "45/0"
    })
    @DisplayName("Division function negative testing")
    void testDivisionToZeroWithMultiArgSource(String input) {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> calculator.inputProcessor(input));
    }

    @ParameterizedTest
    @CsvSource({
            "0/2, 0",
            "8/2, 4",
            "4/15, 0",
            "16/2, 8",
            "24/24, 1"
    })
    @DisplayName("Division function positive testing")
    void testDivisionWithMultiArgSource(String input, int expectedResult) {
        calculator.inputProcessor(input);
        assertThat(calculator.getResult()).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            " 3+2, 5",
            "0*2 , 0",
            " 6/3 , 2",
            "7 +0, 7",
            "13+ 3, 16",
            " 7 - 3 , 4"
    })
    @DisplayName("Trimming & whitespaces removing testing")
    void testTrimWithMultiArgSource(String input, int expectedResult) {
        calculator.inputProcessor(input);
        assertThat(calculator.getResult()).isEqualTo(expectedResult);
    }

    @AfterAll
    static void terminateCalculatorInstance(){
        calculator = null;
    }
}
