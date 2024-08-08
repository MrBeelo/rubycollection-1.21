package net.mrbeelo.rubycollection.java_by_kaupenjoe.J26Generics;

import java.util.ArrayList;
import java.util.List;

public class J26Generics {
    public static void main(String[] args) {
        /* GENERICS */
        List<Integer> numbers = new ArrayList<>();

        J26Pair<Integer, ?> test = new J26Pair<>(2000, 50.55f);
    }
}
