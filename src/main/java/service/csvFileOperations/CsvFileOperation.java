package service.csvFileOperations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import domain.CsvFile;

public class CsvFileOperation {

	private static  String fileName;
	// Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	// CSV file header
	private static final String FILE_HEADER = "_ID,Name,Type,Latitude,Longitude";

	// Write to CSV file Method
	public static void writeCsvFile(List<CsvFile> contents,String cityName) {

		FileWriter fileWriter = null;
		fileName=System.getProperty("user.home")+"/"+cityName+"-goeuroFile.csv";
		try {

			fileWriter = new FileWriter(new File(fileName));
			// Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			for (CsvFile csvfileRow : contents) {
				fileWriter.append(String.valueOf(csvfileRow.get_id()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(csvfileRow.getName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(csvfileRow.getType());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(csvfileRow.getLatitude()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(csvfileRow.getLongitude()));
				fileWriter.append(NEW_LINE_SEPARATOR);

			}

			System.out.println("CSV file was created successfully with The Contents!!!");

		} catch (Exception e) {

			System.out.println("Error in CsvFileWriter !!!");

			e.printStackTrace();

		} finally {

			try {

				fileWriter.flush();

				fileWriter.close();

			} catch (IOException e) {

				System.out.println("Error while flushing/closing fileWriter !!!");

				e.printStackTrace();

			}

		}

	}

}
