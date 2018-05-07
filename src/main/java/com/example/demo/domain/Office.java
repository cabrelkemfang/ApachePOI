package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="m_office")
public class Office implements Serializable {
	  

	    @Id
	     @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.AUTO)
	     private Integer id;
	     @Column(name = "parent_id")
	     private String parentId;
	     @Column(name = "hierarchy")
	     private String hierarchy;
	     @Column(name = "external_id")
	     private String externalId;
	     @Column(name = "name")
	     private String name;
	     @Column(name = "opening_date")
	     private Date openingDate;
		public Integer getId() {
			return id;
		}
		public String getParentId() {
			return parentId;
		}
		public String getHierarchy() {
			return hierarchy;
		}
		public String getExternalId() {
			return externalId;
		}
		public String getName() {
			return name;
		}
		public Date getOpeningDate() {
			return openingDate;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public void setParentId(String parentId) {
			this.parentId = parentId;
		}
		public void setHierarchy(String hierarchy) {
			this.hierarchy = hierarchy;
		}
		public void setExternalId(String externalId) {
			this.externalId = externalId;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setOpeningDate(Date openingDate) {
			this.openingDate = openingDate;
		}
		public Office(String parentId, String hierarchy, String externalId, String name, Date openingDate) {
			super();
			this.parentId = parentId;
			this.hierarchy = hierarchy;
			this.externalId = externalId;
			this.name = name;
			this.openingDate = openingDate;
		}
		public Office() {
			super();
		}
	     
	     
		
	     
	     
}