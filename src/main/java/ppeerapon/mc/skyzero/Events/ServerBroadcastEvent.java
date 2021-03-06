package ppeerapon.mc.skyzero.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.*;

public class ServerBroadcastEvent extends Event implements Cancellable {

    private final Player player;
    private final String message;

    private boolean cancelled;
    private static final HandlerList HANDLER_LIST = new HandlerList();

    public ServerBroadcastEvent(Player player, String message) {
        this.player = player;
        this.message = message;
    }

    public Player getPlayer() {
        return player;
    }

    public String getMessage() {
        return message;
    }

    public static HandlerList getHandlerList() { return HANDLER_LIST; }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }

}
