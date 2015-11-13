package project.service;

import project.persistence.entities.Message;

import java.util.List;

public interface MessageService {

    Message save(Message message);

    void delete(Message message);

    List<Message> findAll();

    List<Message> findAllReverseOrder();

    Message findOne(Long id);

    List<Message> findBySender(String sender);

    List<Message> findByReceiver(String receiver);

}