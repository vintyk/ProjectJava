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
 * Created by SystemUser on 02.06.2017.
 */
@Entity
@Table(name = "companies")
@ToString
@NoArgsConstructor
public class Company extends BaseEntity {

    @Getter
    @Setter
    @Column(name = "name")
    private String name;
}
