module edu.sb.skat.model {
	requires transitive java.logging;
	requires transitive java.validation;
	requires transitive javax.annotation.api;

	requires transitive java.json.bind;
	requires transitive java.ws.rs;
	requires transitive javax.persistence;
	requires transitive eclipselink.minus.jpa;

	// grants accessibility of the given packages to dependent projects
	exports edu.sb.skat.persistence;
	exports edu.sb.skat.service;
	exports edu.sb.skat.util;

	// grants reflective access to the given packages for JPA & JSON-B
	opens edu.sb.skat.persistence;
}