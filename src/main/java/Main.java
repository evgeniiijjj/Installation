import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static final StringBuilder log = new StringBuilder();

    public static void main(String[] args) {
        File games = new File("D:/Games");
        File src = createDirectory(games, "src");
        File main = createDirectory(src, "main");
        File test = createDirectory(src, "test");
        File res = createDirectory(games, "res");
        File drawables = createDirectory(res, "drawables");
        File vectors = createDirectory(res, "vectors");
        File icons = createDirectory(res, "icons");
        File savegames = createDirectory(games, "savegames");
        File temp = createDirectory(games, "temp");
        File fileMain = createFile(main, "Main.java");
        File utils = createFile(main, "Utils.java");
        File fileTemp = createFile(temp, "temp.txt");

        if (fileTemp.exists()) {
            try(FileWriter writer = new FileWriter(fileTemp)) {
                writer.write(log.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static File createFile(File directory, String fileName) {
        File file = new File(directory.getAbsolutePath() + "/" + fileName);
        try {
            if (file.createNewFile()) log.append(String.format("Файл %s создан успешно\n", fileName));
        } catch (IOException e) {
            log.append("Ошибка при создании файла (").append(e.getMessage()).append(")\n");
        }
        return file;
    }

    private static File createDirectory(File directory, String directoryName) {
        File file = new File(directory.getAbsolutePath() + "/" + directoryName);
        if (file.mkdir()) log.append(String.format("Директория %s создана успешно\n", directoryName));
        else log.append(String.format("Ошибка при создании директории %s\n", directoryName));
        return file;
    }
}
