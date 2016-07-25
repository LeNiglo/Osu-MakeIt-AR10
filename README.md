# Osu-MakeIt-AR10
JavaFX Application for Osu! players. Make any beatmap the way you want.

## Installation

### Standard

A JAR will be available at some point. For the moment, please refer to the Developer method just below.

### Developer (easy)

Using IntelliJ IDEA:

#### Quick Build

 - click on "Edit Configurations"
 - add a new Application and define `com.lefrantguillaume.ar10.Main` as the Main Class
 - you can now run the application from IntelliJ

You can't use the application without IntelliJ, if you want to, read the next section.

#### Building JAR

 - open the project
 - go to "Project Structure" => "Artifacts"
 - add a new "Jar from module with dependencies" and define `com.lefrantguillaume.ar10.Main` as the Main Class
 - don't forget to check the "Build on make" checkbox
 - finally, build the project (CTRL + F9)

A Jar is now available in the out/artifacts/Osu_MakeIt_AR10_jar folder. You can use it everywhere, anytime.

## Usage

 - Load the beatmap you want to modify using the "OPEN" button. Beatmaps are located in your Osu! folder in the /Songs folder and named "Artist - Song (Mapper)[Difficulty].osu"
 - Change what you want to make it harder or easier ([The Big Black](https://osu.ppy.sh/s/41823) with 1 of HP Drain is pretty easy)
 - Save the changes using the "SAVE" button. It creates a new difficulty called "original made AR10". You may need to restart your game or use F5 (quite long) to see the new beatmap.

## Notes

 - You **WILL NOT** get any PP for a play using the application ! It creates a **NEW** difficulty which isn't rated.
 - [Link to the Game](https://osu.ppy.sh)
 - [Link to my Profile](https://osu.ppy.sh/u/LeNiglo)
 - If you want more features, feel free to [create an issue](https://github.com/LeNiglo/Osu-MakeIt-AR10/issues/new) or to [send me a Private Message](https://osu.ppy.sh/forum/ucp.php?i=pm&mode=compose&u=2312861)
 - Love to Peppy-sama.  <3