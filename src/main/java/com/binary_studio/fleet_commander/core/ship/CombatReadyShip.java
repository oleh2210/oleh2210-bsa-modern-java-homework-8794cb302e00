package com.binary_studio.fleet_commander.core.ship;

import java.util.Optional;

import com.binary_studio.fleet_commander.core.actions.attack.AttackAction;
import com.binary_studio.fleet_commander.core.actions.defence.AttackResult;
import com.binary_studio.fleet_commander.core.actions.defence.RegenerateAction;
import com.binary_studio.fleet_commander.core.common.Attackable;
import com.binary_studio.fleet_commander.core.common.PositiveInteger;
import com.binary_studio.fleet_commander.core.ship.contract.CombatReadyVessel;

public final class CombatReadyShip implements CombatReadyVessel {
	private String name;
	private PositiveInteger currentSpeed;
	private PositiveInteger size;

	public CombatReadyShip(String name,
						   PositiveInteger currentSpeed,
						   PositiveInteger size) {
		this.name = name;
		this.currentSpeed = currentSpeed;
		this.size = size;
	}

	@Override
	public void endTurn() {
		// TODO: Ваш код здесь :)

	}

	@Override
	public void startTurn() {
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public PositiveInteger getSize() {
		return size;
	}

	@Override
	public PositiveInteger getCurrentSpeed() {
		return currentSpeed;
	}

	@Override
	public Optional<AttackAction> attack(Attackable target) {
		// TODO: Ваш код здесь :)
		return null;
	}

	@Override
	public AttackResult applyAttack(AttackAction attack) {
		// TODO: Ваш код здесь :)
		return null;
	}

	@Override
	public Optional<RegenerateAction> regenerate() {
		// TODO: Ваш код здесь :)
		return null;
	}

}
