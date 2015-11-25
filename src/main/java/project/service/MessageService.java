package project.service;

import project.persistence.entities.Message;
import project.persistence.entities.User;

import java.util.List;

public interface MessageService {

    Message save(Message message);

    void delete(Message message);

    List<Message> findAll();

    List<Message> findAllReverseOrder();

    Message findOne(Long id);

    List<Message> findBySender(String sender);

    List<Message> findByReceiverId(Long receiverId);

    void send(Message message);

    List<User> findAllInterested(Long adId);

    User findOriginalMessageUser(Long adId);

    List<Message> getUnreadMessages(Long userId);

}
