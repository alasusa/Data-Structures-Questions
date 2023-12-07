package javaprefixstack;
import java.util.*;
/**
 *
 * @author aslas
 */
public class JavaPrefixStack {
Set<String> operatorsList = new HashSet<>(Arrays.asList("+","-","*","/"));    //create set of Operators for program to look for while going through scnr.nextline

    public boolean checkOperator(String inputItem){      //looks to see if a string of text includes on of the operator set
        return operatorsList.contains(inputItem);
        
        
    }   
    
    public int prefixEvaluate(String Operator, String leftNum, String rightNum){      //will evaulate the operator with the previous two pushed numbers and chooses operation with a switch statement
        int leftValue = Integer.parseInt(leftNum);
        int rightValue =Integer.parseInt(rightNum);
        
       switch(Operator) {
           case "+":
               return leftValue + rightValue;
           case "-":
               return leftValue - rightValue;
           case "*":
               return leftValue * rightValue;
           case "/":
               return leftValue / rightValue;
           default:
               System.out.println("Please input a correct operator: +,-,*,/.");
               return 0;
        }
        
    }
    
    public void createStack(String prefixExpression){                //creates a stack by using a for loop to push onto a prefix statement. It goes backwards as the operators need to be the last thing checked
        String[] valuesArray = prefixExpression.split(",");
        
        
        Stack<String> prefixStack = new Stack<>();
        for (int i=valuesArray.length-1;i>=0;i--){
            if (checkOperator(valuesArray[i])){
                String leftValue = prefixStack.pop();
                String rightValue = prefixStack.pop();
              String result = prefixEvaluate(valuesArray[i],leftValue,rightValue) + "";
               prefixStack.push(result);
            }
            else{
                prefixStack.push(valuesArray[i]);
          }
       }
        System.out.println(prefixStack.pop());
    }
    
    
    public static void main(String[] args) {                 
        JavaPrefixStack PS = new JavaPrefixStack();
        System.out.println("Please enter a prefix equation (make sure to include spaces between all values and operators):");
       Scanner scnr = new Scanner(System.in);
       String prefixProblem = scnr.nextLine();
        System.out.println("Your Problem is: "+ prefixProblem);
        System.out.print("Your Solution is: ");
       PS.createStack(prefixProblem);
    }
    
}
