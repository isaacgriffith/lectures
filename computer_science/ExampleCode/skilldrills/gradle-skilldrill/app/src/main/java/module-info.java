module gradle.skilldrill.app.main {
    requires javafx.controls;
    requires com.google.gson;
    requires com.google.common;
    requires static lombok;
    exports edu.isu.cs.cs2263;
    opens edu.isu.cs.cs2263 to com.google.gson;
}