# personal-narrative-project

## UML Diagram
<img width="1318" height="772" alt="Copy of Unit 5 - UML Diagram" src="https://github.com/user-attachments/assets/53465987-92eb-4eea-97bd-370de8115c6e" />

## Video Demo
https://github.com/user-attachments/assets/5ae4adf5-7045-4eb5-9b93-91df144a0527

## Story Description
The first scene shows some of my favorite things. This includes my favorite colors, favorite beverages, and favorite foods. It displays the image and adds a different filter for each category. It also displays captions for the images. This is also the same for the second scene, but instead it shows my hobbies, activities and interests. The second scene has a random text color. The first scene has a random text height to use.

## Image Filter
The image filter class contains multiple methods that manipulate the pixels in the image. This class extends ImagePlus, and uses inherited methods such as getImagePixels() and getPixelsFromImage() to apply filters. The pixelate filter works by dividing the image pixels into regions and sets each pixel in the region to the average color in the region. The negative filter works by getting the values of all the pixels and setting them to 255 minus that value. The zero red, blue, and green filter work by setting red, blue, or green to 0 for every pixel. The mean filter works by getting all the pixels in a 3x3 grid for every pixel and setting the pixel to the average color of the pixels.
