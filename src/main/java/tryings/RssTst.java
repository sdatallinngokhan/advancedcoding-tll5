package tryings;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.net.URL;

public class RssTst {

    public static void main(String[] args) throws Exception{
        URL url = new URL("http://feeds.bbci.co.uk/news/world/rss.xml");
        XmlReader xmlReader = new XmlReader(url);
        SyndFeed syndFeed = new SyndFeedInput().build(xmlReader);

        System.out.println(syndFeed.getLanguage());
        for (SyndEntry syndEntry : syndFeed.getEntries()) {
            System.out.println(syndEntry.getTitle());
        }
    }
}
