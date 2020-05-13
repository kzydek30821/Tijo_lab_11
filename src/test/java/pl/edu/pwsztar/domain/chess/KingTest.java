package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingTest {
    private RulesOfGame king = new RulesOfGame.King();

    @Tag("King")
    @ParameterizedTest
    @CsvSource({
            " 0,  0,  1, 1",

            " 0,  0,  -1, 0",

            " 0,  0, 0, 1",

            " 0,  0, 0, -1",
    })
    void checkCorrectMoveForKing(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(king.isCorrectMove(xStart, yStart, xStop, yStop));
    }
    @Tag("King")
    @ParameterizedTest
    @CsvSource({
            "0, 0, 2, 2",

            "-1, -1, -1, 10",

            "1, 1, 1, 1"
    })
    void checkIncorrectMoveForKing(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(king.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}