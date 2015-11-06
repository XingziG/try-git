import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Reflection
{
    public int func(final String str)
    {
        System.out.println(str);
        return 0;
    }
    
    public static void main(String[] args)
    {
        Reflection r = new Reflection();
        try
        {
            // This will not pass compile
            //r.func(cosStr);
            
            // Refelction
            Method m = r.getClass().getMethod("func", String.class);
            String cosStr = "";
            if (1 < 2) {
            	cosStr += "Here it is!";
            }
            m.invoke(r, cosStr);
            
            cosStr = "New String";
            m.invoke(r, cosStr);
            
            //Magic part, this will pass
            //r.func(cosStr);
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
        catch (SecurityException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }
}

