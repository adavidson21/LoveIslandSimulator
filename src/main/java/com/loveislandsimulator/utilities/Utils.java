package com.loveislandsimulator.utilities;

import com.loveislandsimulator.strategies.AggressiveStrategy;
import com.loveislandsimulator.strategies.BalancedStrategy;
import com.loveislandsimulator.strategies.IslanderBehaviorStrategy;
import com.loveislandsimulator.strategies.PassiveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Utility methods to be used across the application.
 */
public class Utils {
    private static final Random random = new Random();
    private static final List<String> availableNames = new ArrayList<>(List.of(
            "Alex", "Jordan", "Taylor", "Casey", "Riley", "Morgan", "Jamie", "Drew",
            "Sydney", "Peyton", "Avery", "Quinn", "Charlie", "Cameron", "Rowan",
            "Skyler", "Harper", "Elliot", "Emerson", "Dakota", "Phoenix", "Logan",
            "Finley", "Hayden", "Reese", "Sage", "Shiloh", "Tanner", "Oakley", "Kai"
    ));

    /**
     * Gets a random name from a list of predefined names and removes it from the available names list.
     * @return The randomly selected unique name.
     */
    public static String getRandomName() {
        if (availableNames.isEmpty()) {
            throw new IllegalStateException("No unique names available.");
        }

        int index = random.nextInt(availableNames.size());
        return availableNames.remove(index);
    }

    /**
     * Resets the list of available names.
     */
    public static void resetAvailableNames() {
        availableNames.clear();
        availableNames.addAll(List.of(
                "Alex", "Jordan", "Taylor", "Casey", "Riley", "Morgan", "Jamie", "Drew",
                "Sydney", "Peyton", "Avery", "Quinn", "Charlie", "Cameron", "Rowan",
                "Skyler", "Harper", "Elliot", "Emerson", "Dakota", "Phoenix", "Logan",
                "Finley", "Hayden", "Reese", "Sage", "Shiloh", "Tanner", "Oakley", "Kai"
        ));
    }

    /**
     * Converts a string to a corresponding IslanderBehaviorStrategy instance.
     *
     * @param name The name of the strategy (case-insensitive).
     * @return The IslanderBehaviorStrategy instance corresponding to the name.
     * @throws IllegalArgumentException If no matching strategy is found.
     */
    public static IslanderBehaviorStrategy strategyFromString(String name) {
        return switch (name.toLowerCase()) {
            case "aggressive" -> new AggressiveStrategy();
            case "balanced" -> new BalancedStrategy();
            case "passive" -> new PassiveStrategy();
            default -> null;
        };
    }

    /**
     * Retrieves all available strategies.
     *
     * @return A list of all available IslanderBehaviorStrategy.
     */
    public static List<IslanderBehaviorStrategy> getAllStrategies() {
        return Arrays.asList(
                new AggressiveStrategy(),
                new BalancedStrategy(),
                new PassiveStrategy()
        );
    }
}
