import java.util.Objects;

public class DVD {
    private String title;
    private String studio;
    private String genre;
    private double price;
    private int year;

    public DVD(String title, String studio, int year, String genre, double price) {
        this.title = title;
        this.studio = studio;
        this.genre = genre;
        this.price = price;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getStudio() {
        return studio;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    };

    @Override
    public boolean equals(Object obj) {
        DVD _d = (DVD) obj;
        return this.title.equals(_d.getTitle());
    };

    public String toString() {
        return "[title=" + title + ", studio=" + studio + ", genre=" + genre + ", price=" + price + ", year=" + year + "]";
    }
}
