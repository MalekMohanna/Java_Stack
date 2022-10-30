// Create a Painting class that inherits Art and has an additional member variable paintType
// inside of Painting.java
public class Painting extends Art {
    // TODO: implement Painting class

    // The painting class should inherit from Art,
    // and it should also contain a new member variable called
    // paintType (ex. Oil, Watercolor, Acrylic, etc.).

    private String paintType;

    // The viewArt() method should be implemented in the child classes
    // and will be used to print information about the artwork.
    public void viewArt() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Description: " + description);
        System.out.println("Paint Type: " + paintType);
    }

    // getters and setters
    public String getPaintType() {
        return paintType;
    }

    public void setPaintType(String paintType) {
        this.paintType = paintType;
    }

    
}