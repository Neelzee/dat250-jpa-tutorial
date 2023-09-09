package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Pincode {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pinCode;


    @Getter
    private Integer count;

    public String getCode() {
        return pinCode;
    }

}
