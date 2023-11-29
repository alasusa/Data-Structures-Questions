/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author soblab
 */
import java.util.*;
/**
 *
 * @author soblab
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ArrayStack myStack  =new ArrayStack(10);
      for(int i=0; i<=myStack.size()-1;i++){
          Random rand = new Random();
          int randnum = rand.nextInt(100);
         myStack.push(randnum);
      }
       myStack.listAll();
    }
    
}
