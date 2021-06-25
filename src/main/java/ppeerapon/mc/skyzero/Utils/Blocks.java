//package ppeerapon.mc.skyzero.Utils;
//
//import net.minecraft.server.v1_16_R3.BlockPosition;
//import net.minecraft.server.v1_16_R3.ChunkSection;
//import net.minecraft.server.v1_16_R3.IBlockData;
//import org.bukkit.World;
//import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
//
//public class Blocks {
//
//    public static void setBlockLoaded(World world, int x, int y, int z, int blockId, byte data, boolean applyPhysics) {
//        net.minecraft.server.v1_16_R3.World nmsWorld = ((CraftWorld) world).getHandle();
//        BlockPosition bp = new BlockPosition(x, y, z);
//        IBlockData ibd = net.minecraft.server.v1_16_R3.Block.getByCombinedId(blockId + (data << 12));
//        nmsWorld.setTypeAndData(bp, ibd, applyPhysics ? 3 : 2);
//    }
//
//    public static void setBlock(World world, int x, int y, int z, int blockId, byte data, boolean applyPhysics) {
//        net.minecraft.server.v1_16_R3.World nmsWorld = ((CraftWorld) world).getHandle();
//        net.minecraft.server.v1_16_R3.Chunk nmsChunk = nmsWorld.getChunkAt(x >> 4, z >> 4);
//        IBlockData ibd  = net.minecraft.server.v1_16_R3.Block.getByCombinedId(blockId + (data << 12));
//
//        ChunkSection cs = nmsChunk.getSections()[y >> 4];
//        if (cs == nmsChunk.a()) {
//            cs = new ChunkSection(y >> 4 << 4);
//            nmsChunk.getSections()[y >> 4] = cs;
//        }
//        if (applyPhysics) {
//            cs.getBlocks().setBlock(x & 15, y & 15, z & 15, ibd);
//        } else {
//            cs.getBlocks().b(x & 15, y & 15, z & 15, ibd);
//        }
//    }
//
//}
