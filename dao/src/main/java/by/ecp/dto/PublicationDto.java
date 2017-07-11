package by.ecp.dto;

import by.ecp.entity.Game;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * Created by Vinty on 10.07.2017.
 */
@Data
@NoArgsConstructor
public class PublicationDto {
    @Getter
    @Setter
    private String namePublication;

    @Getter
    @Setter
    private String text;

    @Getter
    @Setter
    private Long gameId;
}
