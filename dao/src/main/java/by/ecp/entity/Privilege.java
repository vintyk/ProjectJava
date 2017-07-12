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
 * Created by Vinty on 21.04.2017.
 */
@Entity
@Table(name = "privileges")
@ToString
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "cache")
public class Privilege extends BaseEntity {
    @Setter
    @Getter
    @Column(name = "name")
    private String namePrivilege;
}
