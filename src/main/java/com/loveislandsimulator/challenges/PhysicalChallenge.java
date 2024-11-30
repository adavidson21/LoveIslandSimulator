package com.loveislandsimulator.challenges;

import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;

public class PhysicalChallenge implements ChallengeCommand {
    private final String name = "Physical Challenge";
    private final String description = "Islanders face a physically demanding task that requires strength, agility, and endurance to compete to score points.";

    @Override
    public void execute(Islander islander) {
        int score = (int) (Math.random() * 15 + 1);
        islander.addPoints(score);
        String message = islander.getName() + " completed Physical Challenge and scored " + score + " points!";
        GameData.getInstance().addLogMessage(message);
    }

    @Override
    public String getDescription(){
        return this.description;
    }

    @Override
    public String getName(){
        return this.name;
    }
}
