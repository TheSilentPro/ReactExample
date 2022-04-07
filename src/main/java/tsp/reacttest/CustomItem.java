package tsp.reacttest;

import org.bukkit.NamespacedKey;
import org.bukkit.event.player.PlayerInteractEvent;
import tsp.react.reactable.ReactItem;

public class CustomItem extends ReactItem {

    public CustomItem() {
        super(new NamespacedKey(TestPlugin.getInstance(), "custom_item"));
    }

    @Override
    public void onInteract(PlayerInteractEvent event) {
        event.getPlayer().sendMessage("Right clicked custom item!");
    }

}
