package by.ecp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SystemUser on 02.06.2017.
 */
@Entity
@Table(name = "games")
@NoArgsConstructor
@ToString(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode
public class Game extends BaseEntity {
    @Getter
    @Setter
    @Column(name = "name")
    private String nameGame;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "payment_model_id", nullable = false)
    private PaymentModel paymentModel;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "setting_id", nullable = false)
    private Setting setting;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "stage_id", nullable = false)
    private Stage stage;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(name = "games_platforms",
            joinColumns = @JoinColumn(name = "games_id"),
            inverseJoinColumns = @JoinColumn(name = "platforms_id")
    )
    private Set<Platform> platforms = new HashSet<>();


}
