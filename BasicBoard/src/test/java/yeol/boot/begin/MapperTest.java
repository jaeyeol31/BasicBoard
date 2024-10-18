package yeol.boot.begin;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import yeol.boot.begin.entity.Board;
import yeol.boot.begin.service.BoardService;

@SpringBootTest
@Transactional
class MapperTest {

	@Autowired
	private BoardService boardService;

//    @Test
//    public void testGetBoardList() {
//        // 게시글 목록 조회
//        List<Board> boardList = boardService.getAllBoards();
//        assertNotNull(boardList);  // 목록이 null이 아닌지 확인
//        assertTrue(boardList.size() > 0);  // 게시글이 하나 이상 존재하는지 확인
//
//       System.out.println("게시글 존재");
//       System.out.println("===============");
//
//        // 전체 게시글 목록에 대한 상세 내용 확인
//        for (Board board : boardList) {
//            System.out.println("게시글 번호: " + board.getNotictId());
//            System.out.println("제목: " + board.getTitle());
//            System.out.println("내용: " + board.getContents());
//            System.out.println("작성자: " + board.getBoardWriter());
//            System.out.println("작성일: " + board.getCreateAt());
//            System.out.println("===============");
//            
//            // 각 게시글의 필드에 대해 assert 추가
//            assertNotNull(board.getNotictId());  // 게시글 ID 확인
//            assertNotNull(board.getTitle());  // 제목 확인
//            assertNotNull(board.getContents());  // 내용 확인
//            assertNotNull(board.getBoardWriter());  // 작성자 확인
//            assertNotNull(board.getCreateAt());  // 작성일 확인
//        }
//    }
	@Test
	public void testGetBoardById() {
		Board board = boardService.getBoadrdById(1);

		System.out.println("   제목   :" + board.getTitle());
		System.out.println("   내용   :" + board.getContents());
		System.out.println("  작성자  :" + board.getBoardWriter());
		System.out.println("  작성시간 :" + board.getCreateAt());

	}

	@Test
	public void testInsertBoard() {
		Board board = new Board();
		board.setTitle("test2");
		board.setContents("test content");
		board.setBoardWriter("jay");

		// 게시글 삽입 후 자동 생성된 ID가 board 객체에 설정됨
		boardService.insertBoard(board);
		int a = board.getNotictId();
		System.out.println(a);
		// 삽입한 게시글 ID를 가져와서 다시 조회

		List<Board> boardList = boardService.getAllBoards();
		assertNotNull(boardList); // 목록이 null이 아닌지 확인
		assertTrue(boardList.size() > 0); // 게시글이 하나 이상 존재하는지 확인

		System.out.println("게시글 존재");
		System.out.println("===============");

		// 전체 게시글 목록에 대한 상세 내용 확인
		for (Board board2 : boardList) {
			System.out.println("게시글 번호: " + board2.getNotictId());
			System.out.println("제목: " + board2.getTitle());
			System.out.println("내용: " + board2.getContents());
			System.out.println("작성자: " + board2.getBoardWriter());
			System.out.println("작성일: " + board2.getCreateAt());
			System.out.println("===============");
		}
	}

}
