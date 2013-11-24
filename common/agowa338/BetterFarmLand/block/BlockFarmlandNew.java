package agowa338.BetterFarmLand.block;

import java.util.Random;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockFarmlandNew extends BlockFarmland
{
    public BlockFarmlandNew(int par1)
    {
        super(par1);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!this.isWaterNearby(par1World, par2, par3, par4))
        {
            super.updateTick(par1World, par2, par3, par4, par5Random);
        }
        else
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 7, 2);
        }
    }
    
    /**
     * returns true if there's water nearby (x-4 to x+4, y-1 to y+1, k-4 to k+4)
     */
    private boolean isWaterNearby(World par1World, int par2, int par3, int par4)
    {
        for (int l = par2 - 4; l <= par2 + 4; ++l)
        {
            for (int i1 = par3 - 1; i1 <= par3 + 1; ++i1)
            {
                for (int j1 = par4 - 4; j1 <= par4 + 4; ++j1)
                {
                    if (par1World.getBlockMaterial(l, i1, j1) == Material.water)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
