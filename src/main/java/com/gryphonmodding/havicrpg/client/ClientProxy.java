package com.gryphonmodding.havicrpg.client;

import com.gryphonmodding.havicrpg.client.model.ModelCorthex;
import com.gryphonmodding.havicrpg.client.renderer.entity.RenderTheMob;
import com.gryphonmodding.havicrpg.common.CommonProxy;
import com.gryphonmodding.havicrpg.common.entity.mob.EntityCorthex;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityCorthex.class, new RenderTheMob(new ModelCorthex(), 0.4F));
	}
}
