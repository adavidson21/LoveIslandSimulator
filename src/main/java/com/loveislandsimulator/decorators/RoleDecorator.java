public abstract class RoleDecorator implements Contestant {
    
    protected Contestant wrappedIslander;

    public RoleDecorator(Contestant islander) {
        this.wrappedIslander = islander;
    }

    @Override
    public String getName() {
        return wrappedIslander.getName();
    }

    @Override
    public double getScore() {
        return wrappedIslander.getScore();
    }

    @Override
    public void addPoints(double points) {
        wrappedIslander.addPoints(points);
    }

    @Override
    public BehaviorStrategy getStrategy() {
        return wrappedIslander.getStrategy();
    }

    @Override
    public void setStrategy(BehaviorStrategy strategy) {
        wrappedIslander.setStrategy(strategy);
    }

    @Override
    public double applyStrategy(double points) {
        return wrappedIslander.applyStrategy(points);
    }
    
    @Override
    public void scoreStatus() {
        wrappedIslander.scoreStatus();
    }
}
