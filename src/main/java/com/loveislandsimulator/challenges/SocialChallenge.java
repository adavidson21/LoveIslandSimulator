package com.loveislandsimulator.challenges;

import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;

public class SocialChallenge implements ChallengeCommand {
    private final String name = "Social Challenge";
    private final String description = "Islanders engage in activities that test their social skills, including persuasion, alliance building, and emotional intelligence, to score points.";

    @Override
    public void execute(Islander islander) {
        int score = (int) (Math.random() * 8 + 1);
        islander.addPoints(score);
        String message = islander.getName() + " completed Social Challenge and scored " + score + " points!";
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
