package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import no.hvl.dat250.jpa.tutorial.relationshipexample.Person;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Getter
    private String name;

    @Getter
    @ManyToMany()
    private final Collection<Address> addresses = new ArrayList<>();

    @Getter
    @ManyToMany()
    private final Collection<CreditCard> creditCards = new ArrayList<>();


}
