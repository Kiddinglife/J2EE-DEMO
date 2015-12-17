package uts.edu.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the order_details database table.
 * 
 */
@Entity
@Table(name="order_details")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="ORDER_ID")
	private String orderId;

	@Column(name="PRODUCT_ID")
	private int productId;

	@Column(name="QUANTITY")
	private int quantity;

	@Column(name="SUBTOTAL")
	private float subtotal;

	@Column(name="UNIT_PRICE")
	private float unitPrice;

    public OrderDetail() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public float getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

}