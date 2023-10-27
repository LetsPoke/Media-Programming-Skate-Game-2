import javax.validation.constraints.NotNull;

public abstract class BaseEntity implements Comparable<BaseEntity> {

    @NotNull
    protected long identity;
    @NotNull
    protected int version;
    @NotNull
    protected long created;
    @NotNull
    protected long modified;

    // Protected no-arg constructor
    protected BaseEntity() {
        this(0L, 0, 0L, 0L);
    }


    // Public constructor with arguments
    public BaseEntity(long identity, int version, long created, long modified) {
        this.identity = identity;
        this.version = version;
        this.created = created;
        this.modified = modified;
    }

    // Getter and Setter methods
    public long getIdentity() {
        return identity;
    }

    protected void setIdentity(long identity) {
        this.identity = identity;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {this.version = version;}

    public long getCreated() {
        return created;
    }

    protected void setCreated(long created) {
        this.created = created;
    }

    public long getModified() {
        return modified;
    }

    public void setModified(long modified) {
        this.modified = modified;
    }

    @Override
    public int compareTo(BaseEntity other) {
        return Long.compare(this.created, other.created);
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "identity=" + identity +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
