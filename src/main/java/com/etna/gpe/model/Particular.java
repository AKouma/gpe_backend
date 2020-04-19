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
public class Particular {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "particular_id")
    int particularId;

    @Column(name = "particular_name")
    String particularName;

    @Column(name = "particular_first_name")
    String particularFirstName;

    @NotBlank
    @Column(name = "particular_password", nullable = false)
    String particularPassword;

    @Column(name = "particular_phone_number")
    String particularPhonenumber;
    
    @Column(name = "particular_location")
    String particularLocation;

	@NotBlank
    @Column(name = "particular_email", nullable = false)
    String particularEmail;

	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "particular_create_date")
    private Date particularCreateDate;

	@UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "particular_update_date")
    private Date particularUpdateDate;

	@UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "particular_delete_date")
    Date particularDeleteDate;

    @Column(name = "particular_is_deleted")
    boolean particularIsDeleted = false;


    protected Particular() {
        //empty constructor
    }

    public Particular(@NonNull ParticularDto particularDto, boolean isNew) {
        if (!isNew)
            this.setParticularId(particularDto.getParticularId());
        this.setParticularCreateDate(particularDto.getParticularCreateDate());
        this.setParticularDeleteDate(particularDto.getParticularDeleteDate());
        this.setParticularEmail(particularDto.getParticularEmail());
        this.setParticularFirstName(particularDto.getParticularFirstName());
        this.setParticularIsDeleted(particularDto.isParticularIsDeleted());
        this.setParticularName(particularDto.getParticularName());
        this.setParticularPassword(particularDto.getParticularPassword());
        this.setParticularPhonenumber(particularDto.getParticularPhonenumber());
        this.setParticularUpdateDate(particularDto.getParticularUpdateDate());
        this.setParticularLocation(particularDto.getParticularLocation());
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

	public Date getParticularDeleteDate() {
		return particularDeleteDate;
	}

	public void setParticularDeleteDate(Date particularDeleteDate) {
		this.particularDeleteDate = particularDeleteDate;
	}

	public boolean isParticularIsDeleted() {
		return particularIsDeleted;
	}

	public void setParticularIsDeleted(boolean particularIsDeleted) {
		this.particularIsDeleted = particularIsDeleted;
	}

}
