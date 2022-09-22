package com.onlinemart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Product 
{
	@Column(name = "Product_id")
	@Id
	@GeneratedValue(generator = "Id_generator")
	@GenericGenerator(name = "Id_generator",strategy ="org.hibernate.id.enhanced.SequenceStyleGenerator",
						parameters = {@Parameter(name="sequence_name", value="user_sequence"),
								      @Parameter(name ="initial_value",value="101"),
									  @Parameter(name="increment_size",value = "1")})
	private int product_id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Category")
	private EnumProduct category;
	
	@Column(name = "Product_name")
	@Size(max = 20)
	private String product_name;
	
	@Column(name = "Product_description")
	private String description;
	
	@Column(name = "Price")
	private int price;
	
	@Column(name = "Quantity")
	private long quantity;
	
	
	//Getters and Setters
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public EnumProduct getCategory() {
		return category;
	}

	public void setCategory(EnumProduct category) {
		this.category = category;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", category=" + category + ", product_name=" + product_name
				+ ", description=" + description + ", price=" + price + ", quantity=" + quantity + "]";
	}
}
