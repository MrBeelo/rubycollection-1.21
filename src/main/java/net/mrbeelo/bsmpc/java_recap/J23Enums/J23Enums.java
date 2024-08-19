package net.mrbeelo.bsmpc.java_recap.J23Enums;

public class J23Enums {
    public static void main(String[] args) {
        /* ENUMS */

        J23Difficulty gameDifficulty = J23Difficulty.MEDIUM;
        gameDifficulty = J23Difficulty.HARD;

        if(gameDifficulty == J23Difficulty.EASY) {

        }

        J23ToolTier tier = J23ToolTier.DIAMOND;
        System.out.println(tier.getAttackMultiplier());
    }
}
