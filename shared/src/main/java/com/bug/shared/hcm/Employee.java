package com.bug.shared.hcm;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "HUMAN")
public class Employee {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	// private Employee history;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Employee)) {
			return false;
		}

		Employee e = (Employee) obj;

		if (id == null) {
			return false;
		}

		if (!id.equals(e.id)) {
			return false;
		}

		return true;
	}

	// public Employee getHistory() {
	// return history;
	// }
	//
	// public void setHistory(Employee history) {
	// this.history = history;
	// }

}
