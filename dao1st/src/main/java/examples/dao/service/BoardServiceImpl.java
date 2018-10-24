package examples.dao.service;

import examples.dao.dao.BoardDao;
import examples.dao.dto.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    private BoardDao boardDao;

    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    @Transactional
    public Board addBoard(Board board) {
        Long id = boardDao.addBoard(board);
        board.setId(id);
        return board;
    }

    @Override
    @Transactional
    public Board getBoard(Long id){
        boardDao.updateCount(id);
        Board board = boardDao.getBoard(id);
        return board;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Board> getBoards(int start, int limit) {
        return boardDao.getBoards();
    }
}
