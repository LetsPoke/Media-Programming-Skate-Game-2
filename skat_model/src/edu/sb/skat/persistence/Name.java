package edu.sb.skat.persistence;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//todo the same as in adress 

@Embeddable
public class Name {
    @Size(max = 255)
    @Column(nullable=true,updatable=true)
    private String title;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name="surname", nullable=false,updatable=true)
    private String family;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name="forename", nullable=false,updatable=true)
    private String given;

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

    @Transient
    public String generateHash() {
        return HashTools.sha256Hash(Objects.hash(title, family, given));
    }
}


