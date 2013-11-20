package agowa338.BetterFarmLand;

import agowa338.BetterFarmLand.block.BlockFarmlandNew;
import net.minecraft.block.Block;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
//TUTORIAL: http://www.minecraftforum.net/topic/1812671-changing-standard-behaviour-vanilla-blocks-without-modding-base-classes-simple/
@Mod(modid = BetterFarmLand.MOD_ID, name = BetterFarmLand.MOD_NAME, version = BetterFarmLand.MOD_VERSION)
@NetworkMod(clientSideRequired = false, serverSideRequired = true)
public class BetterFarmLand
{
        /* General Mod Information */
        public final static String MOD_ID = "BetterFarmLand";
        public final static String MOD_NAME = "Better Farm Land"; 
        public final static String MOD_VERSION = "1.0.0";
        public final static String MOD_MCVERSION = "1.6.4";
        public final static String MOD_AUTHOR = "agowa338";
        
        @Instance(MOD_ID)
        public static BetterFarmLand instance;         // Use the singleton pattern to access your mod. (e.g. ModDirt.instance...) 
        
        /* This is where the magic happens */
        @EventHandler
        public void load(FMLInitializationEvent event) {
                /* First we remove the vanilla Farmland block from the blocksList */
        	int FarmlandBlockID = Block.tilledField.blockID;
                Block.blocksList[FarmlandBlockID] = null;
                /* Then we add our own Farmland block with the same Id (FarmlandBlockID). */
                Block tilledField = (new BlockFarmlandNew(FarmlandBlockID)).setHardness(0.6F).setStepSound(net.minecraft.block.Block.soundGravelFootstep).setUnlocalizedName("farmland").setTextureName("farmland");
                /* At last we have to register it. */
                GameRegistry.registerBlock(tilledField, "farmland");
        }
}