package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.*;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import no.hvl.dat250.jpa.tutorial.relationshipexample.Person;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @ManyToMany()
    private Set<Address> addresses = new HashSet<>();

    @Getter
    @Setter
    @ManyToMany()
    private Set<CreditCard> creditCards = new HashSet<>();


}
