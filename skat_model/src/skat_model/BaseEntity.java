package skat_model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.validation.constraints.NotNull;

import edu.sb.skat.persistence.Comparable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "entity_type")
public abstract class BaseEntity implements Comparable<BaseEntity> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identity", nullable = false, updatable = false)
    private long identity;
    private int version;
    private long created;
    private long modified;

    protected BaseEntity() {
    }

    @NotNull
    public long getIdentity() {
        return identity;
    }

    protected void setIdentity(long value) {
        this.identity = value;
    }

    @NotNull
    @Column(name = "version", nullable = false)
    public int getVersion() {
        return version;
    }

    public void setVersion(int value) {
        this.version = value;
    }

    @Column(name = "created", nullable = false, updatable = false)
    public long getCreated() {
        return created;
    }

    protected void setCreated(long value) {
        this.created = value;
    }

    @Column(name = "modified", nullable = false)
    public long getModified() {
        return modified;
    }

    public void setModified(long value) {
        this.modified = value;
    }

    @Override
    public int compareTo(BaseEntity other) {
        return Long.compare(this.identity, other.identity);
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "identity=" + identity +
                ", version=" + version +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }

     public String generateHash() {
        return HashTools.sha256Hash(Objects.hash(identity, version, created, modified));
    }
}


