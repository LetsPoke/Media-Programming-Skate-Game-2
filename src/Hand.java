import java.util.Collections;
import java.util.Set;

public class Hand extends BaseEntity {

    private Game game;
    private Person player;
    private Set<Card> cards; // 0..* cardinality
    private short points;

    // Protected no-arg constructor
    protected Hand() {
        super();
        this.cards = Collections.emptySet();
    }

    // Public constructor with arguments
    public Hand(Game game, Person player, short points) {
        this();
        this.game = game;
        this.player = player;
        this.points = points;
    }

    // Getter and Setter methods
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Person getPlayer() {
        return player;
    }

    public void setPlayer(Person player) {
        this.player = player;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public short getPoints() {
        return points;
    }

    public void setPoints(short points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "game=" + game +
                ", player=" + player +
                ", cards=" + cards +
                ", points=" + points +
                '}';
    }
}
