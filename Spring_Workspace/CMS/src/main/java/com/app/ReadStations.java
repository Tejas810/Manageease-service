package com.app;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import java.io.*;

public class ReadStations {
	public static String readJsonFile() throws IOException {
	    Resource resource = new ClassPathResource("Stations.json");
	    File file = resource.getFile();
	    StringBuilder content = new StringBuilder();

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
	}
}

