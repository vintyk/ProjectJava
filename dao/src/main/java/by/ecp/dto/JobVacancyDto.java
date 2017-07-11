package by.ecp.dto;

import by.ecp.entity.English;
import by.ecp.entity.Gender;
import by.ecp.entity.Vacancy;
import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 10.07.2017.
 */
@Data
@NoArgsConstructor
@ToString
public class JobVacancyDto {
    @Getter
    @Setter
    private String nameUser;

    @Getter
    @Setter
    private String familyUser;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private English english;

    @Getter
    @Setter
    private Long vacancyId;

    @Getter
    @Setter
    private String comment;
}