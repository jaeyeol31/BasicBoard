package yeol.boot.begin.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Board {
    private int notictId;  // NOTICT_ID
    private String title;  // TITLE
    private String contents;  // CONTENT
    private String boardWriter;  // BOARD_WRITER
    private LocalDateTime createAt;  // CREATED_AT
}
