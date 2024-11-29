package com.loveislandsimulator.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class for managing the game data including islanders and challenges.
 * Design Pattern: Singleton Pattern
 */
public class GameData {
    private static GameData instance; // Singleton instance
    private final ObservableList<Islander> islanders = FXCollections.observableArrayList();
    private final List<ChallengeCommand> challenges;
    private final List<ChallengeLogObserver> observers = new ArrayList<>();
    private final List<String> challengeLog = new ArrayList<>();
    private int challengeCount;

    private GameData() {
        challenges = new ArrayList<>();
        challengeCount = 1;
    }

    //#region Observer Methods

    /**
     * Adds an observer to the list of observers for the challenge log.
     *
     * @param observer The observer to add.
     */
    public void addObserver(ChallengeLogObserver observer) {
        observers.add(observer);
    }

    /**
     * Notifies all observers of changes to the challenge log.
     * Each observer is provided a copy of the current log.
     */
    private void notifyObservers() {
        for (ChallengeLogObserver observer : observers) {
            observer.onLogUpdated(new ArrayList<>(challengeLog));
        }
    }

    /**
     * Adds a new log message to the challenge log and notifies observers.
     *
     * @param message The log message to add.
     */
    public void addLogMessage(String message) {
        challengeLog.add(message);
        notifyObservers(); // Notify observers when a new log is added
    }

    /**
     * Clears the challenge log and notifies observers.
     */
    public void clearChallengeLog() {
        challengeLog.clear();
        notifyObservers(); // Notify observers when the log is cleared
    }
    //#endregion

    /**
     * Gets the Singleton instance of the GameData.
     * If there is not an instance of the class already created, then create one.
     *
     * @return The instance of GameData.
     */
    public static synchronized GameData getInstance(){
        if (instance == null){
            instance = new GameData();
        }
        return instance;
    }

    /**
     * Adds an islander to the list of islanders.
     * @param islander The islander to add.
     */
    public void addIslander(Islander islander) {
        islanders.add(islander);
    }

    /**
     * Gets the list of islanders.
     * @return The list of islanders.
     */
    public ObservableList<Islander> getIslanders() {
        return islanders;
    }

    /**
     * Clears all islanders from the game data.
     */
    public void clearIslanders() {
        islanders.clear();
    }

    /**
     * Reset game data back to initial state.
     */
    public void reset() {
        this.clearIslanders();
        challengeCount = 1;
    }

    /**
     * Adds a challenge to the list of challenges.
     * @param challenge The ChallengeCommand to be added.
     */
    public void addChallenge(ChallengeCommand challenge) {
        challenges.add(challenge);
    }

    /**
     * Gets the list of all challenges.
     * @return The list of ChallengeCommands.
     */
    public List<ChallengeCommand> getChallenges() {
        return challenges;
    }

    /**
     * Gets the number of completed challenges in the game.
     * @return The number of completed challenges.
     */
    public int getChallengeCount(){
        return challengeCount;
    }

    /**
     * Increments the number of completed challenges by 1.
     */
    public void incrementCompleted(){
        challengeCount++;
    }


}
