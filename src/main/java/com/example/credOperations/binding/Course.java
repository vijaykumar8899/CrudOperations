
package com.example.credOperations.binding;

import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data // to generate getters and setters using Lombok_annotaion
@Entity // to represent this class as entity we use Entity
@Table(name = "COURSE_DTLS") // if we don't specify table annotation it updates table name as class name
public class Course {

	@Id // id represents that this column is a primary key mapped column, this var_ible
		// is mapped with primary_key column
	@GeneratedValue(strategy = GenerationType.IDENTITY) // we use this to generate a value for this column
														// automatically.
	

	private Integer cid;
	
	private String fname;
    private String lname;
    private String mname;
	
	private Double price;
	

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@OneToMany
	private List<Laptop> laptop = new ArrayList<>();
	 
	 

	
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	 
	
	
}
