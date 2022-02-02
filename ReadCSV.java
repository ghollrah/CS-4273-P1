import java.io.*;
import java.util.Arrays;

import javax.swing.JFileChooser;

public class ReadCSV{
	String line="";
	String[] letters = new String[2];
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
		    JFileChooser chooser = new JFileChooser();
			chooser.setDialogType(JFileChooser.OPEN_DIALOG);
			int returnVal = chooser.showOpenDialog(chooser);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				br = new BufferedReader(new FileReader(chooser.getSelectedFile()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ReadCSV r = new ReadCSV();
		
		String[] l = r.read(br);
		for (int i=0; i<l.length; i++) {
			System.out.println(l[i]);
		}
		
	}
	public String[] read(BufferedReader br) {
		int index=0;
		try {
			while ((line=br.readLine()) != null) {
				String[] temp = line.split(",");
				if (br.readLine() != null) {
					System.out.println("Null....");
					letters = Arrays.copyOf(letters, letters.length+2);
					letters[index]=temp[0];
					letters[index+1]=temp[1];
				}
				index+=2;
				for (int i=0;i<letters.length; i++) {
					//System.out.println(letters[i]);
				}	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return letters;
	}
}
