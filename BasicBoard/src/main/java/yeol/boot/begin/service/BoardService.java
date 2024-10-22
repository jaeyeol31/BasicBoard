package yeol.boot.begin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import yeol.boot.begin.dto.BoardDTO;
import yeol.boot.begin.entity.Board;
import yeol.boot.begin.mapper.BoardMapper;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	@Autowired
	private final BoardMapper boardMapper;

	// 전체 조회 (Entity -> DTO 변환)
	public List<BoardDTO> getAllBoards() {
		List<Board> boards = boardMapper.getBoardList();
		List<BoardDTO> boardDTOList = new ArrayList<>();
		for (Board board : boards) {
			boardDTOList.add(convertToDto(board));
		}
		return boardDTOList;
	}

	// 상세 조회 (Entity -> DTO 변환)
	public BoardDTO getBoardById(int id) {
		Board board = boardMapper.getBoardById(id);
		return convertToDto(board);
	}

	// 게시글 작성 (DTO -> Entity 변환)
	public void insertBoard(BoardDTO boardDTO) {
		Board board = convertToEntity(boardDTO);
		boardMapper.insertBoard(board);
	}

	// 게시글 수정 (DTO -> Entity 변환)
	public void updateBoard(BoardDTO boardDTO) {
		Board board = convertToEntity(boardDTO);
		boardMapper.updateBoard(board);
	}

	// 게시글 삭제
	public void deleteBoard(int id) {
		boardMapper.deleteBoard(id);
	}
	
	// 제목으로 게시글 검색
    public List<BoardDTO> searchBoardByTitle(String keyword) {
        List<Board> boards = boardMapper.searchBoardByTitle(keyword);
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (Board board : boards) {
            boardDTOList.add(convertToDto(board));
        }

        return boardDTOList;
    }

	// Entity -> DTO 변환 메서드
	private BoardDTO convertToDto(Board board) {
		BoardDTO boardDTO = new BoardDTO();
		BeanUtils.copyProperties(board, boardDTO);
		return boardDTO;
	}

	// DTO -> Entity 변환 메서드
	private Board convertToEntity(BoardDTO boardDTO) {
		Board board = new Board();
		BeanUtils.copyProperties(boardDTO, board);
		return board;
	}
}
