package com.etna.gpe.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.etna.gpe.dto.MessageDto;

@Entity
@Table(name ="message")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id")
	int messageId;
	
	@Column(name = "message_value", length = 1000000)
	String messageValue;
	
	@Column(name = "message_sender")
	String messageSender;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "message_create_date")
	Date messageCreateDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "message_update_date")
	Date messageUpdateDate;
	
	@Column(name = "message_is_deleted")
	boolean messageIsDeleted;
	
	@Column(name = "message_is_sent")
	boolean messageIsSent;
	
	@Column(name = "message_is_received")
	boolean messageIsReceived;
	
	@ManyToOne
	@JoinColumn
	Community community;
	
	public Message() {}
	
	public Message(MessageDto messageDto, Community community) {
		if (community != null)
			this.setCommunity(community);
		this.setMessageCreateDate(messageDto.getMessageCreateDate());
		this.setMessageValue(messageDto.getMessageValue());
		this.setMessageSender(messageDto.getMessageSender());
		this.setMessageUpdateDate(messageDto.getMessageUpdateDate());
		this.setMessageIsDeleted(messageDto.isMessageIsDeleted());
		this.setMessageIsReceived(messageDto.isMessageIsReceived());
		this.setMessageId(messageDto.getMessageId());
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessageValue() {
		return messageValue;
	}

	public void setMessageValue(String messageValue) {
		this.messageValue = messageValue;
	}

	public String getMessageSender() {
		return messageSender;
	}

	public void setMessageSender(String messageSender) {
		this.messageSender = messageSender;
	}

	public Date getMessageCreateDate() {
		return messageCreateDate;
	}

	public void setMessageCreateDate(Date messageCreateDate) {
		this.messageCreateDate = messageCreateDate;
	}

	public Date getMessageUpdateDate() {
		return messageUpdateDate;
	}

	public void setMessageUpdateDate(Date messageUpdateDate) {
		this.messageUpdateDate = messageUpdateDate;
	}

	public boolean isMessageIsDeleted() {
		return messageIsDeleted;
	}

	public void setMessageIsDeleted(boolean messageIsDeleted) {
		this.messageIsDeleted = messageIsDeleted;
	}

	public boolean isMessageIsSent() {
		return messageIsSent;
	}

	public void setMessageIsSent(boolean messageIsSent) {
		this.messageIsSent = messageIsSent;
	}

	public boolean isMessageIsReceived() {
		return messageIsReceived;
	}

	public void setMessageIsReceived(boolean messageIsReceived) {
		this.messageIsReceived = messageIsReceived;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}
}
