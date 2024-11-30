package com.loveislandsimulator.roles;

import com.loveislandsimulator.decorators.RoleDecorator;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;

public class RebelRole extends RoleDecorator {

    public RebelRole(Islander islander) {
        super(islander);
    }

    @Override
    public void participateInChallenge(ChallengeCommand challenge) {
        super.participateInChallenge(challenge);
        String message = this.islander.getName();

        double luck = Math.random();
        if (luck < 0.5) {
            super.addPoints(5);
            message += " applied Rebel role for 5 extra points...";
        } else {
            super.addPoints(-5);
            message += " unsuccessfully applied Rebel role and lost 5 points...";
        }
        GameData.getInstance().addLogMessage(message);
    }
}
