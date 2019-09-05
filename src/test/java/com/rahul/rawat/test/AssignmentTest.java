package com.rahul.rawat.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rahul.rawat.assignment.Assignment;
import com.rahul.rawat.assignment.UtilClass;

/**
 * @author Rahul Singh Rawat
 *
 */
public class AssignmentTest {
	
	/**
	 * @throws IOException
	 * Setting up temporary nested directory path for test environment before executing test case.
	 * By default it will create directory path under C: drive.
	 */
	@Before
	public void createDirectory() throws IOException {
		Path path = Paths.get("C:\\ABC\\A\\..\\B\\C\\..\\D\\..\\E");
		Files.createDirectories(path);
	}
	
	
	/**
	 * @throws IOException
	 * Asserting returned file's XML hierarchy data with temporary nested directory data to confirm the recursive logic.
	 */
	@Test
	public void testdisplayDirectoryContents() throws IOException {
		Assignment assignment = new Assignment();
		String string = "<Directory rootName=ABC>\r\n" + 
				"	<Directory name=A path=C:\\ABC\\A size=0>\r\n" + 
				"	</Directory>\r\n" + 
				"	<Directory name=B path=C:\\ABC\\B size=0>\r\n" + 
				"		<Directory name=C path=C:\\ABC\\B\\C size=0>\r\n" + 
				"		</Directory>\r\n" + 
				"		<Directory name=D path=C:\\ABC\\B\\D size=0>\r\n" + 
				"		</Directory>\r\n" + 
				"		<Directory name=E path=C:\\ABC\\B\\E size=0>\r\n" + 
				"		</Directory>\r\n" + 
				"	</Directory>\r\n" + 
				"</Directory>\r\n" + 
				"";
		
		//File file = new File("C:\\ABC");
		StringBuffer sb = new StringBuffer(); 
		
        File file_ = assignment.displayDirectoryContents("C:\\ABC");
        
        InputStream is = new FileInputStream(file_); 
        BufferedReader buf = new BufferedReader(new InputStreamReader(is)); 
        String line = buf.readLine(); 

        while(line != null){
        	sb.append(line); 
        line = buf.readLine(); 
        }
        String response = sb.toString().replaceAll("\\s+", "");
        String expected = string.replaceAll("\\s+", "");
       assertEquals(expected, response);
	}
	
	/**
	 * @throws IOException
	 * Deleting temporary nested directory path post test case execution.
	 * Invoking deleteDirectory() from UtilClass to delete nested structure of directory.
	 */
	@After
	public void removeDirectory() throws IOException {
		UtilClass util = new UtilClass();
		Path path = Paths.get("C:\\ABC");
		util.deleteDirectory(new File(path.toString()));
	}
	
	
}
