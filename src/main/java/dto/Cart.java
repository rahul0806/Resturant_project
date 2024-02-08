package dto;



import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Cart {
	

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		int id;
		@OneToMany
		List<customer_food_item> fooditems;
		
	
}
