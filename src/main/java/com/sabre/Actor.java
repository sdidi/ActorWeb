package com.sabre;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Actor {
	@Id
	int id;
	String nickname;
	String name;

	public Actor() {
	}

	public Actor(int id, String nickname, String name) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", nickname=" + nickname + ", name=" + name + "]";
	}

}
