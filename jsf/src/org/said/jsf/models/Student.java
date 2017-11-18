package org.said.jsf.models;

import java.util.List;
import java.util.Vector;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private String favLang;
	private String[] loisir;
	
	private List<String> countryList;
	
	public Student() {
		countryList = new Vector<>();
		countryList.add("Morocco");
		countryList.add("Brazil");
		countryList.add("India");
		countryList.add("United States");
		countryList.add("Emirates");
	}
	
	public List<String> getCountryList() {
		return countryList;
	}
	
	

	public String[] getLoisir() {
		return loisir;
	}

	public void setLoisir(String[] loisir) {
		this.loisir = loisir;
	}

	public String getFavLang() {
		return favLang;
	}

	public void setFavLang(String favLang) {
		this.favLang = favLang;
	}

	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
