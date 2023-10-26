import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Document extends BaseEntity {

    @NotNull
    private byte[] content;

    @NotNull
    @Size(max = 64)
    private String hash;

    @NotNull
    private String type;

    // Default no-arg constructor
    public Document() {}

    // Constructor with arguments
    public Document(long identity, int version, long created, long modified, byte[] content, String hash, String type) {
        super(identity, version, created, modified);
        this.content = content;
        this.hash = hash;
        this.type = type;
    }

    // Getter methods
    public byte[] getContent() {
        return content;
    }

    public String getHash() {
        return hash;
    }

    public String getType() {
        return type;
    }

    // Setter methods
    protected void setContent(byte[] content) {
        this.content = content;
    }

    protected void setHash(String hash) {
        this.hash = hash;
    }

    public void setType(String type) {
        this.type = type;
    }
}
