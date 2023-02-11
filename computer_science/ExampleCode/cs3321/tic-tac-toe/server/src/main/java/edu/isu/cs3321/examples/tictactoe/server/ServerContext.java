/**
 * Copyright 2021 Isaac D. Griffith
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package edu.isu.cs3321.examples.tictactoe.server;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import edu.isu.cs3321.examples.tictactoe.library.Game;
import edu.isu.cs3321.examples.tictactoe.library.Player;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ServerContext {

    private List<Game> games;
    private List<Player> players;

    private static final class InstanceContainer {
        private static final ServerContext INSTANCE = new ServerContext();
    }

    private ServerContext() {}

    public static ServerContext instance() {
        return InstanceContainer.INSTANCE;
    }

    public List<Game> getGameList() {
        return ImmutableList.copyOf(games);
    }

    public void createNewGame(String playerId) {
        if (playerId != null && !playerId.isBlank()) {
            Game game = new Game();
            game.addPlayer(findPlayer(playerId));
        }
    }

    public void joinGame(String gameId, String playerId) {
        if (gameId != null && !gameId.isBlank() && playerId != null && !playerId.isBlank()) {
            Game game = findGame(gameId);
            Player player = findPlayer(playerId);
            game.addPlayer(player);
        }
    }

    public void watchGame(String gameId, String playerId) {
        if (gameId != null && !gameId.isBlank() && playerId != null && !playerId.isBlank()) {
            Game game = findGame(gameId);
            Player player = findPlayer(playerId);
            game.addWatcher(player);
        }
    }

    public void leaveGame(String gameId, String playerId) {
        if (gameId != null && playerId != null) {
            Game game = findGame(gameId);
            Player player = findPlayer(playerId);
            if (game != null && player != null) {
                game.removeWatcher(player);
            }
        }
    }

    public String createPlayer(String firstName, String lastName) {
        if (firstName != null && !firstName.isBlank() && lastName != null && !lastName.isBlank()) {
            Player player = players.stream().filter(item -> item.firstName().equals(firstName) && item.lastName().equals(lastName)).findFirst().orElse(null);
            String id = player != null ? player.id() : UUID.randomUUID().toString();
            if (player != null)
                players.add(new Player(firstName, lastName, id));
            return id;
        } else {
            return "";
        }
    }

    public Map<String, String> getGameState(String gameId) {
        if (gameId != null && !gameId.isBlank()) {
            Game game = findGame(gameId);
            if (game != null)
                return game.getState();
        }
        return Maps.newHashMap();
    }

    public void forfeitGame(String gameId, String playerId) {
        Game game = findGame(gameId);
        Player player = findPlayer(playerId);
        game.removePlayer(player);
    }

    public void move(String gameId, String playerId, int row, int col) {
        Game game = findGame(gameId);
        Player player = findPlayer(playerId);
        game.makeMove(player, row, col);
    }

    private Game findGame(String gameId) {
        return games.stream().filter(item -> item.getGameId().equals(gameId)).findFirst().orElse(null);
    }

    private Player findPlayer(String playerId) {
        return players.stream().filter(item -> item.id().equals(playerId)).findFirst().orElse(null);
    }
}
