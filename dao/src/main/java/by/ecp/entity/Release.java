package by.ecp.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Vinty on 05.06.2017.
 */
@Entity
@Table(name = "releases")
@NoArgsConstructor
@ToString
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "cache")
public class Release extends BaseEntity {


}
