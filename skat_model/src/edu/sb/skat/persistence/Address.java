package edu.sb.skat.persistence;

import java.util.Comparator;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.sb.skat.util.HashCodes;

@Embeddable
public class Address implements Comparable<Address> {
	static private final Comparator<Address> COMPARATOR = Comparator
			.comparing(Address::getCountry)
			.thenComparing(Address::getCity)
			.thenComparing(Address::getStreet)
			.thenComparing(Address::getPostcode);
	
	
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

	@Override
	public int compareTo(Address other) {
		return COMPARATOR.compare(this, other);
	}
}

