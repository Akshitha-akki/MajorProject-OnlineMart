package com.onlinemart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Cart 
{
	@Column(name = "cart_id")
	@Id
	@GeneratedValue(generator = "Id_generator")
	@GenericGenerator(name = "Id_generator",strategy ="org.hibernate.id.enhanced.SequenceStyleGenerator",
						parameters = {@Parameter(name="sequence_name", value="user_sequence"),
								      @Parameter(name ="initial_value",value="501"),
									  @Parameter(name="increment_size",value = "1")})
	private int cart_id;
	
	@Column(name = "quantity")
	private long quantity;
	
	@Column(name = "Price")
	private int Price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Product_id",referencedColumnName = "product_id")
	private Product product;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id",referencedColumnName = "id",nullable = false)
	private Users user;
	
	//Getters and Setters
	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", quantity=" + quantity + ", Price=" + Price + ", product=" + product
				+ ", user=" + user + "]";
	}

	public Cart(int cart_id, long quantity, int price, Product product, Users user) {
		super();
		this.cart_id = cart_id;
		this.quantity = quantity;
		Price = price;
		this.product = product;
		this.user = user;
	}

	public Cart() {
		super();
	}
}
