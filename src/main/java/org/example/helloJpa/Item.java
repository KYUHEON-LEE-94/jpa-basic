package org.example.helloJpa;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) //조인전략
@DiscriminatorColumn(name="DIS_TYPE")
public class Item {

    @Id @GeneratedValue
    private long id;
    private String name;
    private int price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
