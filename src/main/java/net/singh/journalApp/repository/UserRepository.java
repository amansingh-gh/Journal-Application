package net.singh.journalApp.repository;

import net.singh.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    // Find username by using mongo-repo
    User findByUsername(String username);

    // Find and delete particular username
    void deleteByUsername(String username);
}
