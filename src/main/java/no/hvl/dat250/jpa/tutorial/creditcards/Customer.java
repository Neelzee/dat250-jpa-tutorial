package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    private Collection<Address> addresses = new ArrayList<>();

    @Getter
    @Setter
    @ManyToMany()
    private Collection<CreditCard> creditCards = new ArrayList<>();


}
