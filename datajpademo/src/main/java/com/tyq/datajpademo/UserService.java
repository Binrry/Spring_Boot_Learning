package com.tyq.datajpademo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface UserService {
    User findById(String id);
    List<User> findAll();
    User save(User user);
    void delete(String id);
    Page<User> findAll(Pageable pageable);
    List<User> findByName(String name);
    List<User> findByNameLike(String name);
    List<User> findByIdIn(Collection<String> ids);
}
