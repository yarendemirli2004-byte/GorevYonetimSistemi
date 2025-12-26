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
    @Test
    public void birden_fazla_gorev_eklenebilmeli() {
        Proje proje = new Proje(1, "Test Projesi", "Açıklama");

        Gorev g1 = new Gorev(1, "Görev 1", "Açıklama 1", 2);
        Gorev g2 = new Gorev(2, "Görev 2", "Açıklama 2", 4);

        proje.gorevEkle(g1);
        proje.gorevEkle(g2);

        assertEquals(2, proje.getGorevler().size());
    }
  
}

