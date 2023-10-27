import javax.validation.constraints.NotNull;

public class Hand extends BaseEntity {

    @NotNull
    private Game game;
    @NotNull
    private Person player;
    @NotNull
    private Card cards; //todo: need to be fixed, should be different
    @NotNull
    private boolean solo;
    @NotNull
    private short points;
    @NotNull
    private short bid;

    // Protected no-arg constructor
    protected Hand() {}

    // Public constructor with arguments
    public Hand(Game game, Person player, Card cards, boolean solo, short points, short bid) {
        this.game = game;
        this.player = player;
        this.cards = cards;
        this.solo = solo;
        this.points = points;
        this.bid = bid;
    }

    // Getter and Setter methods
    // public long getBet() { return bid; }
    // public void setBet(short bid) { this.bid = bid; }

    public Game getGame() {
        return game;
    }

    protected void setGame(Game game) {
        this.game = game;
    }

    public Person getPlayer() {
        return player;
    }

    protected void setPlayer(Person player) {
        this.player = player;
    }

    public Card getCards() {
        return cards;
    }

    protected void setCards(Card cards) {
        this.cards = cards;
    }

    public short getBid() {
        return bid;
    }

    public void setBid(short bid) {
        this.bid = bid;
    }

    public boolean getSolo() {
        return solo;
    }

    public void setSolo(boolean solo) {
        this.solo = solo;
    }

    public short getPoints() {
        return points;
    }

    public void setPoints(short points) {
        this.points = points;
    }
}
