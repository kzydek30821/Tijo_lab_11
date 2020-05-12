package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class PawnTest {
    private RulesOfGame pawn = new RulesOfGame.Pawn();

    @Tag("Pawn")
    @ParameterizedTest
    @CsvSource({
            "2,2,2,4",
            "2,2,2,3",
            "5,2,5,4",
            "5,2,5,3",
    })
    void checkCorrectMoveForPawn(int xStart, int yStart, int xStop, int yStop){
        assertTrue(pawn.isCorrectMove(xStart,yStart,xStop,yStop));
    }

    @Tag("Pawn")
    @ParameterizedTest
    @CsvSource({
            "2,2,2,6",
            "2,2,2,7",
            "5,2,5,8",
            "5,2,5,9",
    })
    void checkIncorrectMoveForPawn(int xStart, int yStart, int xStop, int yStop){
        assertFalse(pawn.isCorrectMove(xStart,yStart,xStop,yStop));
    }
}