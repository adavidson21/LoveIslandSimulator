package com.loveislandsimulator.utilities;

import com.loveislandsimulator.controllers.components.IslanderController;
import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.factories.RoleDecoratorFactory;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.Random;

/**
 * Utility methods for actions related to challenges that can be reused.
 */
public class ChallengeUtils {

    /**
     * Decorates islanders with their selected roles, then each islander performs the challenge.
     *
     * @param container The islander container.
     * @param islanders The islanders.
     * @param challenge The challenge to perform.
     */
    public static void decorateAndPerformChallenge(Pane container, List<Islander> islanders, ChallengeCommand challenge) {
        container.getChildren().forEach(node -> {
            IslanderController controller = (IslanderController) node.getUserData();
            Islander islander = islanders.stream()
                    .filter(i -> i.getName().equals(controller.getName()))
                    .findFirst()
                    .orElse(null);

            if (islander != null) {
                List<Role> roles = controller.getRoles();
                islander = decorateWithRoles(islander, roles);
                islander.participateInChallenge(challenge);
            }
        });
    }

    /**
     * Decorates an islander with the selected roles.
     *
     * @param islander The islander.
     * @param roles    The roles to decorate the islander with.
     * @return The decorated islander.
     */
    private static Islander decorateWithRoles(Islander islander, List<Role> roles) {
        for (Role role : roles) {
            islander = RoleDecoratorFactory.decorateRole(islander, role);
        }
        return islander;
    }

    /**
     * Gets a random challenge from the list of challenges.
     *
     * @param challenges The list of challenges (ChallengeCommand)
     * @return A randomly-selected challenge.
     */
    public static ChallengeCommand getRandomChallenge(List<ChallengeCommand> challenges) {
        if (challenges == null || challenges.isEmpty()) {
            throw new IllegalArgumentException("Challenge list cannot be null or empty.");
        }
        return challenges.get(new Random().nextInt(challenges.size()));
    }
}
