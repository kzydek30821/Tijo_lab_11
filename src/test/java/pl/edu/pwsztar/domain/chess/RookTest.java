package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RookTest {
    private RulesOfGame rook = new RulesOfGame.Rook();

    @Tag("Rook")
    @ParameterizedTest
    @CsvSource({
            " 0,  0, 0, 1",

            " 0,  0, 0, -1",

            " 1,  1, 1, 3",

            " 0, 0, 0, 200",

            "50, 0, 0, 0"
    })
    void checkCorrectMoveForRook(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(rook.isCorrectMove(xStart, yStart, xStop, yStop));
    }
    @Tag("Rook")
    @ParameterizedTest
    @CsvSource({
            "-1, -1, 1, 10",

            "1, 1, 1, 1",

            "0,  0, 1, 1"
    })
    void checkIncorrectMoveForRook(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(rook.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}