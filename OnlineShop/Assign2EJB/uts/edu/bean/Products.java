package uts.edu.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="CATEGORY")
	private String category;

	@Column(name="PCODE")
	private String pcode;

	@Column(name="PDESC")
	private String pdesc;

	@Column(name="PRICE")
	private float price;

    public Products() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPcode() {
		return this.pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPdesc() {
		return this.pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}