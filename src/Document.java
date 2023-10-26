import java.util.Set;
import java.util.Collections;

public class Document {

    private final String alias;
    private final Person owner;
    private Set<Game> games = Collections.emptySet();
    private long baseValue;

    // Constructor
    public Document(String alias, Person owner) {
        this.alias = alias;
        this.owner = owner;
    }

    // Getter and Setter methods
    public String getAlias() {
        return alias;
    }

    public Person getOwner() {
        return owner;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public long getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(long baseValue) {
        this.baseValue = baseValue;
    }

    @Override
    public String toString() {
        return "Document{" +
                "alias='" + alias + '\'' +
                ", owner=" + owner +
                ", games=" + games +
                ", baseValue=" + baseValue +
                '}';
    }
}
