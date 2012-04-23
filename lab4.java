import java.io.*;
import javax.swing.*;
import java.util.regex.*;

	public class lab4
	{
		public static void main(String[] args) 
		{
			String file;
			String text = "";
			String tmp = "";
			Matcher match;
			Pattern patt;
			if (args.length == 2 && args.length != 0)
			{
				file = args[0];
				patt = Pattern.compile(args[1]);
			} 
			else
			{
				file = JOptionPane.showInputDialog("File: ");
				patt = Pattern.compile(JOptionPane.showInputDialog("Regular expression: "));
			}
			try
			{
				FileInputStream file_in = new FileInputStream(file);
				BufferedReader reader = new BufferedReader(new InputStreamReader(file_in));
				FileOutputStream file_out = new FileOutputStream("output.txt");
				DataOutputStream writer = new DataOutputStream(file_out);
				tmp = reader.readLine();
				int i = 1;
				do
				{
					match = patt.matcher(tmp);
					if (match.matches())
					{
						text = text + "file_name:" + i + ": " + tmp + "\n";
					}
					tmp = reader.readLine();
					i++;
				}
				while (tmp != null);
				writer.writeUTF(text);
				reader.close();
				writer.close();
			}
			catch(Exception exptn)	{}
		}
	}