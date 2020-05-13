package com.projects.address.gateways.mongo;

import com.projects.address.domains.User;

import java.util.List;

public interface UserGateway  {
    User save(User user);
    void delete(User user);
    List<User> findAll();
}
