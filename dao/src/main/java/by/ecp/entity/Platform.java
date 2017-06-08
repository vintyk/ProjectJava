package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 24.05.2017.
 */
@Entity
@Table(name="platforms")
@NoArgsConstructor
public class Platform extends IdMotherClass{
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
