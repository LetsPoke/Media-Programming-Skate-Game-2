package edu.sb.skat.service;

import static java.util.Objects.requireNonNull;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;


/**
 * JAX-RS filter provider supporting HTTP "Basic" authentication within an HTTP client
 * environment. This aspect-oriented design adds HTTP "Basic Authorization" headers
 * to any REST service request being sent.
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class BasicAuthenticationSenderFilter implements ClientRequestFilter {
	private final String user;
	private final String password;


	/**
	 * Initializes a new instance.
	 * @param user the user
	 * @param password the password
	 * @throws NullPointerException if any of the given arguments is {@code null}
	 */
	public BasicAuthenticationSenderFilter (final String user, final String password) throws NullPointerException {
		this.user = requireNonNull(user);
		this.password = requireNonNull(password);
	}


	/**
	 * Returns the user.
	 * @return the user
	 */
	public String getUser () {
		return this.user;
	}


	/**
	 * Returns the password.
	 * @return the password
	 */
	public String getPassword () {
		return this.password;
	}


	/**
	 * Adds a HTTP "Basic Authorization" header to the given request context. This filter's
	 * user and password are combined and base64-encoded to generate said header's value.
	 * @param requestContext the request context
	 * @throws NullPointerException if the given argument is {@code null}
	 */
	public void filter (final ClientRequestContext requestContext) throws NullPointerException {
		final MultivaluedMap<String,Object> headers = requestContext.getHeaders();
		final String credentials = this.user + ":" + this.password;
		final String encodedCredentials = "Basic " + new String(Base64.getEncoder().encode(credentials.getBytes(StandardCharsets.UTF_8)));
		headers.add(HttpHeaders.AUTHORIZATION, encodedCredentials);
	}
}