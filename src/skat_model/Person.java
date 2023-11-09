package skat_model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person", schema = "skat")
public class Person extends BaseEntity {
    @NotNull
    @Size(min = 1, max = 128)
    @Email
    @Column(name = "email", nullable = false)
    private char[] email;
    private String passwordHash;
    private PersonGroup group;
    private long balance;
    private final Name name;
    private final Address address;
    private final List<String> phones;
    private Document avatar;
    private SkatTable table;
    private Byte tablePosition;
    private final List<NetworkNegotiation> negotiations;

    // Public Konstruktor für die Programmierung
    public Person(char[] email, String passwordHash, PersonGroup group, long balance,
                  Name name, Address address, List<String> phones) {
        // Aufruf des protected no-arg Konstruktors der BaseEntity
        super();
        this.email = Arrays.copyOf(email, email.length);
        this.passwordHash = passwordHash;
        this.group = group;
        this.balance = balance;
        this.name = name;
        this.address = address;
        this.phones = new ArrayList<>(phones);
        this.negotiations = new ArrayList<>();
    }

    @NotNull
    @Size(min = 1, max = 128)
    @Email
    public char[] getEmail() {
        return email;
    }

    public void setEmail(char[] value) {
        this.email = Arrays.copyOf(value, value.length);
    }

    @NotNull
    @Size(min = 64, max = 64)
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String value) {
        this.passwordHash = value;
    }

    @NotNull
    public PersonGroup getGroup() {
        return group;
    }

    public void setGroup(PersonGroup value) {
        this.group = value;
    }

    @NotNull
    public long getBalance() {
        return balance;
    }

    public void setBalance(long value) {
        this.balance = value;
    }

    @NotNull
    @Valid
    public Name getName() {
        return name;
    }

    protected void setName(Name value) {
        // readOnly, daher keine öffentliche Setter-Methode
    }

    @NotNull
    @Valid
    public Address getAddress() {
        return address;
    }

    protected void setAddress(Address value) {
        // readOnly, daher keine öffentliche Setter-Methode
    }

    public List<String> getPhones() {
        return new ArrayList<>(phones);
    }

    protected void setPhones(List<String> value) {
        this.phones.clear();
        this.phones.addAll(value);
    }

    @Valid
    public Document getAvatar() {
        return avatar;
    }

    public void setAvatar(Document value) {
        this.avatar = value;
    }

    @Valid
    public SkatTable getTable() {
        return table;
    }

    public void setTable(SkatTable value) {
        this.table = value;
    }

    public Byte getTablePosition() {
        return tablePosition;
    }

    public void setTablePosition(Byte value) {
        this.tablePosition = value;
    }

    public List<NetworkNegotiation> getNegotiations() {
        return new ArrayList<>(negotiations);
    }

    protected void setNegotiations(List<NetworkNegotiation> value) {
        this.negotiations.clear();
        this.negotiations.addAll(value);
    }
    @Override
	public String generateHash() {
        return HashTools.sha256Hash(Objects.hash(email, passwordHash, group, balance, name, address, phones, avatar, table, tablePosition, negotiations));
    }
}

