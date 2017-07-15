package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Vinty on 15.07.2017.
 */
@Entity
@Table(name = "common_base_game")
@ToString
@NoArgsConstructor
public class CommonBaseGame extends BaseEntity{

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @Getter
    @Setter
    @Column(name = "text")
    private String text;

    @Column(name = "version")
    @Version
    @Getter
    @Setter
    private long version;
}
