package com.etna.gpe.model;

import javax.persistence.*;

@Entity
@Table(name ="message")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "message_id")
	int messageId;
	
	@Column(name = "message_value")
	String messageValue;
	
	@Column(name = "message_sender")
	String messageSender;
	
	@Column(name = "message_receivers")
	String messageReceivers;
	
	@Column(name = "message_create_date")
	String messageCreateDate;
	
	@Column(name = "message_update_date")
	String messageUpdateDate;
	
	@Column(name = "message_delete_date")
	String messageDeleteDate;
	
	@Column(name = "message_is_deleted")
	boolean messageIsDeleted;
	
	@Column(name = "message_is_sent")
	boolean messageIsSent;
	
	@Column(name = "message_is_received")
	boolean messageIsReceived;
	
	@ManyToOne
	@JoinColumn
	Community community;

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

	public String getMessageReceivers() {
		return messageReceivers;
	}

	public void setMessageReceivers(String messageReceivers) {
		this.messageReceivers = messageReceivers;
	}

	public String getMessageCreateDate() {
		return messageCreateDate;
	}

	public void setMessageCreateDate(String messageCreateDate) {
		this.messageCreateDate = messageCreateDate;
	}

	public String getMessageUpdateDate() {
		return messageUpdateDate;
	}

	public void setMessageUpdateDate(String messageUpdateDate) {
		this.messageUpdateDate = messageUpdateDate;
	}

	public String getMessageDeleteDate() {
		return messageDeleteDate;
	}

	public void setMessageDeleteDate(String messageDeleteDate) {
		this.messageDeleteDate = messageDeleteDate;
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
