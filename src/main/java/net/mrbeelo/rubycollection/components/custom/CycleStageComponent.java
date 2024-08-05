package net.mrbeelo.rubycollection.components.custom;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.MathHelper;

public class CycleStageComponent {
    private static final String CYCLE_STAGE_KEY = "cycle_stage";
    private int cycleStage;

    public CycleStageComponent() {
        this.cycleStage = 0; // Default value
    }

    public int getCycleStage() {
        return this.cycleStage;
    }

    public void setCycleStage(int cycleStage) {
        this.cycleStage = MathHelper.clamp(cycleStage, 0, 3);
    }

    public void readNbt(NbtCompound nbt) {
        this.cycleStage = nbt.getInt(CYCLE_STAGE_KEY);
    }

    public void writeNbt(NbtCompound nbt) {
        nbt.putInt(CYCLE_STAGE_KEY, this.cycleStage);
    }
}
