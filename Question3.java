


//Que-3 Write a program to evaluate a expression using BODMASS approach.i.e. 
//string expression=”2+(5*(2-2))”



import java.io.*;
import java.util.*;





public class Question3 {
    public static void main(String[] args) {
        String str ="2+(5*(2-2))" ;
        char[] arr=str.toCharArray();
        int ans=evaluate(arr);
        System.out.println(ans);
    }

    public static int evaluate(char[] arr) {

        
        Stack<Integer> st = new Stack<Integer>();
        Stack<Character> operand = new Stack<Character>();

        
        for(int i=0;i<arr.length;i++) {

            if ((arr[i] >= '0' && arr[i] <= '9') || arr[i] == '.') {

                StringBuffer s = new StringBuffer();
                

                int j = i;
                while (j < arr.length) {
                    if ((arr[j] >= '0' && arr[j] <= '9') || arr[j] == '.'){
                        s.append(arr[j++]);
                    }
                    else break;
                }
                i = j-1;
                st.push(Integer.parseInt(s.toString()));
                ;
            }

           
            else if (arr[i]=='-' && i != 0 && (arr[i-1]=='(' || arr[i-1]=='*' || arr[i-1]=='/')) {
                StringBuffer buffer = new StringBuffer();
                buffer.append(arr[i]);
                int j = i+1;
                while (j < arr.length) {
                    if ((arr[j] >= '0' && arr[j] <= '9') || arr[j] == '.'){
                        buffer.append(arr[j++]);
                    }
                    else break;
                }
                i = j-1;

                st.push(Integer.parseInt(buffer.toString()));
                ;
            }

            
            else if (arr[i]=='+' && i != 0 && (arr[i-1]=='(' || arr[i-1]=='*' || arr[i-1]=='/')) {
                ;
            }

            
            else if (arr[i] == '(' ) {
                operand.push(arr[i]);
                ;
            }


           
            else if (arr[i] == ')') {
                while (operand.peek() != '(') {
                    st.push(calculate(operand.pop(), st.pop(), st.pop()));
                }
                operand.pop();
                ;
            }

            
            else if (arr[i] == '&' ||arr[i] == '+' || arr[i] == '-' ||
                    arr[i] == '*' || arr[i] == '/') {
               
                while (!operand.empty() && !st.empty() && precedence(arr[i], operand.peek())) {
                    int a = st.pop();
                    int b;
                    if (st.empty()) {
                        b=0;
                    }
                    else {
                        b=st.pop();
                    }

                    st.push(calculate(operand.pop(), a, b));
                }

                
                operand.push(arr[i]);
                ;
            }
        }

      
        while (!operand.empty()) {
            char op = operand.pop();
            int x = st.pop();
            int y;
            if (st.empty()) {
                y = 0;
            }
            else {
                y = st.pop();
            }
            st.push(calculate(op, x, y));
        }

        // Top of 'st' contains result, return it
        return st.pop();
    }


    
    public static int calculate(char op, int b, int a) {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '&':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return -1;
    }
    public static boolean precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;

        if ((op1 == '&' || op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;

        else
            return true;
    }

    
    
}
