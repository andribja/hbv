package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Ad;
import project.persistence.entities.User;
import project.persistence.repositories.AdRepository;
import project.service.AdService;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

@Service
public class AdServiceImplementation implements AdService {

    // Instance Variables
    AdRepository repository;

    // Dependency Injection
    @Autowired
    public AdServiceImplementation(AdRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ad save(Ad ad) {
        return repository.save(ad);
    }

    @Override
    public void delete(Ad ad) {
        repository.delete(ad);
    }

    @Override
    public List<Ad> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Ad> findAllReverseOrder() {
        // Get all the Ads
        List<Ad> ads = repository.findAll();

        // Reverse the list
        Collections.reverse(ads);

        return ads;
    }

    @Override
    public Ad findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Ad> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Ad> findByAuthor_id(Long user_id) {
        return repository.findByAuthor_id(user_id);
    }

    @Override
    public List<Ad> findAllUnreviewedBy(Long user_id) {
        System.out.println("watup " + user_id);

        List<BigInteger> foo = repository.findAllUnreviewedIds(user_id);
        System.out.println("Result: " + foo);

        List<Ad> ads = repository.findAll();
        ads.clear();

        for(BigInteger l : foo) {
            ads.add(repository.getOne(l.longValue()));
        }

        return ads;
    }
}
