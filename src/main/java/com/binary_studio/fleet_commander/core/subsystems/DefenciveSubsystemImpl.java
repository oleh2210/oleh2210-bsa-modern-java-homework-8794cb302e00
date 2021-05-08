package com.binary_studio.fleet_commander.core.subsystems;

import com.binary_studio.fleet_commander.core.actions.attack.AttackAction;
import com.binary_studio.fleet_commander.core.actions.defence.RegenerateAction;
import com.binary_studio.fleet_commander.core.common.PositiveInteger;
import com.binary_studio.fleet_commander.core.subsystems.contract.DefenciveSubsystem;

public final class DefenciveSubsystemImpl implements DefenciveSubsystem {
    private String name;
    private PositiveInteger powergridConsumption;
    private PositiveInteger capacitorConsumption;
    private PositiveInteger impactReductionPercent;
    private PositiveInteger shieldRegeneration;
    private PositiveInteger hullRegeneration;

    public static DefenciveSubsystemImpl construct(String name,
                                                   PositiveInteger powergridConsumption,
                                                   PositiveInteger capacitorConsumption,
                                                   PositiveInteger impactReductionPercent,
                                                   PositiveInteger shieldRegeneration,
                                                   PositiveInteger hullRegeneration) throws IllegalArgumentException {

        DefenciveSubsystemImpl defenciveSubsystem = new DefenciveSubsystemImpl();

        if (name.equals(null) || name.equals(""))
            throw new IllegalArgumentException("Name should be not null and not empty");

        defenciveSubsystem.name = name;
        defenciveSubsystem.powergridConsumption = powergridConsumption;
        defenciveSubsystem.capacitorConsumption = capacitorConsumption;
        defenciveSubsystem.impactReductionPercent = impactReductionPercent;
        defenciveSubsystem.shieldRegeneration = shieldRegeneration;
        defenciveSubsystem.hullRegeneration = hullRegeneration;

        return defenciveSubsystem;
    }

    @Override
    public PositiveInteger getPowerGridConsumption() {
        return powergridConsumption;
    }

    @Override
    public PositiveInteger getCapacitorConsumption() {
        return capacitorConsumption;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public AttackAction reduceDamage(AttackAction incomingDamage) {
        // TODO: Ваш код здесь :)
        return null;
    }

    @Override
    public RegenerateAction regenerate() {
        return new RegenerateAction(shieldRegeneration, hullRegeneration);
    }

}
