package edu.zubkov.crudapp.services;

import edu.zubkov.crudapp.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    List<Role> listOfRoles();

    Role roleById(long id);

    Set<Role> getAllRoles(String roles);

    Set<Role> mapRoleNamesToRoles(List<String> roles);

    public Role roleByName(String roleName);
}