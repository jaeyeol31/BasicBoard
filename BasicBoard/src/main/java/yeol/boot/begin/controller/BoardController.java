package yeol.boot.begin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import yeol.boot.begin.dto.BoardDTO;
import yeol.boot.begin.service.BoardService;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	@GetMapping("/boards")
	public String boardList(Model model) {
		// 서비스에서 전체 게시글을 조회하고 모델에 추가
		List<BoardDTO> boards = boardService.getAllBoards();
		model.addAttribute("boards", boards);
		return "boards"; // boards.jsp로 이동
	}
}
