package test;

import model.ZamanlıGorev;
import model.SonTeslimTarihi;

import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

public class ZamanlıGorevTest {

    /* Zamanlı görev nesnesi oluşturulabiliyor mu? */
    @Test
    public void zamanliGorev_olusturulabiliyor_mu() {
        SonTeslimTarihi sonTeslim =
                new SonTeslimTarihi(LocalDateTime.now().plusDays(1), 1);

        ZamanlıGorev gorev =
                new ZamanlıGorev(1, "Zamanli Gorev", "Test aciklama", 2, sonTeslim);

        assertNotNull(gorev);
        assertNotNull(gorev.getSonTeslimTarihi());
        assertEquals(1, gorev.getSonTeslimTarihi().getHatirlatmaGunOnce());
    }

    /* Son teslim tarihi gelecekteyse isOverdue FALSE olmalı */
    @Test
    public void isOverdue_sonTarihGelecekteyse_false() {
        SonTeslimTarihi sonTeslim =
                new SonTeslimTarihi(LocalDateTime.now().plusDays(1), 1);

        ZamanlıGorev gorev =
                new ZamanlıGorev(2, "Baslik", "Aciklama", 1, sonTeslim);

        assertFalse(gorev.isOverdue());
    }

    /* Son teslim tarihi geçmişteyse isOverdue TRUE olmalı */
    @Test
    public void isOverdue_sonTarihGecmisteyse_true() {
        SonTeslimTarihi sonTeslim =
                new SonTeslimTarihi(LocalDateTime.now().minusDays(1), 1);

        ZamanlıGorev gorev =
                new ZamanlıGorev(3, "Baslik", "Aciklama", 1, sonTeslim);

        assertTrue(gorev.isOverdue());
    }
}
