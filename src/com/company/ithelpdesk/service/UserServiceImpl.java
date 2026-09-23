package com.company.ithelpdesk.service;

import com.company.ithelpdesk.model.user.Employee;
import com.company.ithelpdesk.model.user.ITEngineer;
import com.company.ithelpdesk.model.user.Manager;
import com.company.ithelpdesk.model.user.User;
import com.company.ithelpdesk.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService{

    private static UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User registerEmployee(Employee employee) {
        if(employee == null){
            throw new RuntimeException("Employee can not be null");
        }
        boolean emailExists = userRepository.userEmailExists(employee.getEmail());
        boolean userIdExists = userRepository.userIdExists(employee.getId());

        if(emailExists || userIdExists){
            throw new RuntimeException("Email or Id already exists.");
        }

        User user = userRepository.saveUser(employee);
        return user;
    }

    @Override
    public User registerItEngineer(ITEngineer itEngineer) {
        if(itEngineer == null){
            throw new RuntimeException("IT Engineer can not be null");
        }
        boolean emailExists = userRepository.userEmailExists(itEngineer.getEmail());
        boolean userIdExists = userRepository.userIdExists(itEngineer.getId());

        if(emailExists || userIdExists){
            throw new RuntimeException("Email or Id already exists.");
        }

        User user = userRepository.saveUser(itEngineer);
        return user;
    }

    @Override
    public User registerManager(Manager manager) {
        if(manager == null){
            throw new RuntimeException("Manager can not be null");
        }
        boolean emailExists = userRepository.userEmailExists(manager.getEmail());
        boolean userIdExists = userRepository.userIdExists(manager.getId());

        if(emailExists || userIdExists){
            throw new RuntimeException("Email or Id already exists.");
        }

        User user = userRepository.saveUser(manager);
        return user;
    }

    @Override
    public User findByUserId(long userId) {
        User user = userRepository.findUserById(userId);
        if(user == null){
            throw new RuntimeException("User Id does not exists");
        }
        return user;
    }

    @Override
    public User deactivateUser(long userId) {
        return userRepository.deactivateUser(userId);
    }

    @Override
    public User activateUser(long userId) {
        return userRepository.activateUser(userId);
    }

    @Override
    public List<User> listAllUsers() {
        return userRepository.getAllUsers();
    }
}
