package uts.edu.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private String id;

	@Column(name="ADDRESS")
	private String address;

	@Column(name="COUNTRY")
	private String country;

	@Column(name="EMAIL")
	private String email;

	@Column(name="GIVENNAME")
	private String givenname;

	@Column(name="PAYMENT")
	private int payment;

	@Column(name="POSTCODE")
	private String postcode;

	@Column(name="SURNAME")
	private String surname;

    public Customer() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGivenname() {
		return this.givenname;
	}

	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}

	public int getPayment() {
		return this.payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}