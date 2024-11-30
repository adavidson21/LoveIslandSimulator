package com.loveislandsimulator.roles;

import com.loveislandsimulator.decorators.RoleDecorator;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;

public class FlirtRole extends RoleDecorator {

    public FlirtRole(Islander islander) {
        super(islander);
    }

    @Override
    public void participateInChallenge(ChallengeCommand challenge) {
        super.participateInChallenge(challenge);
        islander.addPoints(8);
        String message = this.islander.getName() + " applied Flirt role for 8 extra points...";
        GameData.getInstance().addLogMessage(message);
    }
}


