package com.loveislandsimulator.factories;

import com.loveislandsimulator.challenges.PhysicalChallenge;
import com.loveislandsimulator.challenges.SocialChallenge;
import com.loveislandsimulator.challenges.TriviaChallenge;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.GameData;

import java.util.List;

/**
 * Factory class for creating ChallengeCommand objects.
 * Design Pattern: Factory Pattern
 */
public class ChallengeFactory {
    /**
     * Creates a ChallengeCommand based on the provided type.
     *
     * @param type The type of challenge.
     * @return The corresponding ChallengeCommand instance.
     */
    public static ChallengeCommand createChallenge(String type) {
        return switch (type.toLowerCase()) {
            case "physical" -> new PhysicalChallenge();
            case "social" -> new SocialChallenge();
            case "trivia" -> new TriviaChallenge();
            default -> throw new IllegalArgumentException("Unknown challenge type: " + type);
        };
    }

    /**
     * Retrieves all available challenge types.
     *
     * @return A list of available challenge names.
     */
    public static List<String> getAvailableChallenges() {
        return List.of("Physical Challenge", "Social Challenge", "Trivia Challenge");
    }

    /**
     * Finds a challenge by its name from the current game data.
     *
     * @param name The name of the challenge.
     * @return The matching ChallengeCommand, or null if not found.
     */
    public static ChallengeCommand findChallengeByName(String name) {
        return GameData.getInstance().getChallenges().stream()
                .filter(challenge -> challenge.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
