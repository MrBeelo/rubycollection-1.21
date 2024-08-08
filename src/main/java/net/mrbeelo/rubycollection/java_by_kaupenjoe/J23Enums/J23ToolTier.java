package net.mrbeelo.rubycollection.java_by_kaupenjoe.J23Enums;

public enum J23ToolTier {
    DIAMOND(10, 2),
    NETHERITE(100, 4);

    private final int attackMultiplier;
    private final int attackSpeed;

    J23ToolTier(int attackMultiplier, int attackSpeed) {
        this.attackMultiplier = attackMultiplier;
        this.attackSpeed = attackSpeed;
    }

    public int getAttackMultiplier() {
        return attackMultiplier;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }
}
