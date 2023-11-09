package skat_model;

public interface Comparable<BaseEntity> extends java.lang.Comparable<BaseEntity> {
    @Override
	int compareTo(BaseEntity other);
}

