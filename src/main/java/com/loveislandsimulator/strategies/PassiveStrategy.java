package com.loveislandsimulator.strategies;

import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;

/**
 * Implementation of a passive behavior strategy for an Islander.
 */
public class PassiveStrategy implements IslanderBehaviorStrategy {
    private final String name = "Passive";

    /**
     * Returns the name of this strategy.
     *
     * @return The name of the strategy, which is "Passive".
     */
    @Override
    public String getStrategyName() {
        return this.name;
    }

    /**
     * Executes the passive behavior strategy for an islander during a challenge.
     *
     * @param islander The islander.
     * @param challenge The challenge the islander is participating in.
     */
    @Override
    public void perform(Islander islander, ChallengeCommand challenge) {
        String message = islander.getName() + " approaches passively.";
        GameData.getInstance().addLogMessage(message);
        challenge.execute(islander);
    }
}
