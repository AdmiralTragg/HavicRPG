package com.gryphonmodding.havicrpg.common.world;

import java.util.Random;

import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterEmosion extends Teleporter {

	private final WorldServer WorldServerInstance;
	public final Random random;

	public TeleporterEmosion(WorldServer par1WorldServer) {
		super(par1WorldServer);

		this.WorldServerInstance = par1WorldServer;
		this.random = new Random(par1WorldServer.getSeed());
	}

}
