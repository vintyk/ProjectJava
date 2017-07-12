package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vinty on 24.05.2017.
 */
@Entity
@Table(name="platforms")
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "we_trust_you")
public class Platform extends BaseEntity {
    @Setter
    @Getter
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "platforms")
    @Getter
    @Setter
    private Set<Game> games = new HashSet<>();

    public Platform(String name) {
        this.name = name;
    }
}
