package net.mrbeelo.rubycollection.components.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.MathHelper;

import java.util.Objects;

public class CycleStageComponent {
    public static final String CYCLE_STAGE_KEY = "cycle_stage";
    public int cycleStage;

    // Define the codec for serializing and deserializing CycleStageComponent
    public static final Codec<CycleStageComponent> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf(CYCLE_STAGE_KEY).forGetter(CycleStageComponent::getCycleStage)
            ).apply(instance, CycleStageComponent::new));

    // Constructor for the codec
    public CycleStageComponent(int cycleStage) {
        this.cycleStage = MathHelper.clamp(cycleStage, 0, 3); // Ensures cycleStage is between 0 and 3
    }

    public int getCycleStage() {
        return this.cycleStage;
    }

    public void setCycleStage(int cycleStage) {
        this.cycleStage = MathHelper.clamp(cycleStage, 0, 3);
    }

    public String getOutputString() {
        return "cycle set to " + cycleStage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cycleStage);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return obj instanceof CycleStageComponent csc && this.cycleStage == csc.cycleStage;
        }
    }
}
