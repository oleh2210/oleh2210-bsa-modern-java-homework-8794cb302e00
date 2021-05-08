package com.binary_studio.fleet_commander.core.subsystems;

import com.binary_studio.fleet_commander.core.common.Attackable;
import com.binary_studio.fleet_commander.core.common.PositiveInteger;
import com.binary_studio.fleet_commander.core.subsystems.contract.AttackSubsystem;

public final class AttackSubsystemImpl implements AttackSubsystem {
    private String name;
    private PositiveInteger powergridRequirments;
    private PositiveInteger capacitorConsumption;
    private PositiveInteger optimalSpeed;
    private PositiveInteger optimalSize;
    private PositiveInteger baseDamage;

    public static AttackSubsystemImpl construct(String name,
                                                PositiveInteger powergridRequirments,
                                                PositiveInteger capacitorConsumption,
                                                PositiveInteger optimalSpeed,
                                                PositiveInteger optimalSize,
                                                PositiveInteger baseDamage) throws IllegalArgumentException {

        AttackSubsystemImpl attackSubsystem = new AttackSubsystemImpl();

        if (name.equals(null) || name.equals(""))
            throw new IllegalArgumentException("Name should be not null and not empty");

        attackSubsystem.name = name;
        attackSubsystem.powergridRequirments = powergridRequirments;
        attackSubsystem.capacitorConsumption = capacitorConsumption;
        attackSubsystem.optimalSpeed = optimalSpeed;
        attackSubsystem.optimalSize = optimalSize;
        attackSubsystem.baseDamage = baseDamage;

        return attackSubsystem;
    }

    @Override
    public PositiveInteger getPowerGridConsumption() {
        return powergridRequirments;
    }

    @Override
    public PositiveInteger getCapacitorConsumption() {
        return capacitorConsumption;
    }

    @Override
    public PositiveInteger attack(Attackable target) {
        // TODO: Ваш код здесь :)
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

}
