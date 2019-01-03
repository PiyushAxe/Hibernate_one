import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class SimpleClass implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	
	private String model;
	private String price;
	private String color;
	@Id
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	
}