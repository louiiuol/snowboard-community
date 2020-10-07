package dev.louiiuol.ryding.services.role;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import dev.louiiuol.ryding.api.exceptions.ResourceNotFoundException;
import dev.louiiuol.ryding.business.entities.Role;
import dev.louiiuol.ryding.business.repositories.RoleRepository;
import dev.louiiuol.ryding.services.utils.AbstractService;

/**
 * Concrete implementation of {@code RoleService}
 * that extends {@code AbstractService} to handle {@code Role}
 * 
 * @see RoleService
 * @see AbstractService
 * @see Service
 */
@Service
public class RoleServiceImpl extends AbstractService<Role, RoleRepository>
    implements RoleService {

    protected RoleServiceImpl(RoleRepository repo) {
        super(repo);
    }

    @Override
    public Set<Role> getRoles(String code) {
        Set<Role> roles = new HashSet<>(); 
        Role role = repo().findByCode(code)
            .orElseThrow(ResourceNotFoundException::new);
        roles.add(role);
        return roles;
    }

}