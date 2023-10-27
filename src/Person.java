import Enums.PersonGroup;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class Person extends BaseEntity {

    @NotNull
    private char[] email;
    @NotNull
    private byte[] passwordHash;
    @NotNull
    private PersonGroup group;
    @NotNull
    private long balance;
    @NotNull
    private Name name;
    @NotNull
    private Address address;
    @NotNull
    private Set<String> phones;
    @NotNull
    private Document avatar;
    private SkatTable table; //might be null
    private Byte tablePosition; // might be null
    @NotNull
    private Set<NetworkNegotiation> negotiations;

    // Protected no-arg constructor
    protected Person() {}

    // Public constructor with arguments
    public Person(char[] email, byte[] passwordHash, PersonGroup group, long balance, Name name, Address address, Set<String> phones, Document avatar, SkatTable table, Byte tablePosition, Set<NetworkNegotiation> negotiations) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.group = group;
        this.balance = balance;
        this.name = name;
        this.address = address;
        this.phones = phones;
        this.avatar = avatar;
        this.table = table;
        this.tablePosition = tablePosition;
        this.negotiations = negotiations;
    }

    // Getter and Setter methods
    public char[] getEmail() {
        return email;
    }

    public void setEmail(char[] email) {
        this.email = email;
    }

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    public PersonGroup getGroup() {
        return group;
    }

    public void setGroup(PersonGroup group) {
        this.group = group;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Name getName() {
        return name;
    }

    protected void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    protected void setAddress(Address address){
        this.address = address;
    }

    public Set<String> getPhones() {
        return phones;
    }

    protected void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public Document getAvatar() {
        return avatar;
    }

    public void setAvatar(Document avatar) {
        this.avatar = avatar;
    }

    public SkatTable getTable() {
        return table;
    }

    public void setTable(SkatTable table) {
        this.table = table;
    }

    public Byte getTablePosition() {
        return tablePosition;
    }

    public void setTablePosition(Byte tablePosition) {
        this.tablePosition = tablePosition;
    }

    public Set<NetworkNegotiation> getNegotiations() {
        return negotiations;
    }

    protected void setNegotiations(Set<NetworkNegotiation> negotiations){
        this.negotiations = negotiations;
    }
}
