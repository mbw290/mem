package memory;

import javax.swing.JOptionPane;

public class memMain 
{
	
	public static void main(String[] args) 
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
		
		int[]processes=getInfo();
		printResults(processes);
	}
	
	public static int[] getInfo()
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
			int k=0;
			for (int i=0; i<processes.length;i++)
			{
				divideProcess[i]=processes[i]/100;
			}
			for (int j=0; j<processes.length; j++)
			{
				k=0;
				while (k<divideProcess[j])
				{
					System.out.println("|");
					k++;
				}
			System.out.println("--"+processes[j]);
			}
			
			System.out.println("----------");
		}
			

}
