package javaprefixstack;
import java.util.*;
/**
 *
 * @author aslas
 */
public class JavaPrefixStack {
Set<String> operatorsList = new HashSet<>(Arrays.asList("+","-","*","/"));

    public boolean checkOperator(String inputItem){
        return operatorsList.contains(inputItem);
        
        
    }   
    
    public int prefixEvaluate(String Operator, String leftNum, String rightNum){
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
    
    public void createStack(String prefixExpression){
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
