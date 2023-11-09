package snippet;

public class Snippet {
	    }
	
	    @Override
	    public String toString() {
	        return "BaseEntity{" +
	                "identity=" + identity +
	                ", version=" + version +
	                ", created=" + created +
	                ", modified=" + modified +
	                '}';
	    }
	
	    // Hashwert mit SHA-256 Algorithmus erzeugen
	    public String generateHash() {
	        return HashTools.sha256Hash(Objects.hash(identity, version, created, modified));
	    }
	}
	
}

