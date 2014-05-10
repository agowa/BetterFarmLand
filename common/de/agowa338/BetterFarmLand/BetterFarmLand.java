package de.agowa338.BetterFarmLand;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import de.agowa338.BetterFarmLand.Entity.UseHoe;
import de.agowa338.BetterFarmLand.block.BlockFarmlandNew;

@Mod(modid = BetterFarmLand.MODID, version = BetterFarmLand.VERSION)
public class BetterFarmLand
{
    public static final String MODID = "BetterFarmLand";
    public static final String VERSION = "1.0";
    Block BlockFarmlandNew;
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {}
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(new UseHoe());
    	BlockFarmlandNew = new BlockFarmlandNew();
       GameRegistry.registerBlock(BlockFarmlandNew, "BlockFarmLandNew");
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {}
}
