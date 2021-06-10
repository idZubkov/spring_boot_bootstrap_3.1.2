package edu.zubkov.crudapp.services;

import edu.zubkov.crudapp.dao.RoleDAO;
import edu.zubkov.crudapp.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> listOfRoles() {
        return roleDAO.listOfRoles();
    }

    @Override
    public Role roleById(long id) {
        return roleDAO.roleById(id);
    }

    @Override
    public Set<Role> getAllRoles(String roles) {
        Set<Role> setOfRoles = roleDAO.setOfRoles(roles);

        String[] arrayOfRoles = roles.split(",");
        Set<Role> userRoles = new HashSet<>();

        for (String nameOfRole : arrayOfRoles) {
            for (Role role : setOfRoles) {
                if (role.getName().equals(nameOfRole))
                    userRoles.add(roleDAO.roleByName(nameOfRole));
            }
        }
        return userRoles;
    }

    public Role roleByName(String roleName) {
        return roleDAO.roleByName(roleName);
    }

    @Override
    public Set<Role> mapRoleNamesToRoles(List<String> roles) {
        Set<Role> collect = new HashSet<>();
        for (String role : roles) {
            Role roleByName = roleDAO.roleByName(role);
            collect.add(roleByName);
        }
        return collect;
    }
}