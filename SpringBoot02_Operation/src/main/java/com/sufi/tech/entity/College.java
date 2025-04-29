package com.sufi.tech.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="college")
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long collegeId;
	
	@JsonProperty
	@Column
	private String collegeName;
	
	@JsonProperty
	@Column
	private String collegeAddress;
	
	@JsonProperty
	@Column
	private String collegeGrade;

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}
	
	
}
