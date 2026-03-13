name:
console application

compiling:
kotlinc main.kt engine.kt other_menu.kt -include-runtime -d main.jar
start:
java -jar main.jar