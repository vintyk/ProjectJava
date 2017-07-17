package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Vinty on 28.06.2017.
 */
@Entity
@Table(name = "jobs")
@NoArgsConstructor
@ToString
public class Job extends BaseEntity{
    @Getter
    @Setter
    @Column(name = "name")
    private String nameUser;

    @Getter
    @Setter
    @Column(name = "family")
    private String familyUser;

    @Getter
    @Setter
    @Column(name = "e_mail")
    private String email;

    @Getter
    @Setter
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Getter
    @Setter
    @Column(name = "english")
    @Enumerated(EnumType.STRING)
    private English english;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "vacancy_id", nullable = false)
    private Vacancy vacancy;

    @Getter
    @Setter
    @Column(name = "comment")
    private String comment;

   }
