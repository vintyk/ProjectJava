package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by User on 21.04.2017.
 */
@Entity
@Table(name = "privileges")
@ToString
@NoArgsConstructor
public class Privilege {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Getter
    @Column(name = "name")
    private String namePrivilege;
}
