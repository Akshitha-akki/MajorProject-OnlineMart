package com.onlinemart.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@Entity
public class Orders 
{
	@Column(name = "Order_id")
	@Id
	@GeneratedValue(generator = "Id_generator")
	@GenericGenerator(name = "Id_generator",strategy ="org.hibernate.id.enhanced.SequenceStyleGenerator",
						parameters = {@Parameter(name="sequence_name", value="user_sequence"),
								      @Parameter(name ="initial_value",value="51"),
									  @Parameter(name="increment_size",value = "1")})
    private int orderid;
	
	@Column(name = "MRP_Price")
	private int mrpPrice;
	
	@Column(name = "Quantity",length = 20)
	private long quantity;
	
	@Column(name = "Total_Price")
	private double totalPrice;
	
	@Column(name = "Order_Status",length = 30)
	private String orderStatus;
	
	@Column(name = "Payment_Status",length = 30)
	private String paymentStatus;
	
	@Column(name = "Ordered_Date")
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date ordered_Date;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id",referencedColumnName = "id",nullable = false)
	private Users user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id",referencedColumnName = "cart_id",nullable = false)
	private Cart cart;
	
	//Getters and Setters
	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public int getMrpPrice() {
		return mrpPrice;
	}

	public void setMrpPrice(int mrpPrice) {
		this.mrpPrice = mrpPrice;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long l) {
		this.totalPrice = l;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	
	public Date getOrdered_Date() {
		return ordered_Date;
	}

	public void setOrdered_Date(Date ordered_Date) {
		ordered_Date = ordered_Date;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", mrpPrice=" + mrpPrice + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + ", orderStatus=" + orderStatus + ", paymentStatus=" + paymentStatus + ", Ordered_Date="
				+ ordered_Date + ", user=" + user + ", cart=" + cart + "]";
	}

	public Orders() {
		super();
	}
}
