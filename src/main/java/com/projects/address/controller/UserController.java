package com.projects.address.controller;

import com.projects.address.domains.User;
import com.projects.address.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/v1/user")
@RestController
public class UserController {

  private final UserService userService;

  @RequestMapping(value = "/new-user", method = RequestMethod.POST)
  public ResponseEntity saveUser(@RequestBody User user) {
    userService.save(user);

    return new ResponseEntity(HttpStatus.OK);
  }

  @RequestMapping(value = "/list-user", method = RequestMethod.GET)
  public ResponseEntity listUser() {
    List<User> users = userService.listAllUsers();
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(users);

  }

  @RequestMapping(value = "/delete-user", method = RequestMethod.POST)
  public ResponseEntity deleteUser(@RequestBody User user) {
    userService.delete(user);
    return new ResponseEntity((HttpStatus.OK));
  }
}
