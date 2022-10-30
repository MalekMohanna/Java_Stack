// Create a Sculpture class that inherits Art and has an additional member variable material
// inside of Sculpture.java
public class Sculpture extends Art {
    // TODO: implement Sculpture class

    // The Sculpture class should inherit from Art,
    // and it should contain a new member variable called
    // material (ex. Marble, Bronze, Porcelain, etc.).

    private String material;

    // The viewArt() method should be implemented in the child classes
    // and will be used to print information about the artwork.
    public void viewArt() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Description: " + description);
        System.out.println("Material: " + material);
    }

    // getters and setters
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

}