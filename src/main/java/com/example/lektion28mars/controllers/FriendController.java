package com.example.lektion28mars.controllers;

import com.example.lektion28mars.models.Friend;
import com.example.lektion28mars.repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendRepository friendRepository;


    @RequestMapping("/add")
    public String addNewFriend (@RequestParam String name,
                                @RequestParam String email, @RequestParam String phoneNumber
    ) {
        Friend f = new Friend();
        f.setName(name);
        f.setEmail(email);
        f.setPhoneNumber(phoneNumber);
        friendRepository.save(f);
        System.out.println(f);
        return "Saved";
    }

    @RequestMapping("/all")
    public Iterable<Friend> getAllFriends() {
        return friendRepository.findAll();
    }

    @RequestMapping("/email")
    public Iterable<Friend> getByEmail(@RequestParam String email) {
        System.out.println(email);
        return friendRepository.findByEmail(email);
    }

    @RequestMapping("/name")
    public Iterable<Friend> getByName(@RequestParam String name) {
        System.out.println(name);
        return friendRepository.findByName(name);
    }

    @RequestMapping("/phoneNumber")
    public Iterable<Friend> getByPhoneNumber(@RequestParam String phoneNumber) {
        System.out.println(phoneNumber);
        return friendRepository.findByPhoneNumber(phoneNumber);
    }

    @RequestMapping("/{id}/delete")
    public String deleteFriend(@PathVariable String id) {
        friendRepository.deleteById(Long.parseLong(id));
        return "deleted";
    }

    @RequestMapping("/updatePhone")
    public void updatePhoneNumber(@RequestParam Long id, @RequestParam String phoneNumber) {
        Friend f = friendRepository.findById(id).get();
        f.setPhoneNumber(phoneNumber);

        friendRepository.save(f);
    }


}
