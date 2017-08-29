/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector.math;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Saurav
 */
public class VectorMath {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(System.nanoTime());
        
        ArrayList<Vector2> Vectors = new ArrayList<>();    //Array of Vectors that can be chosen
        
        
        //when debugging, make sure to use fewer values to confirm the
        //resultants and stuff because using all of the values takes about an
        //hour to run on my computer
        
        //I would recommend saving these assignments in a text file to cut the list
        //down to around 10 items for testing
        
        /*
        Adding all of the data
        */
        
        //The two vectors that we already have were pre-added in the resultant class
        Vectors.add(new Vector2(15,315));
        Vectors.add(new Vector2(20,120));
        Vectors.add(new Vector2(1,30));
        Vectors.add(new Vector2(2,225));
        Vectors.add(new Vector2(3,300));
        Vectors.add(new Vector2(4,150));
        Vectors.add(new Vector2(5,45));
        Vectors.add(new Vector2(21,240));
        Vectors.add(new Vector2(22,330));
        Vectors.add(new Vector2(23,45));
        Vectors.add(new Vector2(45,150));
        Vectors.add(new Vector2(5,300));
        Vectors.add(new Vector2(15,245));
        Vectors.add(new Vector2(25,30));
        Vectors.add(new Vector2(35,120));
        Vectors.add(new Vector2(45,315));
        Vectors.add(new Vector2(55,210));
        Vectors.add(new Vector2(10,60));
        Vectors.add(new Vector2(11,135));
        Vectors.add(new Vector2(12,330));
        Vectors.add(new Vector2(13,240));
        Vectors.add(new Vector2(14,45));
        Vectors.add(new Vector2(15,150));
        Vectors.add(new Vector2(31,300));
        Vectors.add(new Vector2(32,225));
        Vectors.add(new Vector2(33,240));
        Vectors.add(new Vector2(34,330));
        Vectors.add(new Vector2(35,135));
        Vectors.add(new Vector2(36,60));
        Vectors.add(new Vector2(2,30));
        Vectors.add(new Vector2(4,225));
        Vectors.add(new Vector2(6,300));
        Vectors.add(new Vector2(40,150));
        Vectors.add(new Vector2(10,315));
        Vectors.add(new Vector2(13,240));
        Vectors.add(new Vector2(5,90));
        Vectors.add(new Vector2(10,270));
        Vectors.add(new Vector2(15,0));
        Vectors.add(new Vector2(20,180));
        Vectors.add(new Vector2(20,90));
        Vectors.add(new Vector2(15,270));
        Vectors.add(new Vector2(10,0));
        
        
        
        int a = 8;
        for(Vector2 v : Vectors) {   //sets all of the ids to corresponding to our worksheet
            v.setid(a);
            a++;
        }
        
        
        
        
        /*
        Finding all combinations
        */
        
        ArrayList<Resultant> results = new ArrayList<>();   //Array of resultants (groups of 6 vectors, initial and five additional)
        
        //using all combinations of vectors to populate array of resultants
        //just think about how you would manually pick all groups of 5 from a list; I use the same algorithm
        for(int i = 0; i < Vectors.size()-4; i++) {
            for(int j = i + 1; j < Vectors.size()-3; j++) {
                for(int k = j + 1; k < Vectors.size()-2; k++) {
                    for(int l = k + 1; l < Vectors.size()-1; l++) {
                        for(int m = l + 1; m < Vectors.size(); m++) {
                            results.add(new Resultant(new Vector2[]{
                                Vectors.get(i), Vectors.get(j), Vectors.get(k), Vectors.get(l), Vectors.get(m)
                            }));
                        }
                    }
                }
            }
        }
        
        /*
        (probably where the problem lies)
        
        Displaying results on the screen in the format:
        vector#, vector#... = magnitude
        in ascending order of magnitude
        */
        ArrayList<Resultant> FinalResults = new ArrayList<>();   //will contain resultants asc. order
        
        
        int i,j;
        int n = results.size();

        /* advance the position through the entire array */
        /*   (could do j < n-1 because single element is also min element) */
        for (j = 0; j < n-1; j++) 
          {
            /* find the min element in the unsorted a[j .. n-1] */

            /* assume the min is the first element */
            int iMin = j;
            /* test against elements after j to find the smallest */
            for (i = j+1; i < n; i++) {
                /* if this element is less, then it is the new minimum */
                if (results.get(i).getMagnitude() < results.get(iMin).getMagnitude()) {
                    /* found new minimum; remember its index */
                    iMin = i;
                }
            }

            if(iMin != j) 
            {
                
                Collections.swap(results, j, iMin);
            }
        }
        
        
        /*
        Printing all of the resultant vectors in the "ascending order" (at least it's supposed to be)
        */
        for(Resultant r : results) {
            System.out.println(r);   //make sure to read docs in Resultant class
        }
        System.out.println(System.nanoTime());
    }
    
    
}