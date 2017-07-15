package by.ecp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by User on 07.07.2017.
 */
@Data
@NoArgsConstructor
@ToString
public class CommonBaseGameDto {
    private String text;
    private Long gameId;
}
