package ThePlayerHaze.UnnamedMod.Items;

import ThePlayerHaze.UnnamedMod.HavicRPG;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.*;

public class HavicBasicAxe extends ItemAxe{

        public HavicBasicAxe(int id, EnumToolMaterial material) {
                super(id, material);
                setCreativeTab(HavicRPG.YargModToolsTab);
        }
        
        @Override
        public void registerIcons(IconRegister iconRegister) {
                itemIcon = iconRegister.registerIcon("yargmod:" + this.getUnlocalizedName().substring(5));
        }
        
}