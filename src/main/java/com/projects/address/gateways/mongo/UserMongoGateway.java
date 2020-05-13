package com.projects.address.gateways.mongo;

import com.projects.address.domains.User;
import com.projects.address.gateways.mongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMongoGateway implements UserGateway {

  private final UserRepository userRepository;

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public void delete(User user) {
     userRepository.delete(user);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }
}
