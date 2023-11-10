package edu.sb.skat.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.persistence.annotations.CacheIndex;

import edu.sb.skat.util.HashCodes;

@Entity
@Table(schema = "skat", name = "Document")
public class Document extends BaseEntity {

	static private final byte[] EMPTY_BYTES = {};

	@NotNull
	@Column(name = "content", nullable = false, updatable = false, insertable = true)
	private byte[] content;

	@NotNull
	@Size(min = 64, max = 64)
	@Column(name = "hash", nullable = false, updatable = false, insertable = true, unique = true)
	@CacheIndex(updateable = false)
	private String hash;

	@NotNull
	@Size(min = 1, max = 63)
	@Column(name = "type", nullable = false)
	private String type;

	protected Document() {
		this(EMPTY_BYTES);
	}

	public Document(byte[] content) {
		this.content = content;
		this.type = "application/octet-stream";
		this.hash = HashCodes.sha2HashText(256, content);
	}

	public byte[] getContent() {
		return content;
	}

	protected void setContent(byte[] content) {
		this.content = content;
	}

	public String getHash() {
		return hash;
	}

	protected void setHash(String hash) {
		this.hash = hash;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
