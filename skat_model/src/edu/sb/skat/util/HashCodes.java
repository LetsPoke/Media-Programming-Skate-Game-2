package edu.sb.skat.util;

import static edu.sb.skat.util.NumeralSystems.toHexadecimal;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * This facade provides operations to calculate MD5, SHA1, SHA2 and SHA3 hash codes.
 */
@Copyright(year=2017, holders="Sascha Baumeister")
public final class HashCodes {
	static private final String MD5_ALGORITHM = "MD5";
	static private final String SHA1_ALGORITHM = "SHA-1";
	static private final String SHA2_224_ALGORITHM = "SHA-224";
	static private final String SHA2_256_ALGORITHM = "SHA-256";
	static private final String SHA2_384_ALGORITHM = "SHA-384";
	static private final String SHA2_512_ALGORITHM = "SHA-512/256";
	static private final String SHA3_224_ALGORITHM = "SHA3-224";
	static private final String SHA3_256_ALGORITHM = "SHA3-256";
	static private final String SHA3_384_ALGORITHM = "SHA3-384";
	static private final String SHA3_512_ALGORITHM = "SHA3-512";
	static private final byte[] EMPTY = new byte[0];
	static private byte[] MD5_DEFAULT = md5HashCode(EMPTY);
	static private byte[] SHA1_DEFAULT = sha1HashCode(EMPTY);
	static private byte[] SHA2_224_DEFAULT = sha2HashCode(224, EMPTY);
	static private byte[] SHA2_256_DEFAULT = sha2HashCode(256, EMPTY);
	static private byte[] SHA2_384_DEFAULT = sha2HashCode(384, EMPTY);
	static private byte[] SHA2_512_DEFAULT = sha2HashCode(512, EMPTY);
	static private byte[] SHA3_224_DEFAULT = sha3HashCode(224, EMPTY);
	static private byte[] SHA3_256_DEFAULT = sha3HashCode(256, EMPTY);
	static private byte[] SHA3_384_DEFAULT = sha3HashCode(384, EMPTY);
	static private byte[] SHA3_512_DEFAULT = sha3HashCode(512, EMPTY);


	/**
	 * Returns the quasi-unique MD5 hash of the given binary content.
	 * @param content the binary content, or {@code null} for none
	 * @return the corresponding MD5 hash code
	 */
	static public byte[] md5HashCode (final byte[] content) {
		try {
			return content == null ? MD5_DEFAULT.clone() : MessageDigest.getInstance(MD5_ALGORITHM).digest(content);
		} catch (final NoSuchAlgorithmException exception) {
			throw new AssertionError(exception);
		}
	}


	/**
	 * Returns the quasi-unique SHA1 hash of the given binary content.
	 * @param content the binary content, or {@code null} for none
	 * @return the corresponding SHA1 hash code
	 */
	static public byte[] sha1HashCode (final byte[] content) {
		try {
			return content == null ? SHA1_DEFAULT.clone() : MessageDigest.getInstance(SHA1_ALGORITHM).digest(content);
		} catch (final NoSuchAlgorithmException exception) {
			throw new AssertionError(exception);
		}
	}


	/**
	 * Returns the quasi-unique SHA2 hash of the given binary content.
	 * @param bitLength the hash bit length, either 224, 256, 384 or 512
	 * @param content the binary content, or {@code null} for none
	 * @return the corresponding SHA2 hash code
	 * @throws IllegalArgumentException if the given bit length is neither 224, nor 256, nor 384, nor 512
	 */
	static public byte[] sha2HashCode (final int bitLength, final byte[] content) throws IllegalArgumentException {
		final byte[] defaultHash;
		final String algorithm;
		switch (bitLength) {
			case 224:
				defaultHash = SHA2_224_DEFAULT;
				algorithm = SHA2_224_ALGORITHM;
				break;
			case 256:
				defaultHash = SHA2_256_DEFAULT;
				algorithm = SHA2_256_ALGORITHM;
				break;
			case 384:
				defaultHash = SHA2_384_DEFAULT;
				algorithm = SHA2_384_ALGORITHM;
				break;
			case 512:
				defaultHash = SHA2_512_DEFAULT;
				algorithm = SHA2_512_ALGORITHM;
				break;
			default:
				throw new IllegalArgumentException();
		}

		try {
			return content == null ? defaultHash.clone() : MessageDigest.getInstance(algorithm).digest(content);
		} catch (final NoSuchAlgorithmException exception) {
			throw new AssertionError(exception);
		}
	}


	/**
	 * Returns the quasi-unique SHA3 hash of the given binary content.
	 * @param bitLength the hash bit length, either 224, 256, 384 or 512
	 * @param content the binary content, or {@code null} for none
	 * @return the corresponding SHA3 hash code
	 * @throws IllegalArgumentException if the given bit length is neither 224, nor 256, nor 384, nor 512
	 */
	static public byte[] sha3HashCode (final int bitLength, final byte[] content) throws IllegalArgumentException {
		final byte[] defaultHash;
		final String algorithm;
		switch (bitLength) {
			case 224:
				defaultHash = SHA3_224_DEFAULT;
				algorithm = SHA3_224_ALGORITHM;
				break;
			case 256:
				defaultHash = SHA3_256_DEFAULT;
				algorithm = SHA3_256_ALGORITHM;
				break;
			case 384:
				defaultHash = SHA3_384_DEFAULT;
				algorithm = SHA3_384_ALGORITHM;
				break;
			case 512:
				defaultHash = SHA3_512_DEFAULT;
				algorithm = SHA3_512_ALGORITHM;
				break;
			default:
				throw new IllegalArgumentException();
		}

		try {
			return content == null ? defaultHash.clone() : MessageDigest.getInstance(algorithm).digest(content);
		} catch (final NoSuchAlgorithmException exception) {
			throw new AssertionError(exception);
		}
	}


	/**
	 * Returns the quasi-unique MD5 hash of the given textual context.
	 * @param content the textual content, or {@code null} for none
	 * @return the corresponding MD5 hash code
	 */
	static public byte[] md5HashCode (final String content) {
		return md5HashCode(content == null ? null : content.getBytes(UTF_8));
	}


	/**
	 * Returns the quasi-unique SHA1 hash of the given textual context.
	 * @param content the textual content, or {@code null} for none
	 * @return the corresponding SHA1 hash code
	 */
	static public byte[] sha1HashCode (final String content) {
		return sha1HashCode(content == null ? null : content.getBytes(UTF_8));
	}


	/**
	 * Returns the quasi-unique SHA2 hash of the given textual context.
	 * @param bitLength the hash bit length, either 224, 256, 384 or 512
	 * @param content the textual content, or {@code null} for none
	 * @return the corresponding SHA2 hash code
	 * @throws IllegalArgumentException if the given bit length is neither 224, nor 256, nor 384, nor 512
	 */
	static public byte[] sha2HashCode (final int bitLength, final String content) throws IllegalArgumentException {
		return sha2HashCode(bitLength, content == null ? null : content.getBytes(UTF_8));
	}


	/**
	 * Returns the quasi-unique SHA3 hash of the given textual context.
	 * @param bitLength the hash bit length, either 224, 256, 384 or 512
	 * @param content the textual content, or {@code null} for none
	 * @return the corresponding SHA3 hash code
	 * @throws IllegalArgumentException if the given bit length is neither 224, nor 256, nor 384, nor 512
	 */
	static public byte[] sha3HashCode (final int bitLength, final String content) throws IllegalArgumentException {
		return sha3HashCode(bitLength, content == null ? null : content.getBytes(UTF_8));
	}


	/**
	 * Returns the quasi-unique MD5 hash of the given binary content.
	 * @param content the binary content, or {@code null} for none
	 * @return the hexadecimal text representation of the corresponding MD5 hash code
	 */
	static public String md5HashText (final byte[] content) {
		return String.valueOf(toHexadecimal(md5HashCode(content)));
	}


	/**
	 * Returns the quasi-unique SHA1 hash of the given binary content.
	 * @param content the binary content, or {@code null} for none
	 * @return the hexadecimal text representation of the corresponding SHA1 hash code
	 */
	static public String sha1HashText (final byte[] content) {
		return String.valueOf(toHexadecimal(sha1HashCode(content)));
	}


	/**
	 * Returns the quasi-unique SHA2 hash of the given binary content.
	 * @param bitLength the hash bit length, either 224, 256, 384 or 512
	 * @param content the binary content, or {@code null} for none
	 * @return the hexadecimal text representation of the corresponding SHA2 hash code
	 * @throws IllegalArgumentException if the given bit length is neither 224, nor 256, nor 384, nor 512
	 */
	static public String sha2HashText (final int bitLength, final byte[] content) throws IllegalArgumentException {
		return String.valueOf(toHexadecimal(sha2HashCode(bitLength, content)));
	}


	/**
	 * Returns the quasi-unique SHA3 hash of the given binary content.
	 * @param bitLength the hash bit length, either 224, 256, 384 or 512
	 * @param content the binary content, or {@code null} for none
	 * @return the hexadecimal text representation of the corresponding SHA3 hash code
	 * @throws IllegalArgumentException if the given bit length is neither 224, nor 256, nor 384, nor 512
	 */
	static public String sha3HashText (final int bitLength, final byte[] content) throws IllegalArgumentException {
		return String.valueOf(toHexadecimal(sha3HashCode(bitLength, content)));
	}


	/**
	 * Returns the quasi-unique MD5 hash of the given textual content.
	 * @param content the textual content, or {@code null} for none
	 * @return the hexadecimal text representation of the corresponding MD5 hash code
	 */
	static public String md5HashText (final String content) {
		return md5HashText(content == null ? null : content.getBytes(UTF_8));
	}


	/**
	 * Returns the quasi-unique SHA1 hash of the given textual content.
	 * @param content the textual content, or {@code null} for none
	 * @return the hexadecimal text representation of the corresponding SHA1 hash code
	 */
	static public String sha1HashText (final String content) {
		return sha1HashText(content == null ? null : content.getBytes(UTF_8));
	}


	/**
	 * Returns the quasi-unique SHA2 hash of the given textual content.
	 * @param bitLength the hash bit length, either 224, 256, 384 or 512
	 * @param content the textual content, or {@code null} for none
	 * @return the hexadecimal text representation of the corresponding SHA2 hash code
	 * @throws IllegalArgumentException if the given bit length is neither 224, nor 256, nor 384, nor 512
	 */
	static public String sha2HashText (final int bitLength, final String content) throws IllegalArgumentException {
		return sha2HashText(bitLength, content == null ? null : content.getBytes(UTF_8));
	}


	/**
	 * Returns the quasi-unique SHA3 hash of the given textual content.
	 * @param bitLength the hash bit length, either 224, 256, 384 or 512
	 * @param content the textual content, or {@code null} for none
	 * @return the hexadecimal text representation of the corresponding SHA3 hash code
	 * @throws IllegalArgumentException if the given bit length is neither 224, nor 256, nor 384, nor 512
	 */
	static public String sha3HashText (final int bitLength, final String content) throws IllegalArgumentException {
		return sha3HashText(bitLength, content == null ? null : content.getBytes(UTF_8));
	}


	/**
	 * Prevents external instantiation.
	 */
	private HashCodes () {}
}