package memory;

public class memMain 
{
	
	public static void main(String[] args) 
	{
		//getInfo();
		
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
		
		JOptionPane.showInputDialog(null,"Enter amount of processes: ");
		return processes;
	}
		
		public static void printResults()
		{
			int i=0;
			while (i<10)
			{
			System.out.println("|"+"          "+"|");
			i++;
			}
			System.out.println(" "+"__________");
		}

}
