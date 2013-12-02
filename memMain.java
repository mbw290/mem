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
                    int memSize=memSize();
                    int [] BF=getPROC();
                    int[] sorted=sortMem(BF);
                    String Cchoice=printResults(sorted,memSize);
                    compact(Cchoice,BF);
                    break;
                    case 2:       
                    memSize=memSize();
                    int WF[]=getPROC();
                    Cchoice=printResults(WF,memSize);
                    compact(Cchoice,WF);
                    break;
                    case 3:
                    System.exit(0);
                    break;
                    }
            }while (choice!=3);
    }
			
	}
	
	public static int[] getPROC()
	{
		int size=0;
		int Ichoice=0;
		try
		{
		String bsChoice=JOptionPane.showInputDialog(
                                "Select a memory size: \n" +
                                            "  1) Kilobytes\n" +
                                            "  2) Megabytes\n" +
                                                "  3) Gigabytes\n");
        Ichoice = Integer.parseInt(bsChoice);
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null,"Enter a valid choice");
		}
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
		
		if (Ichoice==1)
		{
			for (int i=0; i<processes.length;i++)
			{
				processes[i]=processes[i]/1024;
			}
		}
		
		if (Ichoice==3)
		{
			for (int i=0; i<processes.length;i++)
			{
				processes[i]=processes[i]*1024*1024;
			}
		}
		
		
	
		return processes;
	}
		
		public static String printResults(int[]processes,int memSize)
		{
			int[] divideProcess=new int[processes.length];
			int sum=0;
			int j=0;
			int remainder=0;
			int m=0;
			for (int i=0;i<processes.length;i++)
			{
				divideProcess[i]=processes[i]/100;
			}
				while(sum<=memSize&&j<processes.length)
				{
					if (processes[j]>memSize)
					{
						
						j++;
					}
					System.out.println("--"+"   "+ processes[j]);
					int k=0;
					while(k<divideProcess[j])
					{
					System.out.println("|"+"         "+"|");
					k++;
					}
					sum=sum+processes[j];
					System.out.println("--END"+" "+"process"+j);
					j++;
				}
				
			if(sum<memSize)
			{
				remainder=(memSize-sum)/100;
			}
			while (m<remainder)
			{
				System.out.println("|"+"         "+"|");
				m++;
			}
			System.out.println("----------");
			String choice=JOptionPane.showInputDialog(null,"Would you like to remove any?(y/n");
			if (choice=="y"||choice=="Y")
			{
				return choice;
			}
			return choice;
		}
		
		public static int showMenu()
        {
                int mchoice=0;
            try
            {
                    String s = JOptionPane.showInputDialog(
                                "Select an algorithm: \n" +
                                            "  1) Best Fit\n" +
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
		
		public static int[] sortMem(int[] BF)
        {
        int[]sortExec=new int[BF.length];
        //This portion loops through the array and stores the values in a temp after comparison
        	for(int i=0; i<BF.length; i++)
        	{
                for(int j=i+1; j<BF.length; j++)
                {
                        if(BF[i] < BF[j] )
                        {
                        	int temp = BF[j];
                        	BF[j] = BF[i];
                        	BF[i] = temp;
                        }
                }
        	}
       
        	for(int k=0; k<BF.length; k++)
        	{
        		sortExec[k]=BF[k];
        	}
        	//Once the comparisons are complete, the method will print PID times to ensure that they have been sorted
               return sortExec;
       }
		
		public static void compact(String choice,int[]processes)
		{
		int j=0;
		int m=0;
			if (choice=="N"||choice=="n")
			{
				System.exit(0);
			}
			System.out.println("STARTING COMPACTION!");
			int amount=0;
			String Samount=JOptionPane.showInputDialog(null,"How many processes would you like to remove?");
			try
			{
				amount=Integer.parseInt(Samount);
				
			}
			
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Enter valid amount");
			}
			int [] removal=new int[amount];
			int []divideProcess=new int[processes.length];
			int sum=0;
			int memSize=memSize();
			int remainder=0;
			String Sproc=JOptionPane.showInputDialog("Which process(es) would you like to remove?(separate by comma)");
			StringTokenizer st = new StringTokenizer(Sproc,",");
			while (st.hasMoreElements()) 
			{
				try
				{
				removal[j]=Integer.parseInt((String) st.nextElement());
				}
				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Enter valid number");
				}
				j++;
			}
				
			for (int k=0;k<processes.length;k++)
			{
				divideProcess[k]=processes[k]/100;
			}
			for (int y=0;y<removal.length;y++)
			{
			JOptionPane.showMessageDialog(null, "REMOVE"+" "+y);
			}
			for (int i=0;i<divideProcess.length;i++)
			{
				for (int k=0;k<removal.length;k++)
				{
					if (i!=removal[k])
					{
						while(sum<=memSize&&j<processes.length)
						{
							if (processes[j]>memSize)
							{
								j++;
							}
						System.out.println("--"+"   "+ processes[j]);
						int z=0;
						while(z<divideProcess[j])
						{
						System.out.println("|"+"         "+"|");
						z++;
						}
						sum=sum+processes[j];
						System.out.println("--END"+" "+"process"+j);
						j++;
						}
					}
				}
						
					if(sum<memSize)
					{
						remainder=(memSize-sum)/100;
					}
					while (m<remainder)
					{
						System.out.println("|"+"         "+"|");
						m++;
					}
					System.out.println("----------");	
					}
						
				}
}
