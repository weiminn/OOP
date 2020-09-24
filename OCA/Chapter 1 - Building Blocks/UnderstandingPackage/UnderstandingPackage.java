/**
 * UnderstandingPackage
*/

// currently in default unnamed package
// should only be used for throwaway code

import java.lang.*;
// imported by default

import java.util.*;
// doesn't import child packages; only classes
import java.util.Random;
// more specific path will take precedence during compilation

//compiler figures out which import is needed and extra imports doesn't slow down program

import java.util.Date;
import java.sql.*; // import java.sql.Date doesn't compile
// compiler chooses the more explicitly imported java.util.Date
// if need to use both, import one and use fully qualified name for the other.
// or import neither and use fully qualified name for both

public class UnderstandingPackage {

    public static void main(String[] args) {
        Random random = new Random();
    }

    
}