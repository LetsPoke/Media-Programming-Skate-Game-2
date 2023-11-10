package edu.sb.skat.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import javax.json.bind.config.PropertyVisibilityStrategy;


/**
 * <i>JSON-B</i> property strategy that considers protected and public getters as properties, but not fields. Note that
 * <i>JSON-B</i> does not support direct field access during marshaling (except for public fields), therefore field annotation
 * strategies are castrated to the point of being useless. This access strategy therefore never considered fields as properties,
 * in opposition to <i>public</i> and <i>protected</i> accessor methods. The latter option provides a design pathway for a
 * privileged engine access API that does not require exposing forbidden operations to a programmatic access API, similar to
 * field access strategies. The two drawbacks compared to pure field access strategies are that <i>final</i> fields cannot
 * support unmarshaling, and that setter accessors must be provided for unmarshaling even if they are not required/forbidden in
 * the programmatic API - both of which are acceptable in practical terms.
 */
@Copyright(year=2017, holders="Sascha Baumeister")
public class JsonProtectedPropertyStrategy implements PropertyVisibilityStrategy {

	/**
	 * {@inheritDoc}
	 */
	public boolean isVisible (final Field field) {
		return false;
	}


	/**
	 * {@inheritDoc}
	 */
	public boolean isVisible (final Method method) {
		final int modifiers = method.getModifiers();
		return Modifier.isPublic(modifiers) | Modifier.isProtected(modifiers);
	}
}