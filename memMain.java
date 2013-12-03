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
                    //If the user chooses to have a random array, genRandom is run
                    //If the user wants manual entry, the user is prompted and the array is sorted 
                    case 1:
                    int memSize=memSize();
                    String rChoice=JOptionPane.showInputDialog(null,"Would you like it random?");
                    int[] BF;
                    if (rChoice.equals("Y"))
                    {
                    BF=genRandom(memSize);
                    int[] sorted=sortMemBF(BF);
                    String Cchoice=printResults(sorted,memSize);
                    compact(Cchoice,BF);
                    System.exit(0);
                    }                   
                    BF=getPROC();
                    int[] sorted=sortMemBF(BF);
                    String Cchoice=printResults(sorted,memSize);
                    compact(Cchoice,BF);
                    break;
                    case 2:       
                    memSize=memSize();
                    String r2Choice=JOptionPane.showInputDialog(null,"Would you like it random?");
                    int[] WF;
                    if (r2Choice.equals("Y"))
                    {
                    WF=genRandom(memSize);
                    int[] WFsorted=sortMemBF(WF);
                    String WFchoice=printResults(WFsorted,memSize);
                    compact(WFchoice,WF);
                    System.exit(0);
                    }
                    WF=getPROC();
                    int[] sortedWF=sortMemWF(WF);
                    Cchoice=printResults(sortedWF,memSize);
                    compact(Cchoice,WF);
                    break;
                    case 3:
                    System.exit(0);
                    break;
                    }
            }while (choice!=3);
    }
			
	}
	//Generate a series of random numbers from 128-1024 to fill the memory array
	public static int[] genRandom(int memSize)
	{
		int[] processes=new int [memSize];
		Random generator = new Random();
		int random_integer = generator.nextInt(1024-128) + 128;
		for (int i=0;i<processes.length;i++)
		{
			processes[i]=random_integer;
		}
		
		return processes;
	}
	//Prompt the users to manually enter processes
	public static int[] getPROC()
	{
		int size=0;
		int Ichoice=0;
	//Find units for the user to enter processes and check input for integer
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
		//Ask the user for amount of processes to set loop reps and array size
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
		//Loop for size of defined array to get process sizes
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
		//Perform the appropriate math based on units entered by user
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
	
	//Print results keeps prints processes with lines to fill the array
		public static String printResults(int[]processes,int memSize)
		{
			int[] divideProcess=new int[processes.length];
			int sum=0;
			int j=0;
			int remainder=0;
			int m=0;
			//To print, we want to scale divided by 100 to print a normal amount of lines
			//with the same ratio (ie 10 lines vs 1024)
				for (int i=0;i<processes.length;i++)
				{
				divideProcess[i]=processes[i]/100;
				}
			//Keep going for each process while the process sum does not equal array size
				while(sum<=memSize&&j<processes.length)
				{
					//Make sure the individual process does not exceed array size
					//If so, skip it
					if (processes[j]>memSize)
					{		
					j++;
					}
				//Print the dashes with the process memory size	
				System.out.println("--"+"   "+ processes[j]);
				int k=0;
				//Print vertical lines in the appropriate ratio for the memory size
					while(k<divideProcess[j])
					{
					System.out.println("|"+"         "+"|");
					k++;
					}
				//Add the last printed process to the sum
				//Print more dashes and end to show the end of the process
				//Move to check the next process
						sum=sum+processes[j];
						System.out.println("--END"+" "+"process"+j);
						j++;
				}
			//Print empty blocks if any to show full array size
			if(sum<memSize)
			{
				remainder=(memSize-sum)/100;
			}
			//Print all lines for remaining blocks
			while (m<remainder)
			{
				System.out.println("|"+"         "+"|");
				m++;
			}
			System.out.println("----------");
			String choice=JOptionPane.showInputDialog(null,"Would you like to remove any?(y/n)");
			//decide whether or not to run compaction
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
		
		public static int[] sortMemBF(int[] BF)
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
        	//Once the comparisons are complete, the method will print sizes to ensure that they have been sorted
               return sortExec;
       }
		
		public static int[] sortMemWF(int[] WF)
        {
        int[]sortExec=new int[WF.length];
        //This portion loops through the array and stores the values in a temp after comparison
        	for(int i=0; i<WF.length; i++)
        	{
                for(int j=i+1; j<WF.length; j++)
                {
                        if(WF[i] > WF[j] )
                        {
                        	int temp = WF[j];
                        	WF[j] = WF[i];
                        	WF[i] = temp;
                        }
                }
        	}
       
        	for(int k=0; k<WF.length; k++)
        	{
        		sortExec[k]=WF[k];
        	}
        	//Once the comparisons are complete, the method will print PID times to ensure that they have been sorted
               return sortExec;
       }
		public static void compact(String choice,int[]processes)
		{
		int j=0;
		int m=0;
			if (choice.equals("N")||choice.equals("n"))
			{
				JOptionPane.showMessageDialog(null, "BYE");
				System.exit(0);
			}
			System.out.println("STARTING AUTO-COMPACTION!");
			int amount=0;
			//Find out how many processes to remove before compaction
			String Samount=JOptionPane.showInputDialog(null,"How many processes would you like to remove?");
			try
			{
				amount=Integer.parseInt(Samount);
				
			}
			
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Enter valid amount");
			}
			//Create an array to store the processes to remove from the array
			int [] removal=new int[amount];
			int []divideProcess=new int[processes.length];
			int sum=0;
			//Obtain the new memory size
			int memSize=memSize();
			int remainder=0;
			//Find the amount of processes to remove 
			String Sproc=JOptionPane.showInputDialog("Which process(es) would you like to remove?(separate by comma)");
			//Get integer values for each array element to remove
			//and populate the array with them
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
			//Just like printResults, we populate the array of divided processes
			//to maintain a printing ratio
			for (int k=0;k<processes.length;k++)
			{
				divideProcess[k]=processes[k]/100;
			}
			//Show the user each process that will be removed
			for (int y=0;y<removal.length;y++)
			{
			JOptionPane.showMessageDialog(null, "REMOVE"+" "+y);
			}
			//Here we check each process to see if the user wants it erased
			for (int i=0;i<divideProcess.length;i++)
			{
			//For each process, see if it's in the array of processes that the user
			//wants removed
				for (int k=0;k<removal.length;k++)
				{
					if (i!=removal[k])
					{
					//Check to make sure the sum isn't greater than the array of memory
						while(sum<=memSize&&j<processes.length)
						{
						//Skip the process if it's greater than the memory array by itself
							if (processes[j]>memSize)
							{
								j++;
							}
						//Print dashes and the memory amount
						System.out.println("--"+"   "+ processes[j]);
						int z=0;
					//Print vertical lines in the appropriate ratio
						while(z<divideProcess[j])
						{
						System.out.println("|"+"         "+"|");
						z++;
						}
					//Add the size to the sum then the dashes plus end
					//Move to the next element
						sum=sum+processes[j];
						System.out.println("--END"+" "+"process"+j);
						j++;
						}
					}
				}
				//Check for empty remaining blocks						
					if(sum<memSize)
					{
						remainder=(memSize-sum)/100;
					}
				//Print any empty blocks
					while (m<remainder)
					{
						System.out.println("|"+"         "+"|");
						m++;
					}
					System.out.println("----------");	
					}
						
				}

}
