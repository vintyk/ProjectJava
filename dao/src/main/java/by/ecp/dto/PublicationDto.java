package by.ecp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Vinty on 10.07.2017.
 */
@Data
@NoArgsConstructor
public class PublicationDto {
    private String namePublication;
    private String text;
    private Long gameId;
}
