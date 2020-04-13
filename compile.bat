@ECHO OFF

echo "Prepare environment..."
mkdir temp
echo "Compiling..."
cd src/main/java/
javac -d ../../../temp it/matteoavanzini/game/goose/*.java
javac -d ../../../temp it/matteoavanzini/game/goose/action/*.java
javac -d ../../../temp it/matteoavanzini/game/goose/input/*.java
javac -d ../../../temp it/matteoavanzini/game/goose/exception/*.java
javac -d ../../../temp it/matteoavanzini/game/goose/model/*.java
javac -d ../../../temp it/matteoavanzini/game/goose/tile/*.java

echo "Packing..."
cd ../../../temp
jar cfe goose-1.0.jar it.matteoavanzini.game.goose.App it/matteoavanzini/game/goose/*.class it/matteoavanzini/game/goose/action/*.class it/matteoavanzini/game/goose/input/*.class it/matteoavanzini/game/goose/exception/*.class it/matteoavanzini/game/goose/model/*.class it/matteoavanzini/game/goose/tile/*.class

cd ..
cp temp/goose-1.0.jar .
RMDIR temp /S
echo "Done. Created file goose-1.0.jar"
echo "To execute program type: java -jar goose-1.0.jar"