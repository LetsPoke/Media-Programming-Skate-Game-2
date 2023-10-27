import Enums.NetworkNegotiationType;
import javax.validation.constraints.NotNull;

public class NetworkNegotiation extends BaseEntity {

    @NotNull
    private Person negotiator;
    @NotNull
    private NetworkNegotiationType type;
    @NotNull
    private String offer;
    private String answer; //might be null

    // Protected no-arg constructor
    protected NetworkNegotiation() {}

    // Public constructor with arguments
    public NetworkNegotiation(Person negotiator, NetworkNegotiationType type, String offer, String answer) {
        this.negotiator = negotiator;
        this.type = type;
        this.offer = offer;
        this.answer = answer;
    }

    // Getter and Setter methods
    public Person getNegotiator() {
        return negotiator;
    }

    protected void setNegotiator(Person negotiator) {
        this.negotiator = negotiator;
    }

    public NetworkNegotiationType getType() {
        return type;
    }

    protected void setType(NetworkNegotiationType type) {
        this.type = type;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
