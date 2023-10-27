import Enums.NetworkNegotiationType;

public class NetworkNegotiation extends BaseEntity {

    private Person negotiator;
    private NetworkNegotiationType type;
    private String offer;
    private String answer;

    // Protected no-arg constructor
    protected NetworkNegotiation() {
        super();
    }

    // Public constructor with arguments
    public NetworkNegotiation(Person negotiator, NetworkNegotiationType type, String offer) {
        this();
        this.negotiator = negotiator;
        this.type = type;
        this.offer = offer;
    }

    // Getter and Setter methods
    public Person getNegotiator() {
        return negotiator;
    }

    public void setNegotiator(Person negotiator) {
        this.negotiator = negotiator;
    }

    public NetworkNegotiationType getType() {
        return type;
    }

    public void setType(NetworkNegotiationType type) {
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

    @Override
    public String toString() {
        return "NetworkNegotiation{" +
                "negotiator=" + negotiator +
                ", type=" + type +
                ", offer='" + offer + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
