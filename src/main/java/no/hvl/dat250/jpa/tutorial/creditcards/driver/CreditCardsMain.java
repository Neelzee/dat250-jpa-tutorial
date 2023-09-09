package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.ArrayList;
import java.util.Objects;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {



    Address a = new Address();

    a.setNumber(28);
    a.setStreet("Inndalsveien");

    ArrayList<Address> l = new ArrayList<>();
    l.add(a);

    ArrayList<Customer> customers = new ArrayList<>();

    Customer c = new Customer();
    customers.add(c);

    a.setOwners(customers);

    c.setName("Max Mustermann");
    c.setAddresses(l);

    CreditCard card2 = new CreditCard();
    card2.setNumber(123);
    card2.setBalance(1);
    card2.setCreditLimit(2000);



    CreditCard card1 = new CreditCard();
    card1.setNumber(12345);
    card1.setBalance(-5000);
    card1.setCreditLimit(-10000);

    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    card1.setPincode(pincode);
    card2.setPincode(pincode);

    Bank bank = new Bank();
    bank.setName("Pengebank");

    ArrayList<CreditCard> creditCards = new ArrayList<>();
    creditCards.add(card1);
    creditCards.add(card2);

    bank.setOwnedCards(creditCards);

    card1.setOwningBank(bank);
    card2.setOwningBank(bank);

    c.setCreditCards(creditCards);


    em.persist(a);
    em.persist(c);
    em.persist(card2);
    em.persist(card1);
    em.persist(pincode);
    em.persist(bank);
  }
}
