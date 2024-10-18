package yeol.boot.begin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import yeol.boot.begin.entity.Board;
import yeol.boot.begin.mapper.BoardMapper;

@Service
@RequiredArgsConstructor
public class BoardService {
	@Autowired
	private final BoardMapper boardMapper;

	// 전체 조
	public List<Board> getAllBoards() {
		return boardMapper.getBoardList();
	}

	// 상세 조회
	public Board getBoadrdById(int id) {
		return boardMapper.getBoardById(id);
	}

	// 게시글 작성
	public void insertBoard(Board board) {
		boardMapper.insertBoard(board);
	}

	// 게시글 수정
	public void updateBoard(Board board) {
		boardMapper.updateBoard(board);
	}

	// 게시글 삭제
	public void deleteBoard(int id) {
		boardMapper.deleteBoard(id);

	}
}
