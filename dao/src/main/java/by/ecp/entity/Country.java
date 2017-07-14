package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Vinty on 24.05.2017.
 */
@Entity
@Table(name="countries")
@ToString
@NoArgsConstructor
public class Country extends BaseEntity {
    @Column(name = "name")
    @Getter
    @Setter
    private String name;
}
