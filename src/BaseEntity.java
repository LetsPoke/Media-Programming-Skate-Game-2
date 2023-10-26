import javax.validation.constraints.NotNull;

public abstract class BaseEntity implements Comparable<BaseEntity> {
    @NotNull
    protected long identity;
    @NotNull
    protected int version;
    @NotNull
    protected long created;
    protected long modified; // No @NotNull as it can be null if not modified

    // Protected no-arg constructor
    protected BaseEntity() {this(0L, 0, 0L, 0L);}

    // Public constructor with arguments
    public BaseEntity(long identity, int version, long created, long modified) {
        this.identity = identity;
        this.version = version;
        this.created = created;
        this.modified = modified;
    }

    // Getter methods
    public long getIdentity() {
        return identity;
    }

    public int getVersion() {
        return version;
    }

    public long getCreated() {
        return created;
    }

    public long getModified() {
        return modified;
    }

    // Protected Setter methods (as mentioned for a later task)
    protected void setIdentity(long identity) {
        this.identity = identity;
    }

    protected void setVersion(int version) {this.version = version;}

    protected void setCreated(long created) {
        this.created = created;
    }

    protected void setModified(long modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "identity=" + identity +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }

    @Override
    public int compareTo(BaseEntity other) {
        return Long.compare(this.created, other.created);
    }
}
