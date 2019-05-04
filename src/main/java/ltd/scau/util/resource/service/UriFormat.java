package ltd.scau.util.resource.service;

/**
 * @author Weijie Wu
 */
public interface UriFormat {

    /**
     *
     * @return
     */
    String baseUri();

    /**
     * @param urn
     * @return
     */
    String format(String urn);

    /**
     * @param key
     * @param page
     * @return
     */
    String formatSearch(String key, Integer page);
}
