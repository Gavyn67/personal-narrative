import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // ROWS: Favorite colors, favorite drinks, favorite foods
    // COLUMNS: Images that represent favorite stuff
    FilteredImage[][] firstImages = {
      {new FilteredImage("blue.png"), new FilteredImage("black.png")},
      {new FilteredImage("water.png"), new FilteredImage("gatorade.png")},
      {new FilteredImage("pizza.png"), new FilteredImage("steak.png")}
    };
    // Captions correspoding to the images
    String[][] firstCaptions = {
      {"Blue", "Black"},
      {"Water", "Gatorade"},
      {"Pizza", "Steak"}
    };

    // ROWS: Hobbies, activities, interests
    // COLUMNS: Images that represent stuff I do
    FilteredImage[][] secondImages = {
      {new FilteredImage("marchingsnare.png"), new FilteredImage("marchingquad.png")},
      {new FilteredImage("minecraft.png"), new FilteredImage("roblox.png")},
      {new FilteredImage("dumbell.png"), new FilteredImage("gamingpc.png")}
    };
    // Captions correspoding to the images
    String[][] secondCaptions = {
      {"Snare Drum", "Quad Drum"},
      {"Minecraft", "Roblox"},
      {"Gym", "Gaming"}
    };

    // Instantiate scenes
    SceneOne scene1 = new SceneOne(firstImages, firstCaptions);
    SceneTwo scene2 = new SceneTwo(secondImages, secondCaptions);
    
    // Call drawScene methods in each subclass
    scene1.drawScene();
    scene2.drawScene();
    
    // Play scenes in Theater, in order of arguments
    Theater.playScenes(scene1, scene2);


    

    
    
  }
}