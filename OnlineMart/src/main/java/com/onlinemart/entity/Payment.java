package com.onlinemart.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Payment 
{
	@Column(name = "Payment_id")
	@Id
	@GeneratedValue(generator = "Id_generator")
	@GenericGenerator(name = "Id_generator",strategy ="org.hibernate.id.enhanced.SequenceStyleGenerator",
						parameters = {@Parameter(name="sequence_name", value="user_sequence"),
								      @Parameter(name ="initial_value",value="51"),
									  @Parameter(name="increment_size",value = "1")})
	private int payment_id;
	
	@Column(name="order_id",unique=true)
	private  long orderId;
	
	@Column(name = "Total_Price")
	private double totalPrice;
	
	@Column(name="name_on_card")
	@NotEmpty
	@Size(min=3 , message="name must contain atleast 3 characters")
	private String nameOnCard;
	
	@Column(name="card_number")
	@NotEmpty
	@Size(min=16 , max=16,message="cardNumber must contain 16 digits")
	private String cardNumber;
	
	@Column(name="exp_year")
	private String expYear;
	
	@Column(name="cvv")
	@NotNull
	private int cvv;
	
	@Column(name = "paid_date")
	private LocalDate paidDate;
	
	@Column(name = "paid_amount", nullable = false)
	private double paidAmount;
	
	//Getters and Setters
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="user_id",referencedColumnName = "id",nullable = false)
	@JsonIgnore
	private Users user;
	
	//Getters and Setters
	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public LocalDate getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(LocalDate paidDate) {
		this.paidDate = paidDate;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", orderId=" + orderId + ", totalPrice=" + totalPrice
				+ ", nameOnCard=" + nameOnCard + ", cardNumber=" + cardNumber + ", expYear=" + expYear + ", cvv=" + cvv
				+ ", paidDate=" + paidDate + ", paidAmount=" + paidAmount + ", user=" + user + "]";
	}

	public Payment() {
		super();
	}
}
