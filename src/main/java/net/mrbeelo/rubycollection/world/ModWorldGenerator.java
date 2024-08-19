package net.mrbeelo.rubycollection.world;

import net.mrbeelo.rubycollection.world.gen.ModEntitySpawns;
import net.mrbeelo.rubycollection.world.gen.ModFlowerGeneration;
import net.mrbeelo.rubycollection.world.gen.ModOreGeneration;
import net.mrbeelo.rubycollection.world.gen.ModTreeGeneration;

public class ModWorldGenerator {
    public static void generateModWorldGeneration() {
        //ModGeodeGeneration.generateGeodes();
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
        ModFlowerGeneration.generateFlowers();
        ModEntitySpawns.generateEntitySpawns();
    }
}
