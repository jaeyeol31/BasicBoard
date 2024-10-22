package yeol.boot.begin.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {
	private int boardId;
	private String title;
	private String contents;
	private String boardWriter;
	private LocalDateTime createAt;
}
