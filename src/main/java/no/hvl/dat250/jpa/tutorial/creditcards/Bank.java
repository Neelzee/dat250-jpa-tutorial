package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Bank {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String name;

    @Getter
    @OneToMany()
    private Collection<CreditCard> ownedCards = new ArrayList<>();
}
