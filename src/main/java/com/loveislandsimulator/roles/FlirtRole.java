package com.loveislandsimulator.roles;

import com.loveislandsimulator.decorators.RoleDecorator;
import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.factories.RoleDecoratorFactory;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;

public class FlirtRole extends RoleDecorator {

    public FlirtRole(Islander islander) {
        super(islander, Role.FLIRT);
    }

    @Override
    public void participateInChallenge(ChallengeCommand challenge) {
        super.participateInChallenge(challenge);
        System.out.println(islander.getName() + ", " + RoleDecoratorFactory.getRoleName(Role.FLIRT));
    }
}


