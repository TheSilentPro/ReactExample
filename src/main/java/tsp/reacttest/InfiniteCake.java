package tsp.reacttest;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import tsp.react.reactable.ReactBlock;

public class InfiniteCake extends ReactBlock {

    public InfiniteCake() {
        super(new NamespacedKey(TestPlugin.getInstance(), "infinite_cake"));
    }

    @Override
    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            event.getClickedBlock().setType(Material.CAKE);
        }
    }

}
