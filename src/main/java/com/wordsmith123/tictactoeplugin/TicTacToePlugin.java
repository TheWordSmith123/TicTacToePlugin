package com.wordsmith123.tictactoeplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class TicTacToePlugin extends JavaPlugin {
    private Game game;

    @Override
    public void onEnable() {
        game = new Game();
        this.getCommand("tictactoe").setExecutor(new CommandExecutor(game));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
