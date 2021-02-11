package com.johndang.relationships.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licenses")
public class License {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  
	    private String number;
	    
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date expirationDate;
	    
	    @Size(min=2)
	    private String state;
	    
	   
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    @OneToOne(fetch=FetchType.LAZY)
	    @JoinColumn(name="person_id")
	    private Person person;
	    
	    
	    public License() {
	        super();
	    }
	    
	    public License(String number, Date expirationDate, String state) {
	        this.number = number;
	        this.expirationDate = expirationDate;
	        this.state = state;
	    }
	    
	    public License(Date expirationDate, String state, Person person) {
			this.expirationDate = expirationDate;
			this.state = state;
			this.person = person;
		}
		
		public License(String number, Date expirationDate, String state, Person person) {
			this.number = number;
			this.expirationDate = expirationDate;
			this.state = state;
			this.person = person;
		}
	    
	    @PrePersist
		public void createdAt() {
			this.createdAt = new Date();
		}
		
		@PreUpdate
		public void updatedAt() {
			this.updatedAt = new Date();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public Date getExpirationDate() {
			return expirationDate;
		}

		public void setExpirationDate(Date expirationDate) {
			this.expirationDate = expirationDate;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public Person getPerson() {
			return person;
		}

		public void setPerson(Person person) {
			this.person = person;
		}
		
		

}
