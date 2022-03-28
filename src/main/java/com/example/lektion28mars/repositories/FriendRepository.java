package com.example.lektion28mars.repositories;

import com.example.lektion28mars.models.Friend;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendRepository extends CrudRepository<Friend, Long> {



    List<Friend> findByName(String name);
    List<Friend> findByEmail(String email);
    List<Friend> findByPhoneNumber(String phoneNumber);
}
