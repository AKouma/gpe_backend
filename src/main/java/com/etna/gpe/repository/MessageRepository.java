package com.etna.gpe.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.etna.gpe.model.Message;

public interface MessageRepository extends CrudRepository<Message, Integer>{
	
    @Query("select m from Message m where m.community.communityId =:id and m.messageIsReceived =:1")
    public List<Message> findMessageByCommunityCommunityId(int id);

}
