package skat_model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "document", schema = "skat")
public class Document extends BaseEntity {
    @NotNull
    @Column(name = "content", nullable = false)
    private byte[] content;

    @NotNull
    @Size(min = 64, max = 64)
    @Column(name = "hash", nullable = false)
    private String hash;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type", nullable = false)
    private String type;

    // Konstruktor für JPA
    protected Document() {
    }

    // Argument-behafteter Konstruktor für die Anwendung
    public Document(byte[] content, String type) {
        this.content = content;
        this.type = type;
        this.hash = generateHash();
    }

    // Getter und Setter ...

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Size(min = 1, max = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @NotNull
    @Size(min = 64, max = 64)
    public String getHash() {
        return hash;
    }

    // Hashwert mit SHA-256 Algorithmus erzeugen
    @Override
	@Transient
    public String generateHash() {
        return HashTools.sha256Hash(Objects.hash(content, type));
    }

    // Comparable-Interface
    @Override
    public int compareTo(BaseEntity other) {
        if (other instanceof Document) {
            return this.getType().compareTo(((Document) other).getType());
        }
        return super.compareTo(other);
    }
}


