public class SearchCtrl {
    private InterestGroupDAO IGDM;

    public SearchCtrl() {
        IGDM = new InterestGroupDAO();
    }

    public Student searchPresident(String IGName, int year) {
        InterestGroup retrievedIG = IGDM.retrieve(IGName);
        if(retrievedIG != null){
            return retrievedIG.retrievePresidentInYear(year);
        }
        return null;
    }
}
