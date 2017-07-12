package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Vinty on 24.05.2017.
 */
@Entity
@Table(name = "ranks")
@NoArgsConstructor
@ToString
public class Rank extends BaseEntity {
    @Column(name = "value")
    @Getter
    @Setter
    private int value;
}
