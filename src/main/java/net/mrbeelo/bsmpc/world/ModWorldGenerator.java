package net.mrbeelo.bsmpc.world;

import net.mrbeelo.bsmpc.world.gen.ModEntitySpawns;
import net.mrbeelo.bsmpc.world.gen.ModFlowerGeneration;
import net.mrbeelo.bsmpc.world.gen.ModOreGeneration;
import net.mrbeelo.bsmpc.world.gen.ModTreeGeneration;

public class ModWorldGenerator {
    public static void generateModWorldGeneration() {
        //ModGeodeGeneration.generateGeodes();
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
        ModFlowerGeneration.generateFlowers();
        ModEntitySpawns.generateEntitySpawns();
    }
}
