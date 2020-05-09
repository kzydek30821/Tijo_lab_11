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
            "5, 4, 4, 3",
            "7, 7, 6, 6",
            "6, 3, 6, 2",
            "4, 1, 5, 2",
    })
    void checkCorrectMoveForKing(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(king.isCorrectMove(xStart, yStart, xStop, yStop));
    }
    @Tag("King")
    @ParameterizedTest
    @CsvSource({
            "5, 4, 9 ,9",
            "7, 7, 6, 9",
            "6, 3, 6, 8",
            "4, 1, -5, 2",
    })
    void checkIncorrectMoveForKing(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(king.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}