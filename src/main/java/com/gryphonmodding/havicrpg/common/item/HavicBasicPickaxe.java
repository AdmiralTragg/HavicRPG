package com.gryphonmodding.havicrpg.common.item;

import com.gryphonmodding.havicrpg.HavicRPG;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.*;

public class HavicBasicPickaxe extends ItemPickaxe{

        public HavicBasicPickaxe(int id, EnumToolMaterial material) {
                super(id, material);
                setCreativeTab(HavicRPG.YargModToolsTab);
        }
        
        @Override
        public void registerIcons(IconRegister iconRegister) {
                itemIcon = iconRegister.registerIcon("yargmod:" + this.getUnlocalizedName().substring(5));
        }
        
}