import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFileChooser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvFileSource;

class readcsvtest {
	
	JFileChooser chooser;
	/* Test the main function to check that file exists */
	@Test
	void testMain() {
		chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(chooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = new File(chooser.getSelectedFile().getAbsolutePath());
			assertTrue(file.exists());
		}
	}
	
	/* Test the read function to make sure the csv file can be parsed */
	@Test
	void testRead() throws IOException{
		ReadCSV r = new ReadCSV();
		chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(chooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String[] actual = r.read(new BufferedReader(new FileReader(chooser.getSelectedFile())));
			String expected = "A";
			assertEquals(expected, actual[0]);
		}
	}

}
