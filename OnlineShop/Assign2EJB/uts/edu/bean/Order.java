package uts.edu.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	private static int num;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="CUSTOMER_ID")
	private String customerId;

	@Column(name="CUSTOMER_SURNAME")
	private String customerSurname;

	@Column(name="GRANDTOTAL")
	private float grandtotal;

	@Column(name="ORDER_DATE")
	private Timestamp orderDate;

	@Column(name="ORDER_NUMBER")
	private String orderNumber;

	@Column(name="ORDER_STATUS")
	private String orderStatus;

    public Order() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerSurname() {
		return this.customerSurname;
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public float getGrandtotal() {
		return this.grandtotal;
	}

	public void setGrandtotal(float grandtotal) {
		this.grandtotal = grandtotal;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	

	public static void plusNum()
		{

			Order.num++;
		}
	
	public static void miniseNum()
	{
		Order.num--;
	}

	public static int getNum()
		{
			return num;
		}

	public static void setNum(int num)
		{
			Order.num = num;
		}

}