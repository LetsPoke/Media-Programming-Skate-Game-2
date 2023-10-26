import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

public class Address {

    @NotNull
    private String street;
    @NotNull
    @Pattern(regexp = "\\d{5}")
    private String postcode;
    @NotNull
    private String city;
    @NotNull
    @Size(min = 2, max = 2)
    private String country;

    // Constructor
    public Address(String street, String postcode, String city, String country) {
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
    }

    // Getter and Setter methods
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
