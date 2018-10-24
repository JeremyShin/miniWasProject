package examples.dao.service;

import examples.dao.dto.Board;

import java.util.List;

public interface BoardService {
    public Board addBoard(Board board);
    public Board getBoard(Long id);
    public List<Board> getBoards(int start, int limit);
}
