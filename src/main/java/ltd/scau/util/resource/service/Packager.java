package ltd.scau.util.resource.service;

import ltd.scau.util.resource.entity.FileData;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

/**
 * @author Weijie Wu
 */
public interface Packager {

    void zip(Collection<? extends FileData> files, OutputStream outputStream) throws IOException;
}
