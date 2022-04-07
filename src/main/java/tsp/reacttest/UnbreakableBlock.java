package tsp.reacttest;

import org.bukkit.NamespacedKey;
import org.bukkit.event.block.BlockBreakEvent;
import tsp.react.reactable.ReactBlock;

public class UnbreakableBlock extends ReactBlock {

    public UnbreakableBlock() {
        super(new NamespacedKey(TestPlugin.getInstance(), "unbreakable_block"));
    }

    @Override
    public void onBreak(BlockBreakEvent event) {
        event.setCancelled(true);
        event.getPlayer().sendMessage("Wha... how is this possible?");
    }

}
