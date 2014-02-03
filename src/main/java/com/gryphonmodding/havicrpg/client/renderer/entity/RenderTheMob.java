package com.gryphonmodding.havicrpg.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTheMob extends RenderLiving{
	private static final ResourceLocation Corthex = new ResourceLocation("yargmod:textures/mobs/Corthex.png");
	public RenderTheMob(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return Corthex;
	}
	
}

