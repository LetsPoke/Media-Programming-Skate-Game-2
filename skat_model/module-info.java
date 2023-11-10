module edu.sb.skat.model {
	requires transitive java.logging;
	requires transitive javax.annotation.api;
	requires transitive java.validation;
	requires transitive java.json.bind;
	
	requires transitive javax.persistence;
	requires transitive eclipselink.minus.jpa;
	requires transitive java.ws.rs;
	
	exports edu.damago.secondhand.persistance;
	
	opens edu.damago. secondhand.persitance;
}