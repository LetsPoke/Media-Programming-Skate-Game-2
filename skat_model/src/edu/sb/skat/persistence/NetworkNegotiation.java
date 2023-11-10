package edu.sb.skat.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "network_negotiation", schema = "skat")
public class NetworkNegotiation extends BaseEntity {
    @NotNull
    @ManyToOne
    @JoinColumn(name = "negotiator_id", nullable = false)
    private Person negotiator;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private NetworkNegotiationType type;

    @NotNull
    @Column(name = "offer", nullable = false)
    private String offer;

    @Column(name = "answer")
    private String answer;

    public NetworkNegotiation(Person negotiator, NetworkNegotiationType type, String offer) {
        this.negotiator = negotiator;
        this.type = type;
        this.offer = offer;
    }

    public Person getNegotiator() {
        return negotiator;
    }

    protected void setNegotiator(Person value) {
     }

    public NetworkNegotiationType getType() {
        return type;
    }

    protected void setType(NetworkNegotiationType value) {
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String value) {
        this.offer = value;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String value) {
        this.answer = value;
    }
}

