package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueenTest {
    private RulesOfGame queen = new RulesOfGame.Queen();

    @Tag("Queen")
    @ParameterizedTest
    @CsvSource({
            " 0,  0,  1, 1",

            " 0,  0,  -1, 0",

            " 0,  0, 0, 1",

            " 0,  0, 0, -1",

            " 0,  0, 10, 10",

            " 1,  1, -1, 3",

            " 0, 0, 0, 200",

            "50, 0, 0, 0"

    })
    void checkCorrectMoveForQueen(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(queen.isCorrectMove(xStart, yStart, xStop, yStop));
    }
    @Tag("Queen")
    @ParameterizedTest
    @CsvSource({
            "-1, -1, 1, 10",

            "1, 1, 1, 1"
    })
    void checkIncorrectMoveForQueen(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(queen.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}