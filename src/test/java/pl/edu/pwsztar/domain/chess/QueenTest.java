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
            "4, 4, 4, 5",
            "4, 4, 3, 5",
            "4, 4, 3, 3",

    })
    void checkCorrectMoveForQueen(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(queen.isCorrectMove(xStart, yStart, xStop, yStop));
    }
    @Tag("Queen")
    @ParameterizedTest
    @CsvSource({
            "4, 4, 7 ,8",
            "4, 4, 1 ,6",
            "4, 4, 3 ,8",
    })
    void checkIncorrectMoveForQueen(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(queen.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}