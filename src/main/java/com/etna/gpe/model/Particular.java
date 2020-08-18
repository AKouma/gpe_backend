package com.etna.gpe.model;

import com.etna.gpe.dto.ParticularDto;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "particular")
public class Particular extends User {

	public static enum PARTICULAR_CATEGORY {
		SIMPLE_USER(1, "utilisateur_simple"), BENEVOL(2, "bénévol");

		private int categoryValue;
		private String categoryName;

		PARTICULAR_CATEGORY(int categoryValue, String categoryName) {
			this.categoryValue = categoryValue;
			this.categoryName = categoryName;
		}

		public int getCategoryValue() {
			return categoryValue;
		}

		public String getCategoryName() {
			return categoryName;
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "particular_id")
	private int particularId;

	@Column(name = "particular_category")
	private String category = PARTICULAR_CATEGORY.SIMPLE_USER.categoryName;

	@Column(name = "particular_name")
	private String particularName;

	@Column(name = "particular_first_name")
	private String particularFirstName;

	@NotBlank
	@Column(name = "particular_password", nullable = false)
	private String particularPassword;

	@Column(name = "particular_phone_number")
	private String particularPhonenumber;

	@Column(name = "particular_location")
	private String particularLocation;

	@Column(name = "particular_email", nullable = false)
	private String particularEmail;
	
	@Column(name = "particular_photo", length = 1000000)
	private String photo;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "particular_create_date")
	private Date particularCreateDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "particular_update_date")
	private Date particularUpdateDate;

	@Column(name = "particular_is_deleted")
	boolean particularIsDeleted = false;

	protected Particular() {
		// empty constructor
	}

	public Particular(@NonNull ParticularDto particularDto, boolean isNew) {
		if (!isNew)
			this.setParticularId(particularDto.getParticularId());
		this.setParticularCreateDate(particularDto.getParticularCreateDate());
		this.setParticularEmail(particularDto.getParticularEmail());
		this.setParticularFirstName(particularDto.getParticularFirstName());
		this.setParticularIsDeleted(particularDto.isParticularIsDeleted());
		this.setParticularName(particularDto.getParticularName());
		this.setParticularPassword(particularDto.getParticularPassword());
		this.setParticularPhonenumber(particularDto.getParticularPhonenumber());
		this.setParticularUpdateDate(particularDto.getParticularUpdateDate());
		this.setParticularLocation(particularDto.getParticularLocation());
		this.setPhoto(particularDto.getPhoto());
		if (particularDto.getCategory() != null)
			this.setCategory(particularDto.getCategory());
	}

	public int getParticularId() {
		return particularId;
	}

	public void setParticularId(int particularId) {
		this.particularId = particularId;
	}

	public String getParticularName() {
		return particularName;
	}

	public void setParticularName(String particularName) {
		this.particularName = particularName;
	}

	public String getParticularFirstName() {
		return particularFirstName;
	}

	public void setParticularFirstName(String particularFirstName) {
		this.particularFirstName = particularFirstName;
	}

	public String getParticularPassword() {
		return particularPassword;
	}

	public void setParticularPassword(String particularPassword) {
		this.particularPassword = particularPassword;
	}

	public String getParticularPhonenumber() {
		return particularPhonenumber;
	}

	public void setParticularPhonenumber(String particularPhonenumber) {
		this.particularPhonenumber = particularPhonenumber;
	}

	public String getParticularLocation() {
		return particularLocation;
	}

	public void setParticularLocation(String particularLocation) {
		this.particularLocation = particularLocation;
	}

	public String getParticularEmail() {
		return particularEmail;
	}

	public void setParticularEmail(String particularEmail) {
		this.particularEmail = particularEmail;
	}

	public Date getParticularCreateDate() {
		return particularCreateDate;
	}

	public void setParticularCreateDate(Date particularCreateDate) {
		this.particularCreateDate = particularCreateDate;
	}

	public Date getParticularUpdateDate() {
		return particularUpdateDate;
	}

	public void setParticularUpdateDate(Date particularUpdateDate) {
		this.particularUpdateDate = particularUpdateDate;
	}

	public boolean isParticularIsDeleted() {
		return particularIsDeleted;
	}

	public void setParticularIsDeleted(boolean particularIsDeleted) {
		this.particularIsDeleted = particularIsDeleted;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
