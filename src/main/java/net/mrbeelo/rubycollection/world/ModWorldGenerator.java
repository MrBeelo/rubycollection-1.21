package net.mrbeelo.rubycollection.world;

import net.mrbeelo.rubycollection.world.gen.ModEntitySpawns;
import net.mrbeelo.rubycollection.world.gen.ModFlowerGeneration;
import net.mrbeelo.rubycollection.world.gen.ModOreGeneration;

public class ModWorldGenerator {
    public static void generateModWorldGeneration() {
        //ModGeodeGeneration.generateGeodes();
        ModOreGeneration.generateOres();
        //ModTreeGeneration.generateTrees();
        ModFlowerGeneration.generateFlowers();
        ModEntitySpawns.generateEntitySpawns();
    }
}
