import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class SignalWithNoise
{

	private static Random random = new Random();
	private static BufferedWriter writer = null;


	public static void main(String args[])
	{
		printFunction();
	}


	public static void printFunction()
	{
		int randomVal = random.nextInt(100);

		int signRandom = random.nextInt(100)%2;

		float valor = 0;

		for(int i = 0;i<100;i++)
		{
			if(random.nextInt(100)%2 == 1)
			{
				valor = (float)Math.sin(i)*(1+(randomVal/100));
			}
			else
			{
				valor = (float)Math.sin(i)*(1-(randomVal/100));
			}

			System.out.println(""+valor);
			toFile(""+valor);
		}
		try
		{
			writer.close();
		}
		catch(Exception e)
		{

		}
	}

	public static void toFile(String linea)
	{
		if(writer==null)
			try
			{
				writer = new BufferedWriter(new FileWriter("Datos.txt"));
			}
			catch(Exception e)
			{

			}
		
		try
		{
			writer.write(linea+"\n");
		}
		catch(Exception e)
		{

		}
	}
}