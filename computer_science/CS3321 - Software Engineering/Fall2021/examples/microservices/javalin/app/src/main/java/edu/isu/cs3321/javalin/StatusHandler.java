package edu.isu.cs3321.javalin;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class StatusHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        ctx.json(Map.of("status", true));
    }
}
