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
//Например, постапокалипcис, фантастика, фэнтези, наши дни, спорт.
  @Entity
  @Table(name = "settings")
  @NoArgsConstructor
  @ToString
public class Setting extends BaseEntity {
    @Getter
    @Setter
    @Column(name = "name")
    private String name;

}
