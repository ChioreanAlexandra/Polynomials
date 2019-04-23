package ro.tuc.pt.assign1;
import ro.tuc.pt.assign1.gui.*;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
		Window w=new Window();
		Model model=new Model();
		Controller b=new Controller(w,model);
    }
}
