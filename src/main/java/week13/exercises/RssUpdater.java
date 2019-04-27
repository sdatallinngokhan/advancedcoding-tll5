package week13.exercises;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RssUpdater {

    private final Integer FREQUENCY_INTERVAL = 30000; // ms

    public List<News> readRss() {
        List<News> newsList = new ArrayList<>(); // here is Polymorphism and Association
        try {
            URL url = new URL("http://feeds.bbci.co.uk/news/world/rss.xml");
            XmlReader xmlReader = new XmlReader(url);

            SyndFeed syndFeed = new SyndFeedInput().build(xmlReader);

            for (SyndEntry syndEntry : syndFeed.getEntries()) {
                News news = new News(); // I am creating a new News object every time to have different News object for each iteration
                news.setAuthor(syndEntry.getAuthor().equals("") ? "Default Author" : syndEntry.getAuthor());
                news.setDescription(syndEntry.getDescription().getValue());
                news.setLink(syndEntry.getLink());
                news.setTitle(syndEntry.getTitle());

                newsList.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newsList;
    }

    public void writeRssToFile(List<News> newsList) {
        try {
            Path path = Paths.get("/Users/gokhanpolat/Developer/advancedCoding-tll5/updatedRss.txt");

            List<String> newsStringList = getNewsStringList(newsList);

            Files.write(path, newsStringList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> getNewsStringList(List<News> newsList) {
        List<String> newsStringList = new ArrayList<>();

        newsStringList.add(new Date().toString());
        newsStringList.add("\n");

        for (News news : newsList) {
            newsStringList.add(news.getTitle());
            newsStringList.add(news.getAuthor());
            newsStringList.add(news.getLink());
            newsStringList.add(news.getDescription());
            newsStringList.add("\n");
        }
        return newsStringList;
    }

    public static void main(String[] args) throws Exception {
        RssUpdater rssUpdater = new RssUpdater();

        while (true) {
            List<News> newsList = rssUpdater.readRss();
            rssUpdater.writeRssToFile(newsList);

            Thread.sleep(rssUpdater.FREQUENCY_INTERVAL);
        }

    }
}
