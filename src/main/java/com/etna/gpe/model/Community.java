package com.etna.gpe.model;

import javax.persistence.*;

@Entity
@Table(name = "community")
public class Community {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "community_id")
	int communityId;
	
	@Column(name ="community_admin", nullable = false)
	String communityAdmin;
	
	@Column(name ="community_create_date")
	String communityCreateDate;
	
	@Column(name ="community_update_date")
	String communityUpdateDate;
	
	@Column(name ="community_delete_date")
	String communityDeleteDate;
	
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

	public String getCommunityCreateDate() {
		return communityCreateDate;
	}

	public void setCommunityCreateDate(String communityCreateDate) {
		this.communityCreateDate = communityCreateDate;
	}

	public String getCommunityUpdateDate() {
		return communityUpdateDate;
	}

	public void setCommunityUpdateDate(String communityUpdateDate) {
		this.communityUpdateDate = communityUpdateDate;
	}

	public String getCommunityDeleteDate() {
		return communityDeleteDate;
	}

	public void setCommunityDeleteDate(String communityDeleteDate) {
		this.communityDeleteDate = communityDeleteDate;
	}

	public boolean isCommunityIsDeleted() {
		return communityIsDeleted;
	}

	public void setCommunityIsDeleted(boolean communityIsDeleted) {
		this.communityIsDeleted = communityIsDeleted;
	}
	
	
}
