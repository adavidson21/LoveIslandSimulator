package com.loveislandsimulator.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Utility methods to be used across the application.
 */
public class Utils {
    private static Random random = new Random();

    // Static list of names to use to randomly populate islander names.
    private static final List<String> availableNames = new ArrayList<>(List.of(
            "Alex", "Jordan", "Taylor", "Casey", "Riley", "Morgan", "Jamie", "Drew",
            "Sydney", "Peyton", "Avery", "Quinn", "Charlie", "Cameron", "Rowan",
            "Skyler", "Harper", "Elliot", "Emerson", "Dakota", "Phoenix", "Logan",
            "Finley", "Hayden", "Reese", "Sage", "Shiloh", "Tanner", "Oakley", "Kai"
    ));

    /**
     * Gets a random name from a list of predefined names and removes it from the available names list.
     *
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
}
