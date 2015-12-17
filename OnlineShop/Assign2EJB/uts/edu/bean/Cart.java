package uts.edu.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class Cart implements Serializable
	{
		private static final long serialVersionUID = 1L;
		// catItem includes number and product object

		private int cart_id;

		private Set<CartItem> cart = new HashSet<CartItem>();

		private float totalPrice;

		public Cart()
			{
			}

		public void setTotalPrice(float totalPrice)
			{
				this.totalPrice = totalPrice;
			}

		public int getCart_id()
			{
				return cart_id;
			}

		public void setCart_id(int cart_id)
			{
				this.cart_id = cart_id;
			}

		public Set<CartItem> getCart()
			{
				return cart;
			}

		public void setTotalPrice()
			{
				float price = 0;
				for (CartItem cartItem : cart)
					{
						price += cartItem.getTotalPrice();
					}
				this.totalPrice = price;

			}

		public void manulTotalPrice(float price)
			{
				this.totalPrice = price;
			}

		public float getTotalPrice()
			{
				return totalPrice;
			}

		public CartItem getCartItem(String id)
			{
				for (CartItem cartItem : cart)
					{
						if ((cartItem.getProduct().getId() + "").equals(id))
							{
								return cartItem;
							}
					}

				return null;
			}

		public void removeCartItem(String id)
			{
				cart.remove(getCartItem(id));
			}

	}
