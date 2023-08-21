package dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data //generates getters and setters internally
public class Customer {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY	)
private int id;
private String fullname;
 private String email;
 private Long number;
 private String password;
 private LocalDate dob;
 @Lob
@Column(columnDefinition = "LONGBLOB")
 private byte[] picture;
 private int age;
 
 
}
