package by.ecp.entity;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vinty on 07.04.2017.
 */
    @Entity
    @Table(name = "users")
    @NoArgsConstructor
    @ToString
    public class SystemUser extends BaseEntity {
    @Getter
    @Setter
    @Column(name = "name")
    private String nameUser;

    @Getter
    @Setter
    @Column(name = "family")
    private String familyUser;

    @NotEmpty
    @Getter
    @Setter
    @Column(name = "e_mail", nullable=false)
    private String email;

    @NotEmpty
    @Getter
    @Setter
    @Column(name = "password", nullable=false)
    private String passwordUser;

    @Getter
    @Setter
    @JoinTable(name = "users_privileges",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    @ManyToMany
    private Set<Privilege> privilege = new HashSet<>();

    @Getter
    @Setter
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Getter
    @Setter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "home_region_country")),
            @AttributeOverride(name = "city", column = @Column(name = "home_region_City"))
    })
    private Address firstAddress;

    @Getter
    @Setter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "payment_country")),
            @AttributeOverride(name = "city", column = @Column(name = "payment_city"))
    })
    private Address secondAddress;


}