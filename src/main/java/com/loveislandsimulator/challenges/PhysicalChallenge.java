package com.loveislandsimulator.challenges;

import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;

public class PhysicalChallenge implements ChallengeCommand {

    @Override
    public void execute(Islander islander) {
        int score = (int) (Math.random() * 15 + 1);
        islander.addPoints(score);
        String message = islander.getName() + " completed Physical Challenge and scored " + score + " points!";
        GameData.getInstance().addLogMessage(message);
    }

    @Override
    public String getDescription(){
        return "Islanders face a physically demanding task that requires strength, agility, and endurance to compete to score points.";
    }

    @Override
    public String getName(){
        return "Physical Challenge";
    }
}
