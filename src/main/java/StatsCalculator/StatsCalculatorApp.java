package StatsCalculator;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import java.io.FileReader;
import java.io.IOException;

public class StatsCalculatorApp {
    /**
     * versionLabel retrives metadata from pom.xml, compile a string with
     * globalVersion + "."+ version as a new text String.
     * @return version label
     */
    public static String versionLabel() {
    String versionLabel="";
        try {
            MavenXpp3Reader reader = new MavenXpp3Reader();
            Model model = reader.read(new FileReader("pom.xml"));
            versionLabel = model.getProperties().get("globalVersion")+"."+model.getVersion();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return versionLabel;
    }
}
