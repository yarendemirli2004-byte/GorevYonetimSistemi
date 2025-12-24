package test;
import model.Gorev;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Completable arayüzünün Gorev sınıfında
 * doğru çalışıp çalışmadığını test eder.
 */

public class CompletableTest {

@Test
public void gorevCompleteCagrildigindaTamamlanmisOlmali() {
        Gorev gorev = new Gorev(
        1,
        "Test Görevi",
        "Completable test açıklaması",
        3
        );
 assertFalse(gorev.isCompleted());
  gorev.complete();
  assertTrue(gorev.isCompleted());
}
}
        		
