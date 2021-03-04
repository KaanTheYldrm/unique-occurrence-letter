import service.FileService;
import service.WordService;
import service.impl.OccurrenceFileService;
import service.impl.WordServiceImpl;

public class App {

    private static final FileService fileService = initializeService();

    public static void main (String[] args) {
        try {
            fileService.getFileAndProcess(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static FileService initializeService() {
        WordService wordService = new WordServiceImpl();
        return new OccurrenceFileService(wordService);
    }
}
