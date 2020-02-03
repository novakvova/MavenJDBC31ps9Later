package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblBottles")
public class Bottle implements Serializable {
     
    private static final long serialVersionUID = 1L;
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 255)
    private String name;
    @Column(precision=10, scale=2)
	private double price;
     
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
    public String getName() {
        return name;
    }
    public void setName(String model) {
        this.name = model;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
