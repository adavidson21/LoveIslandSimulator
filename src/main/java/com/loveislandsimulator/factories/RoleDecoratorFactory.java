package com.loveislandsimulator.factories;

import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.models.Islander;
import com.loveislandsimulator.roles.FlirtRole;
import com.loveislandsimulator.roles.LeaderRole;
import com.loveislandsimulator.roles.RebelRole;
import com.loveislandsimulator.roles.SurvivorRole;

/**
 * A factory class for creating and managing role-based decorators for Islander objects.
 * Design Pattern: Factory Pattern
 */
public class RoleDecoratorFactory {

    /**
     * Decorates the given Islander with the specified Role.
     *
     * @param islander The islander to decorate.
     * @param role     The role to apply.
     * @return The decorated Islander.
     */
    public static Islander decorateRole(Islander islander, Role role) {
        return switch (role) {
            case REBEL -> new RebelRole(islander);
            case SURVIVOR -> new SurvivorRole(islander);
            case FLIRT -> new FlirtRole(islander);
            case LEADER -> new LeaderRole(islander);
        };
    }
}
