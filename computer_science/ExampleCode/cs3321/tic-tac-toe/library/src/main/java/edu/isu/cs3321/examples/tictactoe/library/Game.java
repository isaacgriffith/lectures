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
package edu.isu.cs3321.examples.tictactoe.library;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@EqualsAndHashCode(of = {"gameId"}, callSuper = false)
public class Game {

    private Map<Player, Character> players;
    private List<Player> watchers;
    private char[][] board;
    boolean winner;
    Player winningPlayer;
    Player currentPlayer;

    @Getter
    private String gameId;

    public void Game() {
        players = Maps.newHashMap();
        watchers = Lists.newArrayList();
        gameId = UUID.randomUUID().toString();
        board = new char[][]{{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
    }

    public void addWatcher(Player watcher) {
        if (watcher != null && !watchers.contains(watcher))
            watchers.add(watcher);
    }

    public void removeWatcher(Player watcher) {
        if (watcher != null && watchers.contains(watcher))
            watchers.remove(watcher);
    }

    public void addPlayer(Player player) {
        if (players.containsKey(player))
            return;

        switch (players.size()) {
            case 0 -> {
                players.put(player, 'O');
                currentPlayer = player;
            }
            case 1 -> players.put(player, 'X');
        }
    }

    public void removePlayer(Player player) {
        if (player != null && players.containsKey(player)) {
            players.remove(player);
            winningPlayer = Lists.newArrayList(players.keySet()).get(0);
            winner = true;
        }
    }

    public void makeMove(Player player, int row, int col) {
        if (player != null && row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
            char mark = players.get(player);
            board[row][col] = mark;
        }
        checkWinCondition();
        updateCurrentPlayer(player);
    }

    private void checkWinCondition() {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && (board[i][0] == 'X' || board[i][0] == 'O')) {
                winner = true;
                winningPlayer = findPlayer(board[i][0]);
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && (board[0][i] == 'X' || board[0][i] == 'O')) {
                winner = true;
                winningPlayer = findPlayer(board[0][i]);
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && (board[0][0] == 'X' || board[0][0] == 'O')) {
            winner = true;
            winningPlayer = findPlayer(board[0][0]);
        } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && (board[2][0] == 'X' || board[2][0] == 'O')) {
            winner = true;
            winningPlayer = findPlayer(board[0][2]);
        } else {
            winner = false;
            winningPlayer = null;
        }
    }

    private Player findPlayer(char ch) {
        return players.entrySet().stream().filter(entry -> entry.getValue() == ch).findFirst().map(Map.Entry::getKey).orElse(null);
    }

    private void updateCurrentPlayer(Player player) {
        char ch = players.get(player);
        ch = ch == 'X' ? 'O' : 'X';
        currentPlayer = findPlayer(ch);
    }

    public Map<String, String> getState() {
        Map<String, String> state = Maps.newHashMap();
        if (winner) {
            state.put("winner", String.format("%s %s", winningPlayer.firstName(), winningPlayer.lastName()));
        }
        state.put("currentPlayer", currentPlayer.id());
        state.put("board", Arrays.deepToString(board));

        return state;
    }
}
