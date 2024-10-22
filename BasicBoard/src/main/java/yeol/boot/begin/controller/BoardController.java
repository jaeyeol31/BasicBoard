package yeol.boot.begin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import yeol.boot.begin.dto.BoardDTO;
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
	@GetMapping("/board/{boardId}")
	public String getBoardById(@PathVariable("boardId") int boardId, Model model) {
		BoardDTO board = boardService.getBoardById(boardId);
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
	@GetMapping("/board/update/{boardId}")
	public String updateBoard(@PathVariable("boardId") int id, Model model) {
		BoardDTO board = boardService.getBoardById(id);
		model.addAttribute("board", board);
		return "/board-form";
	}

	// 수정
	@PostMapping("/board/update/{boardId}")
	public String updateBoard(@PathVariable("boardId") int boardId, BoardDTO boardDTO) {
		boardDTO.setBoardId(boardId);
		boardService.updateBoard(boardDTO);
		return "redirect:/boards";
	}

	// 삭제 확인
	@GetMapping("/board/delete/{boardId}")
	public String deleteConfirmation(@PathVariable("boardId") int boardId, Model model) {
		BoardDTO board = boardService.getBoardById(boardId);
		model.addAttribute("board", board);
		return "delete-confirmation";
	}

	// 삭제
	@PostMapping("/board/delete/{boardId}")
	public String deleteBoard(@PathVariable("boardId") int boardId) {
		boardService.deleteBoard(boardId);

		return "redirect:/boards";
	}

	// 제목으로 게시글 검색
    @GetMapping("/board/search")
    public String searchBoardByTitle(@RequestParam("keyword") String keyword, Model model) {
        List<BoardDTO> boards = boardService.searchBoardByTitle(keyword);
        model.addAttribute("boards", boards);

        return "search-result";
    }
	
}
