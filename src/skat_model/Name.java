package skat_model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Embeddable
public class Name {
    @Size(max = 255)
    @Column(name = "title")
    private String title;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "family", nullable = false)
    private String family;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "given", nullable = false)
    private String given;

    // Protected no-arg Konstruktor für die Initialisierung der Felder
    protected Name() {
    }

    @Size(max = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    @NotNull
    @Size(min = 1, max = 255)
    public String getFamily() {
        return family;
    }

    public void setFamily(String value) {
        this.family = value;
    }

    @NotNull
    @Size(min = 1, max = 255)
    public String getGiven() {
        return given;
    }

    public void setGiven(String value) {
        this.given = value;
    }

    // Hashwert mit SHA-256 Algorithmus erzeugen
    @Transient
    public String generateHash() {
        return HashTools.sha256Hash(Objects.hash(title, family, given));
    }
}


