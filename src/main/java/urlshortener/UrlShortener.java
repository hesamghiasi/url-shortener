package urlshortener;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UrlShortener {

    private static final Map<String, String> shortToLongMap = new HashMap<>();
    private static final Random random = new Random();
    public static String shortenUrl(String longUrl) {

        String path = getRandomString();
        String shortUrl = UrlShortenerConfigs.shortUrlBase + path;
        shortToLongMap.put( shortUrl, longUrl);
        return shortUrl;
    }

    private static String getRandomString() {
        String randomString = "";
        for (int i = 0; i < UrlShortenerConfigs.maxPathLength; i++) {
            char c =  (char) random.nextInt(0, 255);
            randomString = randomString + c;
        }
        return randomString;
    }

    public static String getOriginal(String shortUrl) {
        return shortToLongMap.get(shortUrl);
    }
}
