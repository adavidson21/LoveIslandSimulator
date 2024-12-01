# Love Island Simulator

## Project Overview
The Love Island Simulator is a reality game show-inspired application where players simulate islanders competing in challenges, adopting dynamic roles, and executing unique behaviors. The project integrates design patterns to deliver a modular and scalable gameplay experience.

---
## Group Members
- Alexis Davidson
- Tiara Gibson
- Khushi Jani 

## Features
1. **Dynamic Challenges**:
   - Challenges (e.g., Trivia, Physical, Social) are executed using the **Command Pattern** for flexibility and modularity.
   - Players select challenges, simulate outcomes, and view updated scores.

2. **Islander Behaviors**:
   - Islander strategies, such as Aggressive, Balanced, and Passive, are set at the start of the game using the **Strategy Pattern**.

3. **Roles and Enhancements**:
   - Using the **Decorator Pattern**, roles like Flirt, Outsider, or Leader are dynamically assigned during gameplay, enhancing islander actions in challenges.

4. **Score Management**:
   - The **Singleton Pattern** ensures consistent score tracking across the game.

5. **User Flow**:
   - The flow has been refined for clarity and gameplay:  
     1. Select a behavior strategy for each islander.  
     2. Choose a challenge.  
     3. Assign roles to islanders dynamically.  
     4. Simulate the challenge.  
     5. Display actions taken and update the scoreboard.

---

## Design Patterns Used
- **Command Pattern**: Manages dynamic execution of challenges.
- **Strategy Pattern**: Assigns flexible behaviors to islanders during challenges.
- **Decorator Pattern**: Adds dynamic roles to islanders during gameplay.
- **Singleton Pattern**: Tracks and updates scores centrally.
- **Factory Pattern**: Simpifies and standardizes the creation of roles and challenges.


---

## Tech Stack
- **Language**: Java  
- **UI Framework**: JavaFX  
- **Tools**: IntelliJ IDEA, SceneBuilder  
- **Data Storage**: In-memory using `GameData` and `ScoreTrackerSingleton`

---

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/adavidson21/LoveIslandSimulator.git
2. Open the project in Visual Studio Code or your preferred IDE.
3. Ensure JavaFX libraries are set up in your project.
4. Run LoveIslandSimulatorApp.java.

---

## Team Contributions
- **Tiara Gibson**:
  - Designed the Command, Strategy, and Singleton Patterns.
  - Managed challenge execution, behaviors, and score tracking.

- **Alexis Davidson**:
  - Managed game data and challenges with the `GameData` singleton.
  - Implemented scene controllers and JavaFX UI navigation.

- **Khushi Patel**:
  - Developed role-based features using the Decorator Pattern.
  - Integrated role and behavior interplay during gameplay.

---

## License
This project is open-source and available under the [MIT License](LICENSE).



