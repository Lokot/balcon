package ru.skysoftlab.balcon.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

@Entity(name = "person")
// @Table(name = "person", schema = "public")
@SequenceGenerator(name = "seq_id", sequenceName = "seq_id_person", allocationSize = 1, initialValue = 1)
// schema = "public",
@Inheritance(strategy = InheritanceType.JOINED)
@DynamicUpdate
public class Person implements Serializable {

	private static final long serialVersionUID = 7241121612521617056L;

	private Integer id;

	private UUID globalIdentifier;

	private String firstName;

	private String lastName;

	private String middleName;

	private Date version;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// @Type(type = "pg-uuid")
	// , columnDefinition = "uuid DEFAULT uuid_in(md5(now()::text)::cstring)"
	@Column(name = "global_identifier", insertable = false)
	public UUID getGlobalIdentifier() {
		return globalIdentifier;
	}

	public void setGlobalIdentifier(UUID globalIdentifier) {
		this.globalIdentifier = globalIdentifier;
	}

	@NotNull
	@Column(name = "first_name", nullable = false, length = 64)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@NotNull
	@Column(name = "last_name", nullable = false, length = 64)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "middle_name", nullable = true, length = 64)
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Override
	public boolean equals(Object value) {
		if (!(value instanceof Person)) {
			return false;
		}
		if (value == this) {
			return true;
		}
		Person obj = (Person) value;
		if (!obj.getGlobalIdentifier().equals(getGlobalIdentifier())) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = 29;
		result += 29 * (getGlobalIdentifier() != null ? getGlobalIdentifier()
				.hashCode() : 0);
		return result;
	}

	@Column(name = "version", updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@Version
	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
