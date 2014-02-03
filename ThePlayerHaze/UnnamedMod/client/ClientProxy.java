package ThePlayerHaze.UnnamedMod.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import ThePlayerHaze.UnnamedMod.CommonProxy;
import ThePlayerHaze.UnnamedMod.Mobs.entity.EntityCorthex;
import ThePlayerHaze.UnnamedMod.Mobs.entity.RenderTheMob;
import ThePlayerHaze.UnnamedMod.Mobs.model.ModelCorthex;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityCorthex.class, new RenderTheMob(new ModelCorthex(), 0.4F));
		
	}

}
