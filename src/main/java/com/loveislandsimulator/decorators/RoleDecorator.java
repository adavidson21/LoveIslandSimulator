package com.loveislandsimulator.decorators;

import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;
import com.loveislandsimulator.strategies.IslanderBehaviorStrategy;

/**
 * The RoleDecorator abstract class wraps around an Islander object and allows additional roles to be associated with the Islander.
 * Design Pattern: Decorator Pattern
 */
public abstract class RoleDecorator extends Islander {
    protected Islander islander;

    public RoleDecorator(Islander islander) {
        super(islander.getName());
        this.islander = islander;
    }

    @Override
    public void participateInChallenge(ChallengeCommand challenge) {
        islander.participateInChallenge(challenge);
    }

    @Override
    public int getScore() {
        return islander.getScore();
    }

    @Override
    public void addPoints(int points) {
        islander.addPoints(points);
    }

    @Override
    public IslanderBehaviorStrategy getBehaviorStrategy() {
        return islander.getBehaviorStrategy();
    }

    @Override
    public void setBehaviorStrategy(IslanderBehaviorStrategy strategy) {
        islander.setBehaviorStrategy(strategy);
    }

    @Override
    public String getName() {
        return islander.getName();
    }
}
