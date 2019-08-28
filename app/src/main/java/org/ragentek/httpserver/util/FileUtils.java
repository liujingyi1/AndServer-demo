package org.ragentek.httpserver.util;

import android.os.Environment;
import android.webkit.MimeTypeMap;

import com.yanzhenjie.andserver.http.multipart.MultipartFile;
import com.yanzhenjie.andserver.util.StringUtils;

import org.ragentek.httpserver.App;

import java.io.File;
import java.util.UUID;

public class FileUtils {
    /**
     * Create a random file based on mimeType.
     *
     * @param file file.
     *
     * @return file object.
     */
    public static File createRandomFile(MultipartFile file) {
        String extension = MimeTypeMap.getSingleton().getExtensionFromMimeType(file.getContentType().toString());
        if (StringUtils.isEmpty(extension)) {
            extension = MimeTypeMap.getFileExtensionFromUrl(file.getFilename());
        }
        String uuid = UUID.randomUUID().toString();
        return new File(App.getInstance().getRootDir(), uuid + "." + extension);
    }

    /**
     * SD is available.
     *
     * @return true, otherwise is false.
     */
    public static boolean storageAvailable() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File sd = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
            return sd.canWrite();
        } else {
            return false;
        }
    }
}
