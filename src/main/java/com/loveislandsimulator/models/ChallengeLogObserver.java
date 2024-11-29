package com.loveislandsimulator.models;

import java.util.List;

/**
 * Interface for observers that monitor and react to updates in the challenge log.
 */
public interface ChallengeLogObserver {
    /**
     * Method that is triggered whenever the challenge log is updated.
     *
     * @param logs The updated list of challenge logs.
     */
    void onLogUpdated(List<String> logs);
}
