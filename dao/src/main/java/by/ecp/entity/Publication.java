package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Vinty on 09.06.2017.
 */
@Entity
@Table(name = "publications")
@NoArgsConstructor
@ToString
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL, region = "You_are_a_liar")
public class Publication extends BaseEntity {
    @Getter
    @Setter
    @Column(name = "name")
    private String namePublication;

    @Getter
    @Setter
    @Column(name = "text")
    private String text;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @Getter
    @Setter
    @Column(name = "date_publication")
    private LocalDate datePublication;
}
