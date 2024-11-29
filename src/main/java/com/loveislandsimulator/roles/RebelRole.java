package com.loveislandsimulator.roles;

import com.loveislandsimulator.decorators.RoleDecorator;
import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;

public class RebelRole extends RoleDecorator {
    
    public RebelRole(Contestant islander) {
        super(islander);
    }

    @Override
    public void addPoints(double points) {
        double luck = Math.random();
        if (luck < 0.5) {
            double wrappedPoints = points + 5;
            super.addPoints(wrappedPoints);
            System.out.println(this.wrappedIslander.getName() + " applied Rebel role for 5 extra points...");   
        } else {
            double wrappedPoints = points - 5;
            super.addPoints(wrappedPoints);
            System.out.println(this.wrappedIslander.getName() + " unsuccessfullly applied Rebel role and lost 5 points...");   
        }
    }

}
