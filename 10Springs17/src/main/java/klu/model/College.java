package klu.model;

public class College {

	String name;
	String acronym;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	@Override
	public String toString() {
		return "College [name=" + name + ", acronym=" + acronym + "]";
	}
	
}
