package edu.isu.cs3321.javalin;

import io.javalin.Javalin;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import static io.javalin.apibuilder.ApiBuilder.*;

public class App2 {

    public static void main(String[] args) {
        QueuedThreadPool queuedThreadPool = new QueuedThreadPool(200, 8, 60000);

        Javalin app = Javalin.create(config -> {
            config.server(() -> {
                Server server = new Server(queuedThreadPool);
                return server;
            });
        }).start(7000);

        app.routes(() -> {
            get("/", ctx -> ctx.html("<body><h1>Hello World</h1></body>"));
        });
    }
}
