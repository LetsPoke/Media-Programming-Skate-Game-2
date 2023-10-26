public abstract class BaseEntity implements Comparable<BaseEntity> {
    protected boolean identity;
    protected long created;
    protected long modified;

    // Protected no-arg constructor
    protected BaseEntity() {
        this(true, System.currentTimeMillis(), System.currentTimeMillis());
    }

    // Public constructor with arguments
    public BaseEntity(boolean identity, long created, long modified) {
        this.identity = identity;
        this.created = created;
        this.modified = modified;
    }

    // Getter methods
    public boolean isIdentity() {
        return identity;
    }

    public long getCreated() {
        return created;
    }

    public long getModified() {
        return modified;
    }

    // Protected Setter methods (as mentioned for a later task)
    protected void setIdentity(boolean identity) {
        this.identity = identity;
    }

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
