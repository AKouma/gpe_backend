package com.etna.gpe.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "community")
public class Community {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "community_id")
	int communityId;
	
	@Column(name ="community_admin", nullable = false)
	String communityAdmin;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name ="community_create_date")
	Date communityCreateDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name ="community_update_date")
	Date communityUpdateDate;
	
	@Column(name ="community_is_deleted")
	boolean communityIsDeleted;

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	public String getCommunityAdmin() {
		return communityAdmin;
	}

	public void setCommunityAdmin(String communityAdmin) {
		this.communityAdmin = communityAdmin;
	}

	public Date getCommunityCreateDate() {
		return communityCreateDate;
	}

	public void setCommunityCreateDate(Date communityCreateDate) {
		this.communityCreateDate = communityCreateDate;
	}

	public Date getCommunityUpdateDate() {
		return communityUpdateDate;
	}

	public void setCommunityUpdateDate(Date communityUpdateDate) {
		this.communityUpdateDate = communityUpdateDate;
	}

	public boolean isCommunityIsDeleted() {
		return communityIsDeleted;
	}

	public void setCommunityIsDeleted(boolean communityIsDeleted) {
		this.communityIsDeleted = communityIsDeleted;
	}
	
	
}
