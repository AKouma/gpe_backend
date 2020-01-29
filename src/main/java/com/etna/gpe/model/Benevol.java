package com.etna.gpe.model;

import javax.persistence.*;

@Entity
@Table(name = "benevol")
public class Benevol {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "benevol_id")
	int benevolId;
	
	@Column(name = "benevol_is_deleted")
	boolean benevolIsDeleted;
	
	@Column(name = "benevol_interest_date")
	String benevolInterestDate;
	
	@Column(name = "benevol_delete_date")
	String benevolDeleteDate;
	
	@ManyToOne
	@JoinColumn
	Organization organization;
	
	@ManyToOne
	@JoinColumn
	Particular particular;

	public int getBenevolId() {
		return benevolId;
	}

	public void setBenevolId(int benevolId) {
		this.benevolId = benevolId;
	}

	public boolean isBenevolIsDeleted() {
		return benevolIsDeleted;
	}

	public void setBenevolIsDeleted(boolean benevolIsDeleted) {
		this.benevolIsDeleted = benevolIsDeleted;
	}

	public String getBenevolInterestDate() {
		return benevolInterestDate;
	}

	public void setBenevolInterestDate(String benevolInterestDate) {
		this.benevolInterestDate = benevolInterestDate;
	}

	public String getBenevolDeleteDate() {
		return benevolDeleteDate;
	}

	public void setBenevolDeleteDate(String benevolDeleteDate) {
		this.benevolDeleteDate = benevolDeleteDate;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Particular getParticular() {
		return particular;
	}

	public void setParticular(Particular particular) {
		this.particular = particular;
	}
}
