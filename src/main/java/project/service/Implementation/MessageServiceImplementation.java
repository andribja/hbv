package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Message;
import project.persistence.entities.User;
import project.persistence.repositories.MessageRepository;
import project.service.MessageService;
import project.service.MessageService;

import java.util.Collections;
import java.util.List;

@Service
public class MessageServiceImplementation implements MessageService {

    // Instance Variables
    MessageRepository repository;

    // Dependency Injection
    @Autowired
    public MessageServiceImplementation(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Message save(Message message) {
        return repository.save(message);
    }

    @Override
    public void delete(Message message) {
        repository.delete(message);
    }

    @Override
    public List<Message> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Message> findAllReverseOrder() {
        // Get all the Messages
        List<Message> messages = repository.findAll();

        // Reverse the list
        Collections.reverse(messages);

        return messages;
    }

    @Override
    public Message findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Message> findBySender(String sender) {
        return repository.findBySender(sender);
    }

    @Override
    public List<Message> findByReceiverId(Long receiverId) {
        List<Message> messages = repository.findByReceiverId(receiverId);
        Collections.reverse(messages);
    	return messages;
    }

    @Override
    public void send(Message message) {

    }

    @Override
    public List<User> findAllInterested(Long adId) {
        return repository.findAllInterested(adId);
    }
}

