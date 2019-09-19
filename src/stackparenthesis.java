import java.util.*;
public class stackparenthesis {
    public static void main(String[] args) {
        Stack<Character> st=new Stack<>();
        String exp="[()]{}{[()()]()}";
        int flag=1;
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);
            if(c=='{' || c=='[' || c=='(' )
            {
                st.push(c);
            }
            else
            {
                if(c=='}')
                {
                    char d=st.pop();
                    if(d!='{')
                    {
                        flag=0;
                        break;
                    }
                }
                if(c==')')
                {
                    char d=st.pop();
                    if(d!='(')
                    {
                        flag=0;
                        break;
                    }
                }
                if(c==']')
                {
                    char d=st.pop();
                    if(d!='[')
                    {
                        flag=0;
                        break;
                    }
                }
            }
        }
        if(flag==1)
            System.out.println("balanced");
        else
            System.out.println("not balanced");

    }
}
