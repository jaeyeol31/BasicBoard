package yeol.boot.begin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;
import yeol.boot.begin.dto.BoardDTO;
import yeol.boot.begin.entity.Board;
import yeol.boot.begin.service.BoardService;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	// 전체 조회
	@GetMapping("/boards")
	public String boardList(Model model) {
		List<BoardDTO> boards = boardService.getAllBoards();
		model.addAttribute("boards", boards);
		return "boards";
	}

	// 상세 조회
	@GetMapping("/board/{notictId}")
	public String getBoardById(@PathVariable("notictId") int notictId, Model model) {
		BoardDTO board = boardService.getBoardById(notictId);
		model.addAttribute("board", board);
		return "board";
	}

	// 입력 폼
	@GetMapping("/board/new")
	public String saveBoard(Model model) {
		model.addAttribute("model", new BoardDTO());
		return "/board-form";
	}

	// 저장
	@PostMapping("/board/save")
	public String saveBoard(BoardDTO boardDTO) {
		boardService.insertBoard(boardDTO);
		return "redirect:/boards";
	}

	// 수정 폼
	@GetMapping("/board/update/{notictId}")
	public String updateBoard(@PathVariable("notictId") int id, Model model) {
		BoardDTO board = boardService.getBoardById(id);
		model.addAttribute("board", board);
		return "/board-form";
	}

	// 수정
	@PostMapping("/board/update/{notictId}")
	public String updateBoard(@PathVariable("notictId") int notictId, BoardDTO boardDTO) {
		boardDTO.setNotictId(notictId);
		boardService.updateBoard(boardDTO);
		return "redirect:/boards";
	}

}
