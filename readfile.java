import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvFileSource;

class readfile {
	
	/* Test the main function to check that file exists */
	@Test
	@CsvFileSource(resources = "D:/2021-2022/CS-4273/LetterGame/src/test.csv")
	void testMain() {
		File file = new File("D:/2021-2022/CS-4273/LetterGame/src/test.csv");
		assertTrue(file.exists());
	}
	
	/* Test the read function to make sure the csv file can be parsed */
	@Test
	void testRead() throws IOException{
		ReadCSV r = new ReadCSV();
		String[] actual = r.read(new BufferedReader(new FileReader("D:/2021-2022/CS-4273/LetterGame/src/test.csv")));
		String expected = "A";
		assertEquals(expected, actual[0]);
	}

}
