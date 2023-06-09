package com.wordsmith123.tictactoeplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandExecutor implements CommandExecutor {
    private Game game;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be run by a player.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            // Start a new game
            game = new Game();
            player.sendMessage("Started a new game of Tic Tac Toe. Use /tictactoe <position> to make a move.");
            player.sendMessage(game.getBoard());
        } else {
            // Make a move
            if (game == null) {
                player.sendMessage("No game in progress. Use /tictactoe to start a new game.");
                return true;
            }

            try {
                int position = Integer.parseInt(args[0]);
                if (!game.makeMove(position)) {
                    player.sendMessage("Invalid move. Please try again.");
                    return true;
                }
                player.sendMessage(game.getBoard());
                if (game.isGameOver()) {
                    player.sendMessage("Game over!");
                    game = null;
                }
            } catch (NumberFormatException e) {
                player.sendMessage("Invalid position. Please enter a number between 0 and 8.");
            }
        }

        return true;
    }
}
