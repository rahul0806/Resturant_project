package dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

public class customer_food_item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY	)
	private int id;
	private String name;
	private double price;
	private  int quantity;
	private String type;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private byte[] picture;

}
