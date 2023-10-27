import javax.validation.constraints.NotNull;

public class SkatTable extends BaseEntity {

    @NotNull
    private String alias;
    @NotNull
    private Document avatar;
    @NotNull
    private Person players; //todo: need to be fixed, should be different
    @NotNull
    private Game games; //todo: need to be fixed, should be different
    @NotNull
    private long baseValuation;

    // Protected no-arg constructor
    protected SkatTable() {}

    // Public constructor with arguments
    public SkatTable(String alias, Document avatar, Person players, Game games, long baseValuation) {
        this.alias = alias;
        this.avatar = avatar;
        this.players = players;
        this.games = games;
        this.baseValuation = baseValuation;
    }

    // Getter and Setter methods
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Document getAvatar() {
        return avatar;
    }

    public void setAvatar(Document avatar) {
        this.avatar = avatar;
    }

    public Person getPlayers() {
        return players;
    }

    protected void setPlayers(Person players) {
        this.players = players;
    }

    public Game getGames() {
        return games;
    }

    protected void setGames(Game games) {
        this.games = games;
    }

    public long getBaseValuation() { return baseValuation; }

    public void setBaseValuation(long baseValuation) {this.baseValuation = baseValuation; }
}
