package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest {
    private RulesOfGame knight = new RulesOfGame.Knight();

    @Tag("Knight")
    @ParameterizedTest

    @CsvSource({

            " 0,  0,  1, 2",

            " 0,  0,  2, 1",

            " 0,  0, -1, -2",

            " 0,  1, -2, 0",

    })

    void checkCorrectMoveForKnight(int xStart, int yStart, int xStop, int yStop) {

        assertTrue(knight.isCorrectMove(xStart, yStart, xStop, yStop));

    }

    @ParameterizedTest

    @CsvSource({

            "0, 0, 1, 1",

            "0, 0, 0, 10"

    })

    void checkIncorrectMoveForKnight(int xStart, int yStart, int xStop, int yStop) {

        assertFalse(knight.isCorrectMove(xStart, yStart, xStop, yStop));

    }
}