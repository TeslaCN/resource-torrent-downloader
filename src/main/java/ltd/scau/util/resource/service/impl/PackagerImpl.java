package ltd.scau.util.resource.service.impl;

import ltd.scau.util.resource.entity.FileData;
import ltd.scau.util.resource.service.Packager;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Weijie Wu
 */
@Service
public class PackagerImpl implements Packager {

    @Override
    public void zip(Collection<? extends FileData> files, OutputStream outputStream) throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        for (FileData f : files) {
            try {
                ZipEntry zipEntry = new ZipEntry(f.getName());
                zipEntry.setSize(f.getBytes().length);
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.write(f.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        zipOutputStream.finish();
    }
}
