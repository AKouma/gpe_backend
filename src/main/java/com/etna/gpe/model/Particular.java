package com.etna.gpe.model;

import com.etna.gpe.dto.ParticularDto;
import org.springframework.lang.NonNull;

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

	@NotBlank
    @Column(name = "particular_email", nullable = false)
    String particularEmail;

    @Column(name = "particular_create_date")
    String particularCreateDate;

    @Column(name = "particular_update_date")
    String particularUpdateDate;

    @Column(name = "particular_delete_date")
    String particularDeleteDate;

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

    public String getParticularEmail() {
        return particularEmail;
    }

    public void setParticularEmail(String particularEmail) {
        this.particularEmail = particularEmail;
    }

    public String getParticularCreateDate() {
        return particularCreateDate;
    }

    public void setParticularCreateDate(String particularCreateDate) {
        this.particularCreateDate = particularCreateDate;
    }

    public String getParticularUpdateDate() {
        return particularUpdateDate;
    }

    public void setParticularUpdateDate(String particularUpdateDate) {
        this.particularUpdateDate = particularUpdateDate;
    }

    public String getParticularDeleteDate() {
        return particularDeleteDate;
    }

    public void setParticularDeleteDate(String particularDeleteDate) {
        this.particularDeleteDate = particularDeleteDate;
    }

    public boolean isParticularIsDeleted() {
        return particularIsDeleted;
    }

    public void setParticularIsDeleted(boolean particularIsDeleted) {
        this.particularIsDeleted = particularIsDeleted;
    }


}
