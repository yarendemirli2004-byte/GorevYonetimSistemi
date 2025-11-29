package model;
import java.time.LocalDateTime;

/**
 * Görevlerle ilgili bilgilendirme mesajlarını temsil eder.
 */
public class Bildiri {
	private String mesaj;
    private LocalDateTime tarihSaat;
/**
 * Yeni bir bildiri oluşturur.
 *
 * @param mesaj gösterilecek bildiri mesajı
 */
    public Bildiri(String mesaj) {
        this.mesaj = mesaj;
        this.tarihSaat = LocalDateTime.now();
    }

    public String getMesaj() {
        return mesaj;
    }

    public LocalDateTime getTarihSaat() {
        return tarihSaat;
    }
}
