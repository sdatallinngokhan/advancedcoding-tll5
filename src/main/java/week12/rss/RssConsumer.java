package week12.rss;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class RssConsumer {

    public SyndFeed consumeRss(String rssUrl) {
        try {
            URL url = new URL(rssUrl);
            XmlReader xmlReader = new XmlReader(url);

            SyndFeed syndFeed = new SyndFeedInput().build(xmlReader);

            return syndFeed;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void writeFile(String writingPath, List<String> lines) {
        try {
            Path path = Paths.get(writingPath);

            Files.write(path, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> getLines(SyndFeed syndFeed) {
        List<String> lines = new LinkedList<>();
        lines.add(syndFeed.getTitle());
        lines.add("\n");
        lines.add("\n");

        syndFeed.getEntries().stream().forEach(syndEntry -> {
            lines.add(syndEntry.getTitle());
            lines.add(syndEntry.getLink());
            lines.add(syndEntry.getDescription().getValue());
            lines.add("\n");
        });
        return lines;
    }

    public static void main(String[] args) {
        RssConsumer rssConsumer = new RssConsumer();

        String url = "http://feeds.bbci.co.uk/news/world/rss.xml";
        SyndFeed syndFeed = rssConsumer.consumeRss(url);

        List<String> lines = rssConsumer.getLines(syndFeed);

        String writingPath = "/Users/gokhanpolat/Developer/advancedCoding-tll5/rssContent.txt";
        rssConsumer.writeFile(writingPath, lines);
    }
}
