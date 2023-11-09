package skat_model;

import java.util.Objects;

import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Address {
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "street", nullable = false)
    private String street;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "postcode", nullable = false)
    private String postcode;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "country", nullable = false)
    private String country;

    // Protected no-arg Konstruktor für die Initialisierung der Felder
    protected Address() {
    }

    @Size(min = 1, max = 255)
    public String getStreet() {
        return street;
    }

    public void setStreet(String value) {
        this.street = value;
    }

    @Size(min = 1, max = 20)
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String value) {
        this.postcode = value;
    }

    @Size(min = 1, max = 255)
    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }

    @Size(min = 1, max = 255)
    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        this.country = value;
    }

    // Hashwert mit SHA-256 Algorithmus erzeugen
    @Transient
    public String generateHash() {
        return HashTools.sha256Hash(Objects.hash(street, postcode, city, country));
    }
}

