import org.code.theater.*;
import org.code.media.*;

public class SceneTwo extends Scene {

  // Instance Variables
  private FilteredImage[][] images; // Holds images grouped by category
  private String[][] captions; // Holds captions for each image

  /*
   * Constructor
   *
   * Preconditions:
   * - images is a 2D array of FilteredImage objects
   * - captions is a 2d array of Strings
   * - Both images and captions must have same dimensions
   *
   * Postconditions:
   * The instance variables are initialized
   */
  public SceneTwo(FilteredImage[][] images, String[][] captions) {
    this.images = images;
    this.captions = captions;
  }

  /*
   * Draws the entire scene, with hobbies, activities, and interests
   */
  public void drawScene() {
    setTextHeight(60);
    drawHobbies();
    drawActivities();
    drawInterests();
  }

  /*
   * Returns a random text color.
   */
  public String getRandomTextColor() {
    String[] colors = {"red", "orange", "yellow", "green", "blue", "pink", "purple"};
    int randomIndex = (int) (Math.random() * colors.length);
    return colors[randomIndex];
  }

  // Displays the hobby image/captions
  public void drawHobbies() {
    setTextColor(getRandomTextColor());
    for (int i = 0; i < images[0].length; i++) {
      clear("white");
      FilteredImage image = images[0][i];

      drawImage(image, 0, 0, 400, 400, 0);
      drawText(captions[0][i], 25, 200);
      pause(1);
      
      image.pixelate(40);
      
      drawImage(image, 0, 0, 400, 400, 0);
      pause(1);
    }
  }

  // Displays the activity image/captions
  public void drawActivities() {
    setTextColor(getRandomTextColor());
    for (int i = 0; i < images[1].length; i++) {
      clear("white");
      FilteredImage image = images[1][i];

      drawImage(image, 0, 0, 400, 400, 0);
      drawText(captions[1][i], 25, 200);
      pause(1);
      
      image.makeNegative();
      
      drawImage(image, 0, 0, 400, 400, 0);
      pause(1);
    }
  }

  // Displays the interest image/captions
  public void drawInterests() {
    setTextColor(getRandomTextColor());
    for (int i = 0; i < images[2].length; i++) {
      clear("white");
      FilteredImage image = images[2][i];

      drawImage(image, 0, 0, 400, 400, 0);
      drawText(captions[2][i], 25, 200);
      pause(1);
      
      image.zeroGreen();
      
      drawImage(image, 0, 0, 400, 400, 0);
      pause(1);
    }
  }
}