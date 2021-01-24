package com.tow.core;

import java.util.Date;

// https://stackoverflow.com/questions/1727603/places-where-javabeans-are-used

public class BeansInJava {

//	public List<User> userReturn() {
//
//		// resultSet is the result of a database query of user rows.
//		// Now lets create a list of user objects from these rows
//		List<User> users = new ArrayList<User>();
//		while (resultSet.next()) {
//			User user = new User();
//			user.setId(resultSet.getLong("id"));
//			user.setName(resultSet.getString("name"));
//			user.setBirthdate(resultSet.getDate("birthdate"));
//			users.add(user);
//		}
//		return users;
//	}

}

class User implements java.io.Serializable {

	// Properties.
	private Long id;
	private String name;
	private Date birthdate;

	// Getters.
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	// Setters.
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	// Important java.lang.Object overrides.
	@Override
	public boolean equals(Object other) {
		return (other instanceof User) && (id != null) ? id.equals(((User) other).id) : (other == this);
	}

	@Override
	public int hashCode() {
		return (id != null) ? (getClass().hashCode() + id.hashCode()) : super.hashCode();
	}

	@Override
	public String toString() {
		return String.format("User[id=%d,name=%s,birthdate=%d]", id, name, birthdate);
	}
}