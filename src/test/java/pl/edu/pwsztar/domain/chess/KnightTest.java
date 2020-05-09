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
            "2, 3, 5, 2",
            "2, 1, 3, 5",
            "2, 1, 3, 2",
            "4, 5, 2, 1",
            "5, 1, 3, 3",
            "3, 3, 2, 1",
            "1, 1, 2, 3",
            "1, 5, 3, 2",
    })
    void checkCorrectMoveForKnight(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(knight.isCorrectMove(xStart, yStart, xStop, yStop));
    }
    @Tag("Knight")
    @ParameterizedTest
    @CsvSource({
            "4, 4, 2, 3",
            "1, 1, 2, 4",
            "2, 2, 5, 6",
            "3, 3, 4, 7",
            "6, 4, 6, 8",
            "6, 5, -4, 8",
            "5, 2, 7, 9",
            "1, 5, 9, 5",
    })
    void checkIncorrectMoveForKnight(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(knight.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}