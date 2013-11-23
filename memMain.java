package memory;

import javax.swing.JOptionPane;

public class memMain 
{

	public static void main(String[] args) 
	{
	
		{
            int choice;
            int queue;
      
            do
            {                
                    choice=showMenu();        
                    switch (choice)
                    {
                    //Each case asks for number of processes and feeds the array and number into methods
                    case 1:       
                    int [] FF=getFF();
                    printResults(FF);
                    break;
                    case 2:                       
                    break;
                    case 3:
                    System.exit(0);
                    break;
                    }
            }while (choice!=3);
    }
		

	
		
		int[]processes=getFF();
		
	}
	
	public static int[] getFF()
	{
		int size=0;
		String Ssize=JOptionPane.showInputDialog(null,"Enter amount of processes: ");
		try
		{
			size=Integer.parseInt(Ssize);
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null,"Please enter an integer");
		}
		int[] processes=new int[size];
		
		for(int i=0; i<size; i++)
		{
			String process=JOptionPane.showInputDialog(null,"Enter size for process" + " " + i);
			try
			{
				processes[i]=Integer.parseInt(process);
			}
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null,"Please enter an integer");

			}
		}
	
		return processes;
	}
		
		public static void printResults(int[]processes)
		{
			int[] divideProcess=new int[processes.length];
			int sum=0;
			int k=0;
			int memSize=memSize();
			for (int i=0; i<processes.length;i++)
			{
				divideProcess[i]=processes[i]/100;
				sum=divideProcess[i]+sum;
			}
			for (int j=0; j<processes.length; j++)
			{
				k=0;
				System.out.println("--"+processes[j]);
				while (k<divideProcess[j]&&sum<memSize)
				{
					System.out.println("|"+"         "+"|");
					k++;
				}
			
			}
			
			System.out.println("----------");
		}
		
		public static int showMenu()
        {
                int mchoice=0;
            try
            {
                    String s = JOptionPane.showInputDialog(
                                "Select an algorithm: \n" +
                                            "  1) First Fit\n" +
                                            "  2) Worst Fit\n" +
                                                "  3) EXIT\n");
                    mchoice = Integer.parseInt(s);
                    if(mchoice>3)
                    {
                            JOptionPane.showMessageDialog(null,"Please enter a valid choice");
                    }           
                }
            
         
                catch (NumberFormatException e)
            {
                    JOptionPane.showMessageDialog(null,"Please enter a valid choice");
            }
            return mchoice;
        }
		
		public static int memSize()
		{
			String sMemSize=JOptionPane.showInputDialog(null,"Enter size of memory array");
			int memSize=0;
			try
			{
				memSize=Integer.parseInt(sMemSize);
			}
			
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null,"Please enter valid size");
			}
			
			return memSize;
		}
			

}
