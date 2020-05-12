package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.chess.RulesOfGame;
import pl.edu.pwsztar.domain.dto.FigureMoveDto;
import pl.edu.pwsztar.domain.enums.FigureType;
import pl.edu.pwsztar.service.ChessService;

@Service
public class ChessServiceImpl implements ChessService {

    private RulesOfGame bishop;
    private RulesOfGame knight;
    private RulesOfGame king;
    private RulesOfGame pawn;
    private RulesOfGame queen;
    private RulesOfGame rook;

    @Autowired
    public ChessServiceImpl(@Qualifier("Bishop") RulesOfGame bishop,
                            @Qualifier("Knight") RulesOfGame knight,
                            @Qualifier("King") RulesOfGame king,
                            @Qualifier("Pawn") RulesOfGame pawn,
                            @Qualifier("Queen") RulesOfGame queen,
                            @Qualifier("Rook") RulesOfGame rook) {
        this.bishop = bishop;
        this.knight = knight;
        this.king = king;
        this.pawn = pawn;
        this.queen = queen;
        this.rook = rook;
    }

    @Override
    public boolean isCorrectMove(FigureMoveDto figureMoveDto) {
        return figureMove(figureMoveDto);

    }

    private boolean figureMove(FigureMoveDto figureMoveDto) {
        FigureType figureType = figureMoveDto.getType();
        final char[] start = figureMoveDto.getStart().replace("_", "").toCharArray();
        final char[] destination = figureMoveDto.getDestination().replace("_", "").toCharArray();
        switch (figureType) {
            case KING:
                return this.king.isCorrectMove(start[0], start[1], destination[0], destination[1]);
            case BISHOP:
                return this.bishop.isCorrectMove(start[0], start[1], destination[0], destination[1]);
            case KNIGHT:
                return this.knight.isCorrectMove(start[0], start[1], destination[0], destination[1]);
            case ROCK:
                return this.rook.isCorrectMove(start[0],start[1],destination[0],destination[1]);
            case QUEEN:
                return this.queen.isCorrectMove(start[0],start[1],destination[0],destination[1]);
            case PAWN:
                return this.pawn.isCorrectMove(start[0],start[1],destination[0],destination[1]);
            default:
                return false;
        }
    }
}