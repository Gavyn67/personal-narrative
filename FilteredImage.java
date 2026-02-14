import org.code.theater.*;
import org.code.media.*;

public class FilteredImage extends ImagePlus {

  public FilteredImage(String filename) {
    super(filename);
  }

  public void pixelate(int gridSize) {
    /* ----------------------------------- TO DO -----------------------------------
     * ✅ Traverse each row of pixels by the gridSize amount (instead of by 1), then
     * traverse each column of pixels by the gridSize amount (instead of by 1). Get
     * the average red, green, and blue values of the pixels in that region, and
     * set each red, green, and blue values in that region to the averages.
     * -----------------------------------------------------------------------------
     */
    // Get the array of pixels
    Pixel[][] pixels = getImagePixels();

    // Traverse over all pixel regions. Increment by gridSize on both axes to enter next "region"
    for (int i = 0; i < pixels.length; i+= gridSize) {
      for (int j = 0; j < pixels[0].length; j+= gridSize) {

        // (lastRow, lastColumn) indicates bottom right, which is the last visited pixel in the region
        // Math.min is used to ensure iteration is not outside of bounds
        // Get the last row in each region
        int lastRow = Math.min(pixels.length - 1, i + gridSize - 1);
        // Get the last column in each region
        int lastColumn = Math.min(pixels[0].length - 1, j + gridSize - 1);

        // Setup variables to calculate average color in the region
        int totalRed = 0;
        int totalGreen = 0;
        int totalBlue = 0;
        int totalPixels = 0;
        
        // Iterate over all pixels in the pixel region to calculate average color
        for (int k = lastRow - gridSize + 1; k <= lastRow; k++) {
          for (int l = lastColumn - gridSize + 1; l <= lastColumn; l++) {
            // Increment total pixels
            totalPixels += 1;

            // Add the seperate color values of the pixel to the totals
            totalRed += pixels[k][l].getRed();
            totalGreen += pixels[k][l].getGreen();
            totalBlue += pixels[k][l].getBlue();
          }
        }

        // Iterate over all pixels in the pixel region again, this time setting the colors with the saved values
        for (int k = lastRow - gridSize + 1; k <= lastRow; k++) {
          for (int l = lastColumn - gridSize + 1; l <= lastColumn; l++) {

            // Calculate average colors by dividing total color values by total pixels
            int averageRed = totalRed / totalPixels;
            int averageGreen = totalGreen / totalPixels;
            int averageBlue = totalBlue / totalPixels;

            // Create new color object to set the pixel to
            Color averageColor = new Color(averageRed, averageGreen, averageBlue);
            // Set the color
            pixels[k][l].setColor(averageColor);
          }
        }
      }
    }
  }

    public void makeNegative() {
    /* ----------------------------------- TO DO -----------------------------------
     * ✅ Get the pixels from the image, then traverse the 2D array of pixels. Set
     * the red, green, and blue color values of each Pixel object to the result of
     * 255 minus the current values.
     * -----------------------------------------------------------------------------
     */
    Pixel[][] pixels = getImagePixels();

    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        Pixel pixel = pixels[i][j];
        int red = 255 - pixel.getRed();
        int blue = 255 - pixel.getBlue();
        int green = 255 - pixel.getGreen();
        pixel.setColor(new Color(red, green, blue));
      }
    }
  }

    public void zeroRed() {
    Pixel[][] pixels = getImagePixels();
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        pixels[i][j].setRed(0);
      }
    }
  }

  public void zeroBlue() {
    Pixel[][] pixels = getImagePixels();
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        pixels[i][j].setBlue(0);
      }
    }
  }

  public void zeroGreen() {
    Pixel[][] pixels = getImagePixels();
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        pixels[i][j].setGreen(0);
      }
    }
  }

    public void applyMeanFilter() {
    Pixel[][] pixels = getImagePixels();
    Pixel[][] currentPixels = getPixelsFromImage();

    for (int i = 0; i < currentPixels.length; i++) {
      for (int j = 0; j < currentPixels[0].length; j++) {
        Pixel pixel = currentPixels[i][j];
        
        int topRow = clamp(i - 1, 0, currentPixels.length - 1);
        int bottomRow = clamp(i + 1, 0, currentPixels.length - 1);

        int leftCol = clamp(j - 1, 0, currentPixels[0].length - 1);
        int rightCol = clamp(j + 1, 0, currentPixels[0].length - 1);
        
        Pixel[][] grid = {
          {currentPixels[topRow][leftCol], currentPixels[topRow][j], currentPixels[topRow][rightCol]},
          {currentPixels[i][leftCol], currentPixels[i][j], currentPixels[i][rightCol]},
          {currentPixels[bottomRow][leftCol], currentPixels[bottomRow][j], currentPixels[bottomRow][rightCol]}
        };

        int total = 0;

        int totalRed = 0;
        int totalGreen = 0;
        int totalBlue = 0;
        
        for (Pixel[] row : grid) {
          for (Pixel gridPixel : row) {
            totalRed += gridPixel.getRed();
            totalGreen += gridPixel.getGreen();
            totalBlue += gridPixel.getBlue();
            total++;
          }
        }

        int averageRed = (int) (totalRed / total);
        int averageGreen = (int) (totalGreen / total);
        int averageBlue = (int) (totalBlue / total);

        pixel.setRed(averageRed);
        pixel.setGreen(averageGreen);
        pixel.setBlue(averageBlue);
      }
    }
    
  }

  public int clamp(int num, int min, int max) {
    if (num < min) {
      return min;
    }

    if (num > max) {
      return max;
    }

    return num;
  }
}