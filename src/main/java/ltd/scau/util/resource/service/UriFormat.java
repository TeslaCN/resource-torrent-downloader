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
}
