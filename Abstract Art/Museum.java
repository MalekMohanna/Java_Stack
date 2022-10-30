import java.util.ArrayList;

// inside of Museum.java
public class Museum {
    public static void main(String[] args) {
        // TODO: create paintings and sculptures here

        // Inside of a class called Museum create 3 Paintings and 2 Sculptures
        // and add them to the museum.

        // Ninja Bonus: store the paintings and sculptures inside of an ArrayList called
        // museum
        ArrayList<Art> museum = new ArrayList<Art>();

        // Create 3 instances of Painting
        Painting painting1 = new Painting();
        Painting painting2 = new Painting();
        Painting painting3 = new Painting();

        // Create 2 instances of Scupture
        Sculpture sculpture1 = new Sculpture();
        Sculpture sculpture2 = new Sculpture();

        painting1.title = "The Scream";
        painting1.author = "Edvard Munch";
        painting1.description = "The Scream is a horror picture painted by Edvard Munch in 1893.";
        painting1.setPaintType("Acrylic");

        museum.add(painting1);

        painting2.title = "The Starry Night";
        painting2.author = "Vincent van Gogh";
        painting2.description = "The Starry Night is a painting by the Dutch post-impressionist painter Vincent van Gogh.";
        painting2.setPaintType("Oil");

        museum.add(painting2);

        painting3.title = "The Persistence of Memory";
        painting3.author = "Leonardo da Vinci";
        painting3.description = "The Persistence of Memory is a painting by the Italian artist Leonardo da Vinci.";
        painting3.setPaintType("Watercolor");
        museum.add(painting3);

        sculpture1.title = "The Thinker";
        sculpture1.author = "Banksy";
        sculpture1.description = "The Thinker is a sculpture by the British artist Banksy.";
        sculpture1.setMaterial("Bronze");

        museum.add(sculpture1);

        sculpture2.title = "David";
        sculpture2.author = "Leonardo da Vinci";
        sculpture2.description = "David is a sculpture by the Italian artist Leonardo da Vinci.";
        sculpture2.setMaterial("Porcelain");

        museum.add(sculpture2);

        // Ninja Bonus: use the viewArt() method of all of the artworks in the museum in
        // a random order
        // Iterate through the museum and print out the information about each piece of
        // art randomly.
        for (int i = 0; i < museum.size(); i++) {
            int random = (int) (Math.random() * museum.size());
            Art art = museum.get(random);
            System.out.println("");
            art.viewArt();
        }

    }
}