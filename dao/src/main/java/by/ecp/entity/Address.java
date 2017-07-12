package by.ecp.entity;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Vinty on 12.06.2017.
 */
@Embeddable
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Long_happy_life")
public class Address {
    @Column(name = "country")
    @Getter
    @Setter
    private String country;
    @Column(name = "city")
    @Getter
    @Setter
    private String city;

}
