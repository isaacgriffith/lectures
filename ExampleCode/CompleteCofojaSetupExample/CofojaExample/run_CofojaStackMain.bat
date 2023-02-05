@rmdir /S /Q target

@rem compile
@mkdir target\classes
javac -cp lib\cofoja.asm-1.3-20160207.jar -d target\classes src\main\java\cofoja\*.java 
@rem annotation processor works out of the box

@rem run
java -javaagent:lib\cofoja.asm-1.3-20160207.jar -cp target\classes cofoja.CofojaStackMain
