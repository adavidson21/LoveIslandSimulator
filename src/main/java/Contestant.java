public interface Contestant {
    
    String getName();
    double getScore();
    void addPoints(double points);
    BehaviorStrategy getStrategy();
    void setStrategy(BehaviorStrategy strategy);
    double applyStrategy(double points);
    void scoreStatus();
    
}
