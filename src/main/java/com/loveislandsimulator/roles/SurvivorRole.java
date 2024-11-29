package com.loveislandsimulator.roles;

import com.loveislandsimulator.decorators.RoleDecorator;
import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;

public class SurvivorRole extends RoleDecorator {
    
    public SurvivorRole(Contestant islander) {
        super(islander);
    }

    @Override
    public void addPoints(double points) {
        double wrappedPoints = points + 5;
        super.addPoints(wrappedPoints);
        System.out.println(this.wrappedIslander.getName() + " applied Survivor role for 5 extra points...");
    }

}
