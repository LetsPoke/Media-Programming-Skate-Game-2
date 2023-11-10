package edu.sb.skat.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;


/**
 * Defines a minimal meta-data model for copyrights in code.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Copyright.Wrapper.class)
@Copyright(year = 2016, holders = "Sascha Baumeister")
public @interface Copyright {

	/**
	 * The initial (gregorian) year of copyright claim.
	 */
	int year();


	/**
	 * The copyright holders.
	 */
	String[] holders();


	/**
	 * The default licenses defining use permits.
	 */
	String[] licenses() default {};



	/**
	 * Implicitly used to annotate repeated instances of the outer annotation.
	 */
	@Documented
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	static @interface Wrapper {
		Copyright[]value();
	}
}