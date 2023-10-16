package me.szeredniklaszlo.dal.model;

import java.util.Objects;
import java.util.UUID;

import org.hibernate.Hibernate;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
//@Table(name = "sample")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Sample {
	@Id
	@GeneratedValue
	@UuidGenerator
	private UUID id;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
			return false;
		}
		Sample sample = (Sample) o;
		return id != null && Objects.equals(id, sample.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
