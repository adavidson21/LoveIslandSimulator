package com.loveislandsimulator.strategies;

import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;

/**
 * Interface for defining the behavior strategies of Islanders.
 */
public interface IslanderBehaviorStrategy {
    /**
     * Executes the behavior strategy for an islander during a challenge.
     *
     * @param islander The islander.
     * @param challenge The challenge the islander is participating in.
     */
    void perform(Islander islander, ChallengeCommand challenge);

    /**
     * Returns the name of the strategy in a user-friendly format.
     *
     * @return The name of the strategy.
     */
    String getStrategyName();
}


