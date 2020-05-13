package com.projects.address.services;

import com.projects.address.domains.User;
import com.projects.address.gateways.mongo.UserGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserGateway userGateway;

  public void save(User user) {
    userGateway.save(user);
  }

  public void delete(User user) {
    userGateway.delete(user);
  }

  public List<User> listAllUsers(){
    return userGateway.findAll();
  }
}
