package skat_model;

import java.util.ArrayList;
import java.util.List;



public class SkatTable {
    private String alias;
    private Document avatar;
    private final List<Person> players;
    private final List<Game> games;
    private long baseValuation;

    public SkatTable(String alias, Document avatar, List<Person> players, List<Game> games, long baseValuation) {
        this.alias = alias;
        this.avatar = avatar;
        this.players = new ArrayList<>(players);
        this.games = new ArrayList<>(games);
        this.baseValuation = baseValuation;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String value) {
        this.alias = value;
    }

    public Document getAvatar() {
        return avatar;
    }

    public void setAvatar(Document value) {
        this.avatar = value;
    }

    public List<Person> getPlayers() {
        return new ArrayList<>(players);
    }

    protected void setPlayers(List<Person> value) {
        this.players.clear();
        this.players.addAll(value);
    }

    public List<Game> getGames() {
        return new ArrayList<>(games);
    }

    protected void setGames(List<Game> value) {
        this.games.clear();
        this.games.addAll(value);
    }

    public long getBaseValuation() {
        return baseValuation;
    }

    public void setBaseValuation(long value) {
        this.baseValuation = value;
    }
}

