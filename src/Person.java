import java.util.Collections;
import java.util.Set;

public class Person extends BaseEntity {
    private String email;
    private byte[] passwordHash;
    private String groupHash; // Assuming SHA-256 hash for the group
    private Name name;  // Composite
    private Address address;  // Composite
    private String phoneNumber;
    private SkatTable tablePosition;
    private Set<Game> games;  // 0..* cardinality
    private Set<NetworkNegotiation> negotiations;  // 0..* cardinality

    // Protected no-arg constructor
    protected Person() {
        super();
        this.games = Collections.emptySet();
        this.negotiations = Collections.emptySet();
    }

    // Public constructor with arguments
    public Person(String email, byte[] passwordHash, String groupHash, Name name, Address address, String phoneNumber) {
        this();
        this.email = email;
        this.passwordHash = passwordHash;
        this.groupHash = groupHash;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter methods
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getGroupHash() {
        return groupHash;
    }

    public void setGroupHash(String groupHash) {
        this.groupHash = groupHash;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SkatTable getTablePosition() {
        return tablePosition;
    }

    public void setTablePosition(SkatTable tablePosition) {
        this.tablePosition = tablePosition;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public Set<NetworkNegotiation> getNegotiations() {
        return negotiations;
    }

    public void setNegotiations(Set<NetworkNegotiation> negotiations) {
        this.negotiations = negotiations;
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                ", passwordHash=" + passwordHash +
                ", groupHash='" + groupHash + '\'' +
                ", name=" + name +
                ", address=" + address +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", tablePosition=" + tablePosition +
                ", games=" + games +
                ", negotiations=" + negotiations +
                '}';
    }
}
