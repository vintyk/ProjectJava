package by.ecp.dto;

import by.ecp.entity.English;
import by.ecp.entity.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by User on 10.07.2017.
 */
@Data
@NoArgsConstructor
@ToString
public class JobVacancyDto {
    private String nameUser;
    private String familyUser;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private English english;
    private Long vacancyId;
    private String comment;
}