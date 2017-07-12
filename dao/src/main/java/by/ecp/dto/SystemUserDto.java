package by.ecp.dto;

import by.ecp.entity.Address;
import by.ecp.entity.Gender;
import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 05.07.2017.
 */
@Data
@NoArgsConstructor
@ToString
public class SystemUserDto {

    public SystemUserDto(
                String nameUser,
                String familyUser,
                String email,
                String passwordUser,
                Long privilegeId,
                Gender gender,
                Address firstAddress,
                Address secondAddress) {
            this.nameUser = nameUser;
            this.familyUser = familyUser;
            this.email = email;
            this.passwordUser = passwordUser;
            this.privilegeId = privilegeId;
            this.gender = gender;
            this.firstAddress = firstAddress;
            this.secondAddress = secondAddress;
        }
        private String nameUser;
        private String familyUser;
        private String email;
        private String passwordUser;
        private Long privilegeId;
        @Enumerated(EnumType.STRING)
        private Gender gender;
        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "country", column = @Column(name = "home_region_country")),
                @AttributeOverride(name = "city", column = @Column(name = "home_region_City"))
        })
        private Address firstAddress;
        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "country", column = @Column(name = "payment_country")),
                @AttributeOverride(name = "city", column = @Column(name = "payment_city"))
        })
        private Address secondAddress;

    }
