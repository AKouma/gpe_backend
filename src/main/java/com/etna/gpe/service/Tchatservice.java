package com.etna.gpe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etna.gpe.controller.customexception.ParametersNotFound;
import com.etna.gpe.controller.customexception.ResourceNotExist;
import com.etna.gpe.dto.MessageDto;
import com.etna.gpe.model.Community;
import com.etna.gpe.model.Message;
import com.etna.gpe.repository.CommunityRepository;
import com.etna.gpe.repository.MessageRepository;

@Service
public class Tchatservice {

	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	CommunityRepository communityRepository;
	
	
	public List<MessageDto> addMessage(MessageDto messageDto) {
		List<MessageDto> dto = new ArrayList<MessageDto>();
		if(messageDto.getCommunityId() < 0 || messageDto.getMessageSender() == null
				|| messageDto.getMessageSender().isBlank() || messageDto.getMessageValue().isBlank())
			throw new ParametersNotFound();
		//check if commuty exists
		Community community = communityRepository.findById(messageDto.getCommunityId()).get();
			if(community == null)
				throw new ResourceNotExist();
			//save the message
			Message message = new Message(messageDto, community);
			messageRepository.save(message);
			
			List<Message> messages = messageRepository.findMessageByCommunityCommunityId(community.getCommunityId());
					
			for(Message m : messages) {
				
				MessageDto mDto = new MessageDto(m);
				dto.add(mDto);
			}
			
		return dto;
	}
	
	public List<MessageDto> allMessage(int communityId) {
		List<MessageDto> dto = new ArrayList<MessageDto>();
			
			List<Message> messages = messageRepository.findMessageByCommunityCommunityId(communityId);
					
			for(Message m : messages) {
				
				MessageDto mDto = new MessageDto(m);
				dto.add(mDto);
			}
			
		return dto;
	}
}
