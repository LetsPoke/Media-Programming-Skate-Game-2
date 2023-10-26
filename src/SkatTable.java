import java.util.Collections;
import java.util.Set;

public class SkatTable extends BaseEntity {

    private String alias;
    private Person player;
    private Document servingDocument;
    private Set<Game> games; // 0..* cardinality

    // Protected no-arg constructor
    protected SkatTable() {
        super();
        this.games = Collections.emptySet();
    }

    // Public constructor with arguments
    public SkatTable(String alias, Person player, Document servingDocument) {
        this();
        this.alias = alias;
        this.player = player;
        this.servingDocument = servingDocument;
    }

    // Getter and Setter methods
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Person getPlayer() {
        return player;
    }

    public void setPlayer(Person player) {
        this.player = player;
    }

    public Document getServingDocument() {
        return servingDocument;
    }

    public void setServingDocument(Document servingDocument) {
        this.servingDocument = servingDocument;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "SkatTable{" +
                "alias='" + alias + '\'' +
                ", player=" + player +
                ", servingDocument=" + servingDocument +
                ", games=" + games +
                '}';
    }
}
