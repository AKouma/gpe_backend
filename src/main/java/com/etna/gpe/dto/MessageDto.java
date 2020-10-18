package com.etna.gpe.dto;

import java.util.Date;

import com.etna.gpe.model.Message;

public class MessageDto {

	private int messageId;
	
	private String messageValue;
	
	private String messageSender;
	
	private Date messageCreateDate;
	
	private Date messageUpdateDate;
	
	private boolean messageIsDeleted;
	
	private boolean messageIsSent;
	
	private boolean messageIsReceived;
	
	private int communityId;
	
	public MessageDto() {}
	
	public MessageDto(Message message) {
		if (message != null) {
			if (message.getCommunity() != null)
				this.setCommunityId(message.getCommunity().getCommunityId());
			this.setMessageCreateDate(message.getMessageCreateDate());
			this.setMessageValue(message.getMessageValue());
			this.setMessageSender(message.getMessageSender());
			this.setMessageUpdateDate(message.getMessageUpdateDate());
			this.setMessageIsDeleted(message.isMessageIsDeleted());
			this.setMessageIsReceived(message.isMessageIsReceived());
			this.setMessageId(message.getMessageId());
		}
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

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
}
