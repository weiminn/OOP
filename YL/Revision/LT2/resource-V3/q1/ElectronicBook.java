import java.util.Arrays;

public class ElectronicBook extends Book implements Comparable<ElectronicBook>{

    private MyDate eDate;
    public ElectronicBook(String title, int price, String[] authors, MyDate expiryDate) {
        super(title, price, authors);
        this.eDate = expiryDate;
    }

    public MyDate getExpiryDate() {
        return eDate;
    }

    @Override
    public int getPriceInCents() {
        return (int) (super.getPriceInCents() * ((double) 7/9));
    }


    @Override
    public int compareTo(ElectronicBook o) {
        // TODO Auto-generated method stub
        
        if(getTitle().compareTo(o.getTitle()) != 0) return getTitle().compareTo(o.getTitle());

        Arrays.sort(getAuthors());
        Arrays.sort(o.getAuthors());

        int i = 0;
        while(i < getAuthors().length && i < o.getAuthors().length){
            if (getAuthors()[i].compareTo(o.getAuthors()[i]) != 0) return getAuthors()[i].compareTo(o.getAuthors()[i]);
            i++;
        }

        return getExpiryDate().compareTo(o.getExpiryDate());
                
        
    }

    // @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof ElectronicBook)) return false;

        ElectronicBook b = (ElectronicBook) obj;
         
        return super.equals(b) && b.getExpiryDate().equals(this.getExpiryDate());

    }

    @Override
    public String toString() {
        return String.format("%s : %s", getTitle(), eDate.toString());
    }



}
