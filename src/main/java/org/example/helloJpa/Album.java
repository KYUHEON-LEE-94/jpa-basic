package org.example.helloJpa;

import javax.persistence.*;


@Entity
@DiscriminatorValue("ABUM")
public class Album extends Item{
    private String artist;
}
