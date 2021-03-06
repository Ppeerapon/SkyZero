package ppeerapon.mc.skyzero;

import org.bukkit.ChatColor;

public enum Rank {

    OWNER("Owner", ChatColor.AQUA),
    ADMIN("Admin", ChatColor.RED),
    MEMBER("Member", ChatColor.GREEN),
    GUEST("Guest", ChatColor.GRAY);

    private final String name;
    private final ChatColor chatColor;

    private Rank(String name, ChatColor chatColor) {
        this.name = name;
        this.chatColor =chatColor;
    }

    public String getName() { return name; }
    public ChatColor getChatColor() { return chatColor; }

}
