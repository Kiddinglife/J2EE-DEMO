package uts.edu.bean;

import java.io.Serializable;

import javax.persistence.*;

public class CartItem implements Serializable
	{
		/**
	 * 
	 */

		private static final long serialVersionUID = 1L;

		private int cartItem_id;

		private Products product;

		private int quantity;

		private float totalPrice;

		public Products getProduct()
			{
				return product;
			}

		public void setProduct(Products product)
			{
				this.product = product;
			}

		public int getQuantity()
			{
				return quantity;
			}

		public void setQuantity(int num)
			{
				this.quantity = num;
				float n1 = product.getPrice();
				int n2 = quantity;
				float total = n1 * n2;
				setTotalPrice(total);
			}

		public float getTotalPrice()
			{
				return totalPrice;
			}

		public void setTotalPrice(float totalPrice)
			{
				this.totalPrice = totalPrice;
			}

		public int getCartItem_id()
			{
				return cartItem_id;
			}

		public void setCartItem_id(int cartItem_id)
			{
				this.cartItem_id = cartItem_id;
			}

	}
