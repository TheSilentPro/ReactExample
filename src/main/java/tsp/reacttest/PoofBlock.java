package tsp.reacttest;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.event.block.BlockPlaceEvent;
import tsp.react.reactable.ReactBlock;

public class PoofBlock extends ReactBlock {

    public PoofBlock() {
        super(new NamespacedKey(TestPlugin.getInstance(), "poof_block"));
    }

    @Override
    public void onPlace(BlockPlaceEvent event) {
        event.getBlockPlaced().getWorld().spawnParticle(Particle.CLOUD, event.getBlockPlaced().getLocation(), 2);
        event.getBlockPlaced().setType(Material.AIR);
        event.getPlayer().sendMessage("You placed a poof block! Wait... where did it go?");
    }

}
