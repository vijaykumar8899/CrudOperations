
package com.example.credOperations.binding;

import jakarta.persistence.Entity;
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
	private String name;
	private Double price;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
