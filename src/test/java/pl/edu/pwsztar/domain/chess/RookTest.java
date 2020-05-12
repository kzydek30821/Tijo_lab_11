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
            "4, 4, 4, 6",
            "4, 4, 4, 1",
            "4, 4, 8, 4",
    })
    void checkCorrectMoveForRook(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(rook.isCorrectMove(xStart, yStart, xStop, yStop));
    }
    @Tag("Rook")
    @ParameterizedTest
    @CsvSource({
            "4, 4, 5, 5",
            "4, 4, 3, 3",
            "4, 4, 3, 5",
    })
    void checkIncorrectMoveForRook(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(rook.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}