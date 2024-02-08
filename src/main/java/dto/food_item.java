package dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data 
public class food_item {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY	)
private int id;
private String name;
private double price;
private  int stock;
private String type;
@Lob
@Column(columnDefinition = "MEDIUMBLOB")
private byte[] picture;



}