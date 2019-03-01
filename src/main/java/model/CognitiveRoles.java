package model;

public enum CognitiveRoles {
    HERO(1),
    PARENT(2),
    CHILD(3),
    INFERIOR(4),
    NEMESIS(5),
    CRITICAL_PARENT(6),
    TRICKSTER(7),
    DEMON(8);

    private int cognitiveRank;

    CognitiveRoles(int cognitiveRank) {
        this.cognitiveRank = cognitiveRank;
    }

    public int getCognitiveRank() {
        return cognitiveRank;
    }
}
