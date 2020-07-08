package DataIngestion;

import java.io.File;
import java.io.FileOutputStream;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import org.apache.commons.io.FilenameUtils;
/**
 * Implement Features for standard ingestion task by ingesting a csv file from provided url source.
 * e.g. "https://health-infobase.canada.ca/src/data/covidLive/covid19.csv"
 */
public class IngestData {
    public static void getFileFromURL(String ln){
        URL fileURL = null;
        try {
            fileURL = new URL(ln);
            String fileName = FilenameUtils.getName(ln);
            ReadableByteChannel byteChannel = Channels.newChannel(fileURL.openStream());
            // Create Data Ingestion dir if not exist
            File dir = new File("DataIngestion");
            if (!dir.exists()){
                dir.mkdir();
            }
            FileOutputStream outputStream = new FileOutputStream("DataIngestion/"+fileName);
            outputStream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
            System.out.println("Ingestion Success. File \n`" + fileName+"`\n is Ingested from URL: \n`" + fileURL+"`");
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }
}

