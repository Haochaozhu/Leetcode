import java.util.*;
public class ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> operands = new Stack<Character>();
        Stack<Character> operators = new Stack<Character>();
        for(char ch: expression.toCharArray()) {
            if(ch == ',') {
                continue;
            } else if(ch == '(' || ch == 't' || ch == 'f') {
                operands.push(ch);
            } else if(ch == ')') {
                boolean val = false;
                char opr = operators.pop();
                String popped = "";
                while(!operands.isEmpty() && operands.peek() != '(') {
                    popped += operands.pop();
                }
                val = eval(opr, popped);
                if(!operands.isEmpty())
                    operands.pop();
                if(val)
                    operands.push('t');
                else
                    operands.push('f');
            } else if(ch == '&' || ch == '|' || ch == '!') {
                operators.push(ch);
            }
        }
        char res = operands.pop();
        if(res == 't')
            return true;
        else
            return false;
    }
    public boolean eval(char opr, String popped) {
        char head = popped.charAt(0);
        boolean cur = head == 't';
        if (opr == '!') return head != 't';
        for (int i = 1; i < popped.length(); i++) {
            if (opr == '&') {
                cur &= popped.charAt(i) == 't';
            } else {
                cur |= popped.charAt(i) == 't';
            }
        }
        return cur;
    }
}
