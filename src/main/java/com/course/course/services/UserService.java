package com.course.course.services;

import com.course.course.entities.User;
import com.course.course.repositories.UserRepository;
import com.course.course.resources.exceptions.ResourceExceptionHandler;
import com.course.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User obj) {
        User entity = repository.getReferenceById(id);
        updateUserData(entity, obj);
        return repository.save(entity);
    }

    private void updateUserData(User e, User o) {
        e.setName(o.getName());
        e.setEmail(o.getEmail());
        e.setPhone(o.getPhone());
    }
}
