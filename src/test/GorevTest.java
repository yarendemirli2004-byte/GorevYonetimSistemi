package test;
import model.Gorev;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Gorev sınıfının iş mantığını test eder:
 * complete() çağrıldığında görevin tamamlanması.
 */
public class GorevTest {

    @Test
    public void complete_cagirildiginda_gorev_tamamlanmis_olmali() {
        // Arrange - başlangıç durumu
        Gorev gorev = new Gorev(1, "Test Görevi", "Açıklama", 3);

        // İlk başta tamamlanmamış olmalı
        assertFalse(gorev.isCompleted());

        // Act - metodu çalıştır
        gorev.complete();

        // Assert - sonuç beklendiği gibi mi?
        assertTrue(gorev.isCompleted());
    }
}

