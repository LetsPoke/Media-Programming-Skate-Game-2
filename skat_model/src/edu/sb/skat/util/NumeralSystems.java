package edu.sb.skat.util;

import static java.lang.Character.digit;
import static java.lang.Character.forDigit;


/**
 * This facade offers byte array conversions to and from positive integers
 * within 2-based (binary), 4-based (quaternary) and 16-based (hexadecimal)
 * numeral systems.
 */
@Copyright(year = 2019, holders = "Sascha Baumeister")
public class NumeralSystems {

	/**
	 * Prevents external instantiation.
	 */
	private NumeralSystems () {}


	/**
	 * Returns the positive binary number equivalent to the given bytes. The
	 * result is guaranteed to have eight times the length of the given byte array.
	 * @param bytes the bytes
	 * @return the positive binary number
	 * @throws NullPointerException if the given argument is {@code null}
	 */
	static public char[] toBinary (final byte... bytes) throws NullPointerException {
		final char[] characters = new char[bytes.length * 8];
		for (int sourceIndex = 0, sinkIndex = 0; sourceIndex < bytes.length; sourceIndex += 1, sinkIndex += 8) {
			final int digits = bytes[sourceIndex] & 0xff;
			characters[sinkIndex + 0] = forDigit((digits >>> 7) & 0x1, 2);
			characters[sinkIndex + 1] = forDigit((digits >>> 6) & 0x1, 2);
			characters[sinkIndex + 2] = forDigit((digits >>> 5) & 0x1, 2);
			characters[sinkIndex + 3] = forDigit((digits >>> 4) & 0x1, 2);
			characters[sinkIndex + 4] = forDigit((digits >>> 3) & 0x1, 2);
			characters[sinkIndex + 5] = forDigit((digits >>> 2) & 0x1, 2);
			characters[sinkIndex + 6] = forDigit((digits >>> 1) & 0x1, 2);
			characters[sinkIndex + 7] = forDigit((digits >>> 0) & 0x1, 2);
		}

		return characters;
	}


	/**
	 * Returns the bytes equivalent to the given positive binary number. The
	 * result is guaranteed to have an eighth the length of the given character
	 * array, which must have octuple length.
	 * @param characters the positive binary number
	 * @return the bytes
	 * @throws NullPointerException if the given argument is {@code null}
	 * @throws IllegalArgumentException if the given characters array length is not
	 *		   an octuple, or if it contains characters that are no binary digits
	 */
	static public byte[] fromBinary (final char... characters) throws NullPointerException, IllegalArgumentException {
		if ((characters.length & 0x7) != 0) throw new IllegalArgumentException();

		final byte[] bytes = new byte[characters.length / 8];
		for (int sourceIndex = 0, sinkIndex = 0; sourceIndex < characters.length; sourceIndex += 8, sinkIndex += 1) {
			final int digits =
				(digit(characters[sourceIndex + 0], 2) << 7) |
				(digit(characters[sourceIndex + 1], 2) << 6) |
				(digit(characters[sourceIndex + 2], 2) << 5) |
				(digit(characters[sourceIndex + 3], 2) << 4) |
				(digit(characters[sourceIndex + 4], 2) << 3) |
				(digit(characters[sourceIndex + 5], 2) << 2) |
				(digit(characters[sourceIndex + 6], 2) << 1) |
				(digit(characters[sourceIndex + 7], 2) << 0);

			if (digits < 0 ) throw new IllegalArgumentException();
			bytes[sinkIndex] = (byte) digits;
		}

		return bytes;
	}


	/**
	 * Returns the positive quaternary number equivalent to the given bytes. The
	 * result is guaranteed to have four times the length of the given byte array.
	 * @param bytes the bytes
	 * @return the positive quaternary number
	 * @throws NullPointerException if the given argument is {@code null}
	 */
	static public char[] toQuaternary (final byte... bytes) throws NullPointerException {
		final char[] characters = new char[bytes.length * 4];
		for (int sourceIndex = 0, sinkIndex = 0; sourceIndex < bytes.length; sourceIndex += 1, sinkIndex += 4) {
			final int digits = bytes[sourceIndex] & 0xff;
			characters[sinkIndex + 0] = forDigit((digits >>> 6) & 0x3, 4);
			characters[sinkIndex + 1] = forDigit((digits >>> 4) & 0x3, 4);
			characters[sinkIndex + 2] = forDigit((digits >>> 2) & 0x3, 4);
			characters[sinkIndex + 3] = forDigit((digits >>> 0) & 0x3, 4);
		}

		return characters;
	}


	/**
	 * Returns the bytes equivalent to the given positive binary number. The
	 * result is guaranteed to have a fourth of the length of the given character
	 * array, which must have quadruple length.
	 * @param characters the positive quaternary number
	 * @return the bytes
	 * @throws NullPointerException if the given argument is {@code null}
	 * @throws IllegalArgumentException if the given characters array length is not
	 *		   a quadruple, or if it contains characters that are no quaternary digits
	 */
	static public byte[] fromQuaternary (final char... characters) throws NullPointerException, IllegalArgumentException {
		if ((characters.length & 0x3) != 0) throw new IllegalArgumentException();

		final byte[] bytes = new byte[characters.length / 4];
		for (int sourceIndex = 0, sinkIndex = 0; sourceIndex < characters.length; sourceIndex += 4, sinkIndex += 1) {
			final int digits =
				(digit(characters[sourceIndex + 0], 4) << 6) |
				(digit(characters[sourceIndex + 1], 4) << 4) |
				(digit(characters[sourceIndex + 2], 4) << 2) |
				(digit(characters[sourceIndex + 3], 4) << 0);

			if (digits < 0 ) throw new IllegalArgumentException();
			bytes[sinkIndex] = (byte) digits;
		}

		return bytes;
	}


	/**
	 * Returns the positive hexadecimal number equivalent to the given bytes. The
	 * result is guaranteed to have double the length of the given byte array.
	 * @param bytes the bytes
	 * @return the positive hexadecimal number
	 * @throws NullPointerException if the given argument is {@code null}
	 */
	static public char[] toHexadecimal (final byte... bytes) throws NullPointerException {
		final char[] characters = new char[bytes.length * 2];
		for (int sourceIndex = 0, sinkIndex = 0; sourceIndex < bytes.length; sourceIndex += 1, sinkIndex += 2) {
			final int digits = bytes[sourceIndex] & 0xff;
			characters[sinkIndex + 0] = forDigit((digits >>> 4) & 0xf, 16);
			characters[sinkIndex + 1] = forDigit((digits >>> 0) & 0xf, 16);
		}

		return characters;
	}


	/**
	 * Returns the bytes equivalent to the given positive hexadecimal number. The
	 * result is guaranteed to have half the length of the given character array,
	 * which must have an even length.
	 * @param characters the positive hexadecimal number
	 * @return the bytes
	 * @throws NullPointerException if the given argument is {@code null}
	 * @throws IllegalArgumentException if the given characters array length is not even,
	 *		   or if it contains characters that are no hexadecimal digits
	 */
	static public byte[] fromHexadecimal (final char... characters) throws NullPointerException, IllegalArgumentException {
		if ((characters.length & 0x1) != 0) throw new IllegalArgumentException();

		final byte[] bytes = new byte[characters.length / 2];
		for (int sourceIndex = 0, sinkIndex = 0; sourceIndex < characters.length; sourceIndex += 2, sinkIndex += 1) {
			final int digits =
				(digit(characters[sourceIndex + 0], 16) << 4) |
				(digit(characters[sourceIndex + 1], 16) << 0);
			if (digits < 0) throw new IllegalArgumentException();
			bytes[sinkIndex] = (byte) digits;
		}

		return bytes;
	}
}