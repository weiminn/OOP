import java.util.*;

public class DVDUtility {

    public static DVD getMostExpensiveDVD(DVD[] dvds){
        if(dvds == null) return null;
        double uBound = Double.MIN_VALUE;
        int pos = -1;
        for (int i = 0; i < dvds.length; i++){
            if(dvds[i].getPrice() > uBound){
                pos = i;
            }
        }

        if(pos == -1) return null;
        return dvds[pos];
    }

    public static List<DVD> getDVDWithGenre(DVD[] dvds, String gen){
        if(dvds == null || gen == null) return null;
        if(dvds.length == 0) return null;

        List<DVD> toReturn = new ArrayList<>();

        for (int i = 0; i < dvds.length; i++){
            if(dvds[i].getGenre().equals(gen)){
                toReturn.add(dvds[i]);
            }
        }

        return toReturn;
    }

    public static List<DVD> getDVDWithPriceBetween(DVD[] dvds, int min, int max){
        List<DVD> toReturn = new ArrayList<>();

        for (int i = 0; i < dvds.length; i++){
            if(dvds[i].getPrice() > min && dvds[i].getPrice() < max){
                toReturn.add(dvds[i]);
            }
        }

        return toReturn;
    }

    public static List<DVD> getUniqueDVDs(DVD[] dvds1, DVD[] dvds2){
        if(dvds1 == null || dvds2 == null) return new ArrayList<>();

        Set<DVD> set = new HashSet<>();

        for (int i = 0; i < dvds1.length; i++){
            set.add(dvds1[i]);
        }

        for (int i = 0; i < dvds2.length; i++){
            set.add(dvds2[i]);                   
        }

        return new ArrayList<>(set);
    }

    public static String[] getDVDTitlesInYear(DVD[] dvds, int year){
        if(dvds == null) return null;
        if(dvds.length == 0) return null;

        List<String> toReturn = new ArrayList<>();

        for (int i = 0; i < dvds.length; i++){
            if(dvds[i].getYear() == year){
                toReturn.add(dvds[i].getTitle());
            }
        }

        return toReturn.toArray(new String[toReturn.size()]);
    }


    
}
