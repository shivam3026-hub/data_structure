import java.util.*;

public class infix {
    static  boolean isChar(char x)
    {
        if((x >='a' && x<='z') || (x>='A' && x<='Z'))
        {
            return true;
        }
        else
            return false;
    }
    static String postfixtoinfix(String exp)
    {
        Stack<String> s=new Stack<>();
        for(int i = 0;i<exp.length();i++)
        {
           char c= exp.charAt(i);
            if(isChar(c))
            {
                s.push(c +"");

            }
            else
            {
                String str=s.pop();

                String str1=s.pop();


                s.push("("+str1 + c + str +")");
            }
        }
        return s.peek();
    }

    public static void main(String[] args) {
        String ex="abc+de/*-";
        System.out.println(postfixtoinfix(ex));
    }


}
