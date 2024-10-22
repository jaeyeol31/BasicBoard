package yeol.boot.begin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import yeol.boot.begin.dto.BoardDTO;
import yeol.boot.begin.service.BoardService;

@SpringBootTest
@Transactional
class MapperTest {

	@Autowired
	private BoardService boardService;
//
//	@Test
//	public void testGetBoardById() {
//		// 게시글 ID가 1인 데이터를 조회 (DB에 있는 테스트 데이터를 가정)
//		BoardDTO boardDTO = boardService.getBoardById(1);
//
//		assertNotNull(boardDTO);
//		System.out.println("   제목   :" + boardDTO.getTitle());
//		System.out.println("   내용   :" + boardDTO.getContents());
//		System.out.println("  작성자  :" + boardDTO.getBoardWriter());
//		System.out.println("  작성시간 :" + boardDTO.getCreateAt());
//
//		// 검증 추가
//		assertEquals("Expected Title", boardDTO.getTitle()); // 'Expected Title'을 실제 데이터로 변경하세요
//	}

	@Test
	public void testInsertBoard() {
		// 새로운 게시글 작성
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("test2");
		boardDTO.setContents("test content");
		boardDTO.setBoardWriter("jay");

		// 게시글 삽입
		boardService.insertBoard(boardDTO);

//		// 삽입된 게시글 ID 확인 및 출력
//		int insertedId = boardDTO.getNotictId(); // 삽입 후 자동 생성된 ID를 가져옴
//		assertTrue(insertedId > 0);
//		System.out.println("Inserted Board ID: " + insertedId);
//
//		// 삽입한 게시글 ID로 다시 조회하여 확인
//		BoardDTO retrievedBoard = boardService.getBoardById(insertedId);
//		assertNotNull(retrievedBoard);
//		System.out.println("   제목   :" + retrievedBoard.getTitle());
//		System.out.println("   내용   :" + retrievedBoard.getContents());
//		System.out.println("  작성자  :" + retrievedBoard.getBoardWriter());
//		System.out.println("  작성시간 :" + retrievedBoard.getCreateAt());

		// 전체 게시글 목록을 확인
		List<BoardDTO> boardList = boardService.getAllBoards();
		assertNotNull(boardList);
		assertTrue(boardList.size() > 0);

		System.out.println("게시글 존재");
		System.out.println("=======전체게시글========");

		// 전체 게시글 목록에 대한 상세 내용 확인
		for (BoardDTO board : boardList) {
			System.out.println("게시글 번호: " + board.getBoardId());
			System.out.println("제목: " + board.getTitle());
			System.out.println("내용: " + board.getContents());
			System.out.println("작성자: " + board.getBoardWriter());
			System.out.println("작성일: " + board.getCreateAt());
			System.out.println("===============");
		}
	}
}
