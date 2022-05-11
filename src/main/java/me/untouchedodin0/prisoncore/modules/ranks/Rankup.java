package me.untouchedodin0.prisoncore.modules.ranks;

public class Rankup {

    private final int order;
    private final String rank;
    private final double cost;

    private final boolean lastRank;

    public Rankup(int order, String rank, double cost, boolean lastRank) {
        this.order = order;
        this.rank = rank;
        this.cost = cost;
        this.lastRank = lastRank;
    }

    public int getOrder() {
        return order;
    }

    public String getRank() {
        return rank;
    }

    public double getCost() {
        return cost;
    }

    public boolean isLastRank() {
        return lastRank;
    }
}
