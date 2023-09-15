import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import urlshortener.UrlShortener;
import urlshortener.UrlShortenerConfigs;

class UrlShortenerTest {

    private final String longUrl = "http://www.example.com/xyzwrttfghijklmnopq";

    @Test
    void givenLongUrl_whenCallingShortenUrl_thenGetAShorterUrl() {

        String shortUrl = UrlShortener.shortenUrl(longUrl);

        String shortUrlMinusBase = shortUrl.replace(UrlShortenerConfigs.shortUrlBase, "");
        Assertions.assertTrue(shortUrlMinusBase.length() <= UrlShortenerConfigs.maxPathLength);
    }

    @Test
    void givenShortUrlOfALongUrl_whenCallingGetOriginalUrl_thenTheOriginalUrlIsReturned() {

        String shortUrl = UrlShortener.shortenUrl(longUrl);

        String originalUrl = UrlShortener.getOriginal(shortUrl);

        Assertions.assertEquals(longUrl, originalUrl);
    }

    @Test
    void givenMultipleLongUrls_whenCallingShortenUrlForEach_thenNoneOfShortUrlsAreEqual() {

        String secondLongUrl = "http://www.example.com/oilwxiwfghijklmnopq";

        String firstShortUrl = UrlShortener.shortenUrl(longUrl);
        String secondShortUrl = UrlShortener.shortenUrl(secondLongUrl);

        Assertions.assertFalse(firstShortUrl.equals(secondShortUrl));
    }

    @Test
    void whenCallingShortenUrl_thePathPartContainsOnlyAlphabeticCharacters() {

    }
}
