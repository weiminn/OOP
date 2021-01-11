import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * This class help to sort Staffs.
 */
public class Sorter implements Comparator<Staff> {

    private Criterion[] criteria;

    Map<String, Integer> classComp = new HashMap<>();

    public Sorter(Criterion[] criteria) {
        if(criteria == null ||criteria.length == 0) throw new IllegalArgumentException("invalid criteria");
        this.criteria = criteria;

        classComp.put("Secretary", 3);
        classComp.put("TA", 2);
        classComp.put("Faculty", 1);
    }


    /**
     * Compare 2 Staffs by the sorting criteria.
     *
     * @param e1 Staff object
     * @param e2 Staff object
     * @return If e1 is less than, equals or more than e2, return a negative
     * value, zero or positive value respectively. If sorting criteria is null or
     * empty, it returns zero.
     */
    @Override
    public int compare(Staff e1, Staff e2) {

        for (int i = 0; i < criteria.length; i++){

            if(criteria[i].getField() == Criterion.NAME){

                if(e1.getName().compareTo(e2.getName()) !=0 ) {
                    if(!criteria[i].isAscending()) return -e1.getName().compareTo(e2.getName());
                    return e1.getName().compareTo(e2.getName());
                };

            } else if(criteria[i].getField() == Criterion.YEAR){
                if(e1 instanceof TA && e2 instanceof TA){

                    TA t1 = (TA) e1;
                    TA t2 = (TA) e2;

                    if(Integer.compare(t1.getYear(), t2.getYear()) != 0) {
                        if(!criteria[i].isAscending()) return -Integer.compare(t1.getYear(), t2.getYear());
                        return Integer.compare(t1.getYear(), t2.getYear());
                    };
                }
            } else if(criteria[i].getField() == Criterion.SCHOOL){
                if(e1.getSchool().compareTo(e2.getSchool()) != 0 ) {
                    if(!criteria[i].isAscending()) return -e1.getSchool().compareTo(e2.getSchool());
                    return e1.getSchool().compareTo(e2.getSchool());
                }
            } else {
                if(Integer.compare(classComp.get(e1.getClass().getSimpleName()), classComp.get(e2.getClass().getSimpleName())) !=0 ) {
                    if(!criteria[i].isAscending()) return -Integer.compare(classComp.get(e1.getClass().getSimpleName()), classComp.get(e2.getClass().getSimpleName()));
                    return Integer.compare(classComp.get(e1.getClass().getSimpleName()), classComp.get(e2.getClass().getSimpleName()));
                }
            }
        }
        return 0;
    }

    /**
     * Sort Staffs.
     * @param Staffs List of Staff objects to be sorted.
     */
    public void sort(Staff[] staffs) {
        Collections.sort(Arrays.asList(staffs), this);
    }
}
