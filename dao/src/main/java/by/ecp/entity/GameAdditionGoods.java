package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Vinty on 12.06.2017.
 */
@Entity
@ToString(callSuper = true)
@Table(name = "game_addition_goods")
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "game_id")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL, region = "You_are_a_liar")
public class GameAdditionGoods extends Game{
    @Column(name = "name")
    @Getter
    @Setter
    private String nameGoods;
    }
