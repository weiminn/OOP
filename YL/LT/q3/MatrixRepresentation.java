/*
* Name: Wei Minn
* Email ID: wei.minn.2018
*/

import java.util.*;

public class MatrixRepresentation {
    public static int countFriends(int[][] ary, String[] names, String target) {
        int i;
        for ( i = 0; i < names.length; i++) {
            if(names[i].equals(target)) break;
        }

        int count = 0;
        for (int j = 0; j < ary[i].length; j++) {
            if(ary[i][j] == 1) count++;
        }
        return count;
    }

    public static String[] commonFriends(int[][] ary, String[] names, String friend1, String friend2) {
        int i;
        for ( i = 0; i < names.length; i++) {
            if(names[i].equals(friend1)) break;
        }
        int j;
        for ( j = 0; j< names.length; j++) {
            if(names[j].equals(friend2)) break;
        }

        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();

        for (int a = 0; a < ary[i].length; a++) {
            if(ary[i][a] == 1) s1.add(names[a]);
        }
        for (int a = 0; a < ary[j].length; a++) {
            if(ary[j][a] == 1) s2.add(names[a]);
        }
        
        List<String> common = new ArrayList<>();

        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String n = i1.next();
            if(s2.contains(n)) {
                if(!common.contains(n)) common.add(n);
            }
        }
        Iterator<String> i2 = s2.iterator();
        while (i2.hasNext()) {
            String n = i2.next();
            if(s1.contains(n)) {
                if(!common.contains(n)) common.add(n);
            }
        }

        return common.toArray(new String[common.size()]);
    }

    public static Map<Integer, List<String>> getSociableStats(int[][] ary, String[] names) {
        Map<Integer, List<String>> toReturn = new HashMap<>();
        
        for (int i = 0; i < names.length; i++) {
            int countForI = 0;
            for (int j = 0; j < ary[i].length; j++) {
                if(ary[i][j] == 1) countForI++;
            }

            if(toReturn.containsKey(countForI)){
                toReturn.get(countForI).add(names[i]);
            } else {
                List<String> _list = new ArrayList<>();
                _list.add(names[i]);
                toReturn.put(countForI, _list);
            }
        }
        return toReturn;
    }

}