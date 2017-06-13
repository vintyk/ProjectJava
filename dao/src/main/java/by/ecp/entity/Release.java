package by.ecp.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by User on 05.06.2017.
 */
@Entity
@Table(name = "releases")
@NoArgsConstructor
@ToString
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "You_are_a_liar")
public class Release extends IdMotherClass{


}
