package me.amori.dominion.panel;

import me.amori.dominion.ClanType;
import org.avaeriandev.utils.Panel;
import org.avaeriandev.utils.PanelIcon;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ClanSelectionPanel extends Panel {

    public ClanSelectionPanel() {
        super("Clan Selection", 3);
        setupLayout();
    }
    private void setupLayout() {
        Map<Integer, PanelIcon> layout = new HashMap<>();

        layout.put(12, new PanelIcon("&c&lRaiding Clan", new ItemStack(Material.REDSTONE), new ClanSelectScript(ClanType.RAIDING)));
        layout.put(14, new PanelIcon("&5&lMining Clan", new ItemStack(Material.AMETHYST_SHARD), new ClanSelectScript(ClanType.MINING)));
        layout.put(16, new PanelIcon("&a&lFarming Clan", new ItemStack(Material.EMERALD), new ClanSelectScript(ClanType.FARMING)));

        this.loadLayout(layout);
    }
}
