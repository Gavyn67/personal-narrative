import org.code.theater.*;
import org.code.media.*;

public class SceneOne extends Scene {

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
  public SceneOne(FilteredImage[][] images, String[][] captions) {
    this.images = images;
    this.captions = captions;
  }

  /*
   * Draws the entire scene, with culture, beverages, and food
   */
  public void drawScene() {
    setTextColor("black");
    drawColors();
    drawBeverages();
    drawFood();
  }

  /*
   * Returns a random text height between 20 and 50.
   */
  public int getRandomTextHeight() {
    return (int) (Math.floor(Math.random() * 30 + 20));
  }

  // Displays the color images/captions
  public void drawColors() {
    setTextHeight(getRandomTextHeight());
    for (int i = 0; i < images[0].length; i++) {
      clear("white");
      FilteredImage image = images[0][i];

      drawImage(image, 0, 0, 400, 400, 0);
      drawText(captions[0][i], 25, 200);
      pause(1);
      
      image.applyMeanFilter();
      
      drawImage(image, 0, 0, 400, 400, 0);
      pause(1);
    }
  }

  // Displays the beverage images/captions
  public void drawBeverages() {
    setTextHeight(getRandomTextHeight());
    for (int i = 0; i < images[1].length; i++) {
      clear("white");
      FilteredImage image = images[1][i];

      drawImage(image, 0, 0, 400, 400, 0);
      drawText(captions[1][i], 25, 200);
      pause(1);
      
      image.zeroRed();
      
      drawImage(image, 0, 0, 400, 400, 0);
      pause(1);
    }
  }

  // Displays the food images/captions
  public void drawFood() {
    setTextHeight(getRandomTextHeight());
    for (int i = 0; i < images[2].length; i++) {
      clear("white");
      FilteredImage image = images[2][i];

      drawImage(image, 0, 0, 400, 400, 0);
      drawText(captions[2][i], 25, 200);
      pause(1);
      
      image.zeroBlue();
      
      drawImage(image, 0, 0, 400, 400, 0);
      pause(1);
    }
  }
}