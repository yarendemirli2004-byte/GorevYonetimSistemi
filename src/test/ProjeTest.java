package test;
import model.Gorev;
import model.Proje;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Proje sınıfında görev ekleme iş mantığını test eder.
 */
public class ProjeTest {

    @Test
    public void gorevEkle_gorev_listesine_eklenmeli() {
        Proje proje = new Proje(1, "Test Projesi", "Açıklama");
        Gorev gorev = new Gorev(1, "Test Görevi", "Açıklama", 3);

        // Liste başta boş olmalı
        assertEquals(0, proje.getGorevler().size());

        // Görevi ekle
        proje.gorevEkle(gorev);

        // Artık 1 görev olmalı
        assertEquals(1, proje.getGorevler().size());
        // Bu görev de az önce eklediğimiz görev olmalı
        assertEquals(gorev, proje.getGorevler().get(0));
    }
}

