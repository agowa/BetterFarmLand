package de.agowa338.BetterFarmLand.Entity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import de.agowa338.BetterFarmLand.block.init.Blocks;

public class UseHoe {
	
	@SubscribeEvent 
	public void onEntityUseHoe(UseHoeEvent event) {
		EntityPlayer par2EntityPlayer = event.entityPlayer;
		ItemStack par1ItemStack = event.current;
		World par3World = event.world;
		int par4 = event.x;
		int par5 = event.y;
		int par6 = event.z;
		int par7 = 1;
		Result result;
		
		Block block = par3World.getBlock(par4, par5, par6);
		if (par7 != 0 && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.grass || block == Blocks.dirt))
        {
			Block block1 = Blocks.farmland;
            //BetterFarmLand:BlockFarmLandNew
            par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

            if (par3World.isRemote)
            {
            	result = Result.ALLOW;
            } else {
                par3World.setBlock(par4, par5, par6, block1);
                par1ItemStack.damageItem(1, par2EntityPlayer);
                result = Result.ALLOW;
            }
        }
        else {
        	result = Result.DENY;
        }
	}
}
/*Löschen nach dem alles oben eingefügt wurde
public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
{
        UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);

        Block block = par3World.getBlock(par4, par5, par6);

        if (par7 != 0 && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.grass || block == Blocks.dirt))
        {
            Block block1 = Blocks.farmland;
            par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

            if (par3World.isRemote)
            {
                return true;
            }
            else
            {
                par3World.setBlock(par4, par5, par6, block1);
                par1ItemStack.damageItem(1, par2EntityPlayer);
                return true;
            }
        }
        else
        {
            return false;
        }
}
*/