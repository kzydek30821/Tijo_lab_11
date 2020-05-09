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
            "2, 5, 4, 6",
            "4, 2, 2, 6",
            "3, 5, 4, 6",
            "2, 5, 2, 5",
            "3, 5, 2, 4",
            "2, 5, 6, 4",
            "5, 4, 4, 4",
            "9, 7, 3, 5",
    })
    void checkCorrectMoveForKing(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(king.isCorrectMove(xStart, yStart, xStop, yStop));
    }
    @Tag("King")
    @ParameterizedTest
    @CsvSource({
            "5, 5, 5 ,7",
            "5, 5, 4 ,7",
            "5, 5, 6 ,7",
            "5, 5, 3 ,6",
            "5, 5, 3 ,5",
            "5, 5, 3, 4",
            "5, 5, 5, 5",
            "5, 5, 6, 7",
    })
    void checkIncorrectMoveForKing(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(king.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}