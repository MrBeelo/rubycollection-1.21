package net.mrbeelo.bsmpc.java_recap;

public class J10SwitchStatements {
    public static void main(String[] args) {
        /* SWITCH STATEMENT  */

        int medalPlacement = 3;

        switch(medalPlacement) {
            case 1: System.out.println("GOLD MEDAL"); break;
            case 2: System.out.println("SILVER MEDAL"); break;
            case 3: System.out.println("BRONZE MEDAL"); break;
            default: System.out.println("NO MEDAL"); break;
        }
    }
}
