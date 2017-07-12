package by.ecp.dto;

import lombok.*;

/**
 * Created by User on 07.07.2017.
 */
@Data
@NoArgsConstructor
@ToString
public class GameDto {
    private String nameGame;
    private Long companyId;
    private Long genreId;
    private Long paymentModelId;
    private Long settingId;
    private Long stageId;
    private Long platformsId;
}
