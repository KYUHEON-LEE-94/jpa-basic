package org.example.helloJpa;

import javax.persistence.*;


@Entity
@DiscriminatorValue("ABUM")
public class Album extends Item{
    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
