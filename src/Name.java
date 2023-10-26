public class Name {

    private String title; // optional
    private String given;
    private String family;
    private String suffix; // optional

    // Constructor
    public Name(String given, String family) {
        this.given = given;
        this.family = family;
    }

    // Overloaded Constructor with title and suffix
    public Name(String title, String given, String family, String suffix) {
        this.title = title;
        this.given = given;
        this.family = family;
        this.suffix = suffix;
    }

    // Getter and Setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String toString() {
        return "Name{" +
                "title='" + title + '\'' +
                ", given='" + given + '\'' +
                ", family='" + family + '\'' +
                ", suffix='" + suffix + '\'' +
                '}';
    }
}
