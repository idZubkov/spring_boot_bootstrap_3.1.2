package edu.zubkov.crudapp.dao;

import edu.zubkov.crudapp.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleDAO {
    List<Role> listOfRoles();

    Role roleById(long id);

    Set<Role> setOfRoles(String roles);

    Role roleByName(String nameOfRole);
}