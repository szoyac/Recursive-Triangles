/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangles;

/**
*Author: Stephen Zoyac
*Date: 11/1/20
*Fall 2020
*Recursive Triangles
*This class uses a recursive loop to find the area and perimeter of 
* three valid sides to a triangle. A valid side is defined by one side not 
* being grader than the sum of the two other sides.
 */
import java.util.Scanner;

public class Triangles {

    private float sA, sB, sC = 0;
    private float s;
    private float per;
    private float area;
    /**
     * Called by getInput, finds the side, perimeter, and area of 
     * a valid triangle.
     * Will use indirect recursion to call getInput again to continue a loop.
     * @param sA
     * @param sB
     * @param sC
     */

    public void Triangles(float sA, float sB, float sC) {
        s = (sA + sB + sC) / 2;
        per = (sA + sB + sC);
        area = (float) Math.pow((s * (s - sA) * (s - sB) * (s - sC)), .5);
        System.out.println("perimeter = " + per + ", area = " + area);
        getInput();

    }
    
    /**
     * Asks user to enter three valid side lengths of the triangle. If valid
     * the sides will call the Triangles method to print the perimeter, and 
     * area, and will call this method again. If not, it will use direct 
     * recursion to call itself. The recursive loop will only end if side A is
     * -1.
     */

    public void getInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter three valid side lengths");
        System.out.print("Enter -1 to exit: ");
        sA = scan.nextFloat();
        if (sA < 0) {
            System.exit(0);
        }
        sB = scan.nextFloat();
        sC = scan.nextFloat();

        if (sA > sB + sC || sB > sA + sC || sC > sA + sB) {
            getInput();
        } else {
            Triangles(sA, sB, sC);
        }

    }

}
