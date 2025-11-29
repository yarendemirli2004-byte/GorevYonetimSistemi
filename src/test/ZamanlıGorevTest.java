package test;
import model.SonTeslimTarihi;
import model.ZamanlıGorev;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

/**
 * Zamanlı görevlerin son tarih mantığını test eder.
 */
public class ZamanlıGorevTest {

    @Test
    public void isOverdue_gecmisTarihIcin_true_donmeli() {
        LocalDateTime gecmis = LocalDateTime.now().minusDays(1);
        SonTeslimTarihi st = new SonTeslimTarihi(gecmis, 1);

        ZamanlıGorev gorev = new ZamanlıGorev(
                1,
                "Geçmiş Görev",
                "Dün bitmeliydi",
                3,
                st
        );

        assertTrue(gorev.isOverdue());
    }

    @Test
    public void isOverdue_gelecekTarihIcin_false_donmeli() {
        LocalDateTime gelecek = LocalDateTime.now().plusDays(2);
        SonTeslimTarihi st = new SonTeslimTarihi(gelecek, 1);

        ZamanlıGorev gorev = new ZamanlıGorev(
                2,
                "Gelecek Görev",
                "Yarın/Tomorrow",
                4,
                st
        );

        assertFalse(gorev.isOverdue());
    }
}

