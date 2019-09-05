package com.rahul.rawat.assignment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.rahul.rawat.exception.ApplicationConstants;
import com.rahul.rawat.exception.DisplayDirectoryException;

/**
 * @author Rahul Singh Rawat
 *
 */
public class Assignment {
	public static void main(String[] args) throws IOException {

		Assignment a = new Assignment();
		String directoryPath = "."; // For current directory use "."
		File file = null;

		file = a.displayDirectoryContents(directoryPath);

		List<String> lines = Files.readAllLines(file.toPath());

		for (String line : lines)
			System.out.println(line);
	}

	/**
	 * @param directoryPath
	 * @throws PathNotValidException
	 * 
	 * This method takes directory path as string and returns the XML tree hierarchy file. In case of invalid path it throws PathNotValidException.  
	 */
	public File displayDirectoryContents(String directoryPath) throws DisplayDirectoryException {
		File dir = new File(directoryPath);
		GetStringBuffer.getStringBuffer()
				.append("<" + "Directory" + " " + "rootName=" + dir.getName() + ">" + System.lineSeparator());
		if (dir.exists()) {
			printTreeSrtucture(dir, 1);
		} else {
			throw new DisplayDirectoryException(ApplicationConstants.PATH_DOSE_NOT_EXIST);

			// System.out.println("Exception :" + "Path is not valid");
		}

		GetStringBuffer.getStringBuffer().append("</" + "Directory" + ">" + System.lineSeparator());
		Path path = Paths.get("src\\resources\\Output.xml");
		File result = null;
		String pathString = path.toString();
		try {
			Files.write(path, GetStringBuffer.getStringBuffer().toString().getBytes());
			result = new File(pathString);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * @param dir
	 * @param indent
	 */
	public static void printTreeSrtucture(File dir, int indent) {

		File[] files = dir.listFiles();
		Arrays.sort(files, new Comparator<File>() {
			public int compare(File f1, File f2) {
				return (f1.getName().compareTo(f2.getName()));
			}
		});
		for (File file : files) {
			int depth = indent;
			if (file.isDirectory()) {
				while (depth > 0) {
					GetStringBuffer.getStringBuffer().append("\t");
					depth = depth - 1;
				}
				try {
					GetStringBuffer.getStringBuffer()
							.append("<" + "Directory" + " " + "name=" + file.getName() + " " + "path="
									+ file.getCanonicalPath() + " " + "size="
									+ Files.size(Paths.get(file.getCanonicalPath())) + ">" + System.lineSeparator());
				} catch (IOException e) {
					e.printStackTrace();
				}
				printTreeSrtucture(file, indent + 1);

				while (depth != indent) {
					GetStringBuffer.getStringBuffer().append("\t");
					depth = depth + 1;
				}
				GetStringBuffer.getStringBuffer().append("</" + "Directory" + ">" + System.lineSeparator());
			} else {
				StringBuffer sb = new StringBuffer();
				while (depth > 0) {
					sb.append("\t");
					depth = depth - 1;
				}

				GetStringBuffer.getStringBuffer().append(sb.toString() + "<" + "File" + ">" + System.lineSeparator());
				GetStringBuffer.getStringBuffer().append("\t" + sb.toString() + "<" + "filename" + ">" + file.getName()
						+ "</" + "filename" + ">" + System.lineSeparator());
				try {
					GetStringBuffer.getStringBuffer().append("\t" + sb.toString() + "<" + "filepath" + ">"
							+ file.getCanonicalPath() + "</" + "filepath" + ">" + System.lineSeparator());
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					GetStringBuffer.getStringBuffer()
							.append("\t" + sb.toString() + "<" + "filesize" + ">"
									+ Files.size(Paths.get(file.getCanonicalPath())) + "</" + "filesize" + ">"
									+ System.lineSeparator());
				} catch (IOException e) {
					e.printStackTrace();
				}
				GetStringBuffer.getStringBuffer().append(sb.toString() + "</" + "File" + ">" + System.lineSeparator());
			}
		}
	}

}
