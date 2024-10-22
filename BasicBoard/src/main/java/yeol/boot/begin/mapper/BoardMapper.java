package yeol.boot.begin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yeol.boot.begin.entity.Board;

@Mapper
public interface BoardMapper {

    List<Board> getBoardList();  

    Board getBoardById(int id);

    void insertBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(int id); 
    
    List<Board> searchBoardByTitle(String keyword);
}
