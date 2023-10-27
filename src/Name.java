import javax.validation.constraints.NotNull;

public class Name {

    private String title; // might be null
    @NotNull
    private String family;
    @NotNull
    private String given;

    // Protected no-arg constructor
    protected Name() {}

    // Constructor
    public Name(String title, String family, String given) {
        this.title = title;
        this.family = family;
        this.given = given;
    }

    // Getter and Setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }
}
