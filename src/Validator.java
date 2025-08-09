import java.io.File;

public class Validator {
    //key length check and file exists

    public static boolean isValidKey(int key) {

        return key >= 1 && key <= 62;
    }
    //is file exists
    public static boolean isFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }
}
