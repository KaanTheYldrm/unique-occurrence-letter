import exception.InvalidCharacterException;
import exception.MaximumCharacterLengthException;
import exception.MinimumCharacterLengthException;
import org.junit.Before;
import org.junit.Test;
import service.FileService;
import service.WordService;
import service.impl.OccurrenceFileService;
import service.impl.WordServiceImpl;

public class FileServiceTest {

    public FileService fileService;

    @Before
    public void setUp() {
        WordService wordService = new WordServiceImpl();
        fileService = new OccurrenceFileService(wordService);
    }

    @Test(expected = InvalidCharacterException.class)
    public void shouldThrowsInvalidExceptionCharacterException() throws Exception {
        fileService.getFileAndProcess(new String[]{"fileForInvalidCharacter.txt"});
    }

    @Test(expected = MinimumCharacterLengthException.class)
    public void shouldThrowsMinimumCharacterLengthException() throws Exception {
        fileService.getFileAndProcess(new String[]{"fileForMinimumLength.txt"});
    }

    @Test(expected = MaximumCharacterLengthException.class)
    public void shouldThrowsMaximumCharacterLengthException() throws Exception {
        fileService.getFileAndProcess(new String[]{"fileForMaximumLength.txt"});
    }
}
