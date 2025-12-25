package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import model.Kullanici;

public class KullaniciTest {

    private Kullanici kullanici;

    @Before
    public void setUp() {
        kullanici = new Kullanici(1, "Yaren", "yaren@mail.com");
    }

    /* Kullanıcı nesnesi oluşturulabiliyor mu? */
    @Test
    public void testKullaniciOlusturma() {
        assertNotNull(kullanici);
    }

    /* Kullanıcı bilgileri doğru atanıyor mu? */
    @Test
    public void testKullaniciBilgileri() {
        assertEquals("Yaren", kullanici.getAd());
        assertEquals("yaren@mail.com", kullanici.getEmail());
    }
/* Kullanıcı adı güncellenebiliyor mu? */
    @Test
    public void testSetAd() {
        kullanici.setAd("YeniAd");
        assertEquals("YeniAd", kullanici.getAd());
    }

}

