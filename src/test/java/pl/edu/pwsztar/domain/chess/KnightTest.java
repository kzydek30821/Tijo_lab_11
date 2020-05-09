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
            "4, 4, 3, 2",
            "2, 1, 3, 3",
            "7, 1, 6, 3",

    })
    void checkCorrectMoveForKnight(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(knight.isCorrectMove(xStart, yStart, xStop, yStop));
    }
    @Tag("Knight")
    @ParameterizedTest
    @CsvSource({
            "4, 4, 3, 5",
            "2, 1, 4, 6",
            "7, 1, -6, 9",
    })
    void checkIncorrectMoveForKnight(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(knight.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}