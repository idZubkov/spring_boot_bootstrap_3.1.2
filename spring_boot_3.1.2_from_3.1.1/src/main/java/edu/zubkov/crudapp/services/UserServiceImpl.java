package edu.zubkov.crudapp.services;

import edu.zubkov.crudapp.dao.RoleDAO;
import edu.zubkov.crudapp.dao.UserDAO;
import edu.zubkov.crudapp.models.Role;
import edu.zubkov.crudapp.models.User;
import edu.zubkov.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    private final RoleDAO roleDAO;

    private final PasswordEncoder passwordEncoder;

    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    @Transactional
    public void add(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setProfession(userDto.getProfession());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        Role role = roleDAO.roleByName(userDto.getAuthorities());
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        user.setRoles(roleSet);
        userDAO.add(user);
    }


    @Override
    @Transactional
    public void deleteById(long id) {
        userDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void update(UserDto userDto, long id) {
        User userById = userDAO.getById(id);
        userById.setName(userDto.getName());
        userById.setSurname(userDto.getSurname());
        userById.setProfession(userDto.getProfession());
        userById.setUsername(userDto.getUsername());
        userById.setPassword(userDto.getPassword());

        Set<Role> roleSet = roleService.mapRoleNamesToRoles(userDto.getRoles());

//        Set<Role> roleSet = new HashSet<>();
        userById.setRoles(roleSet);
//        Role role = roleDAO.roleByName(userDto.getAuthorities());
//        roleSet.add(role);
//        userById.setRoles(roleSet);
        userDAO.update(userById);
    }

    @Override
    @Transactional
    public User getById(long id) {
        return userDAO.getById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDAO.findByUsername(s);
    }
}