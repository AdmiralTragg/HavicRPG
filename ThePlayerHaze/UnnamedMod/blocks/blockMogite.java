package ThePlayerHaze.UnnamedMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class blockMogite extends Block{

	public blockMogite(int id, Material mat) {
		super(id, mat);
	}
	public void registerIcons(IconRegister reg) { // Make sure to import IconRegister!
		this.blockIcon = reg.registerIcon("yargmod:MogiteBlock"); // You can also replace blockID and blockIcon with itemID and itemIcon
		}
}
