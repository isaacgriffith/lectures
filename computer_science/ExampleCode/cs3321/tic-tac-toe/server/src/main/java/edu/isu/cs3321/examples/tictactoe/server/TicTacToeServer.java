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

import edu.isu.cs3321.examples.tictactoe.server.handlers.*;
import io.javalin.Javalin;
import lombok.Getter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import java.net.Inet4Address;
import java.net.NetworkInterface;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;

public class TicTacToeServer {

    @Getter
    private Javalin app;

    public TicTacToeServer() {
        ServerContext context = ServerContext.instance();
        QueuedThreadPool queuedThreadPool = new QueuedThreadPool(200, 8, 60000);

        app = Javalin.create(config ->
                config.server(() -> new Server(queuedThreadPool)));

        app.routes(() -> {
            get("/api/status", new StatusHandler(context));
            get("/api/state", new GameStateHandler(context));
            post("/api/move", new MoveHandler(context));
            post("/api/new-game", new NewGameHandler(context));
            post("/api/join-game", new JoinGameHandler(context));
            get("/api/gamelist", new GameListHandler(context));
            post("/api/watch-game", new WatchGameHandler(context));
            post("/api/forfeit-game", new ForfeitGameHandler(context));
            post("/api/leave-game", new LeaveGameHandler(context));
            post("/api/create-player", new CreatePlayerHandler(context));
        });
    }

    public static void main(String[] args) {
        CLI.INST.init();
        CLI.INST.parseArgs(args);

        try {
            new TicTacToeServer().getApp().start(CLI.INST.getPort());
        } catch (Exception e) {}
    }
}