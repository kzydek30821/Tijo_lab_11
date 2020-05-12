package pl.edu.pwsztar.domain.chess;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public interface RulesOfGame {

    /**
     * Metoda zwraca true, tylko gdy przejscie z polozenia
     * (xStart, yStart) na (xEnd, yEnd) w jednym ruchu jest zgodne
     * z zasadami gry w szachy
     */
    boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd);

    @Component
    @Qualifier("Bishop")
    class Bishop implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            if(xStart == xEnd && yStart == yEnd) {
                return false;
            }

            return Math.abs(xEnd - xStart) == Math.abs(yEnd - yStart);
        }
    }

    @Component
    @Qualifier("Knight")
    class Knight implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            if (xStart == xEnd && yStart == yEnd) {
                return false;
            }
            int diffVectorX = Math.abs(xStart-xEnd);
            int diffVectorY = Math.abs(yStart-yEnd);
            return (diffVectorX == 1 && diffVectorY == 2) || (diffVectorX == 2 && diffVectorY == 1);
        }
    }
    @Component
    @Qualifier("King")
    class King implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            if (xStart == xEnd && yStart == yEnd) {
                return false;
            }
            int diffVectorX = Math.abs(xStart-xEnd);
            int diffVectorY = Math.abs(yStart-yEnd);
            return (diffVectorX == 0 && diffVectorY == 1) || (diffVectorX == 1 && diffVectorY == 1) || (diffVectorX == 1 && diffVectorY == 0);
        }
    }

    @Component
    @Qualifier("Pawn")
    class Pawn implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            if (xStart == xEnd && yStart == yEnd) {
                return false;
            }
            int diffVectorX = Math.abs(xStart-xEnd);
            int diffVectorY = Math.abs(yStart-yEnd);
            return (diffVectorX == 0 && diffVectorY == 1) || (diffVectorX == 0 && diffVectorY == 2) || (diffVectorX == 1 && diffVectorY == 1);
        }
    }

    @Component
    @Qualifier("Queen")
    class Queen implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            if (xStart == xEnd && yStart == yEnd) {
                return false;
            }
            if(Math.abs(xEnd - xStart) == Math.abs(yEnd - yStart)){
                return true;
            }
            return (xStart == xEnd && yStart != yEnd) || (xStart != xEnd && yStart == yEnd);
        }
    }

    @Component
    @Qualifier("Rook")
    class Rook implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            if (xStart == xEnd && yStart == yEnd) {
                return false;
            }
            return (xStart == xEnd && yStart != yEnd) || (xStart != xEnd && yStart == yEnd);
        }
    }
}
