package memory;

import javax.swing.JOptionPane;

public class memMain 
{

	public static void main(String[] args) 
	{
	
		{
            int choice;
      
            do
            {                
                    choice=showMenu();        
                    switch (choice)
                    {
                    //Each case asks for number of processes and feeds the array and number into methods
                    case 1:       
                    int [] FF=getFF();
                    int[] sorted=sortBurst(FF);
                    printResults(sorted);
                    break;
                    case 2:                       
                    break;
                    case 3:
                    System.exit(0);
                    break;
                    }
            }while (choice!=3);
    }
			
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
			int j=0;
			int remainder=0;
			int memSize=memSize();
			for (int i=0;i<processes.length;i++)
			{
				divideProcess[i]=processes[i]/100;
			}
				while(sum<=memSize&&j<processes.length)
				{
					System.out.println("--"+"   "+ processes[j]);
					int k=0;
					while(k<divideProcess[j])
					{
					System.out.println("|"+"         "+"|");
					k++;
					}
					sum=sum+processes[j];
					System.out.println(sum);
					j++;
				}
				
			if(sum<memSize)
			{
				
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
		
		public static int[] sortBurst(int[] exec)
        {
        int[]sortExec=new int[exec.length];
        //This portion loops through the array and stores the values in a temp after comparison
        	for(int i=0; i<exec.length; i++)
        	{
                for(int j=i+1; j<exec.length; j++)
                {
                        if(exec[i] < exec[j] )
                        {
                        	int temp = exec[j];
                        	exec[j] = exec[i];
                        	exec[i] = temp;
                        }
                }
        	}
       
        	for(int k=0; k<exec.length; k++)
        	{
        		sortExec[k]=exec[k];
        	}
        	//Once the comparisons are complete, the method will print PID times to ensure that they have been sorted
               return sortExec;
       }

					
}
