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

	public List<Board> getAllBoards() {
		return boardMapper.getBoardList();
	}
}
