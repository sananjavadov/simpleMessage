package az.senan.simpleMessage.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import az.senan.simpleMessage.Repository.MessageRepository;
import az.senan.simpleMessage.entity.Message;

@Service
@Transactional
public class MessageService {

	@Autowired
	MessageRepository messageRepository;
	
	public void saveMessage(Message message) {
		messageRepository.save(message);
	}
	
	public List<Message> getMessages(int sender,int receiver){
		return messageRepository.getMessages(sender, receiver);
	}
}
