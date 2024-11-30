package com.loveislandsimulator.roles;

import com.loveislandsimulator.decorators.RoleDecorator;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;

public class SurvivorRole extends RoleDecorator {

    public SurvivorRole(Islander islander) {
        super(islander);
    }

    @Override
    public void participateInChallenge(ChallengeCommand challenge) {
        super.participateInChallenge(challenge);
        super.addPoints(5);
        String message = this.islander.getName() + " applied Survivor role for 5 extra points...";
        GameData.getInstance().addLogMessage(message);
    }

}
