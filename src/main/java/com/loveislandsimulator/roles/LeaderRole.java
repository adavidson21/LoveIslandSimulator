package com.loveislandsimulator.roles;

import com.loveislandsimulator.decorators.RoleDecorator;
import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;

public class LeaderRole extends RoleDecorator {

    public LeaderRole(Islander islander) {
        super(islander, Role.LEADER);
    }

    @Override
    public void participateInChallenge(ChallengeCommand challenge) {
        super.participateInChallenge(challenge);
        islander.addPoints(10);
        String message = this.islander.getName() + " applied Leader role for 10 extra points...";
        GameData.getInstance().addLogMessage(message);
    }
}
