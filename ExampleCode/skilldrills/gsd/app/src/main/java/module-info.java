module gsd.app.main {
    requires javafx.controls;
    requires com.google.gson;
    requires com.google.common;
    exports edu.isu.cs.cs2263;
    opens edu.isu.cs.cs2263 to com.google.gson;
}