package model;
import java.time.LocalDateTime;
/**
 * Bir zamanlı görev için son teslim tarihi bilgisini tutar.
 * Hatırlatma gün sayısını da içerir.
 */
public class SonTeslimTarihi {
	private LocalDateTime tarih;
    private int hatirlatmaGunOnce;
 /**
  * Yeni bir son teslim tarihi nesnesi oluşturur.
  *
  * @param tarih görev için son teslim tarihi
  * @param hatirlatmaGunOnce kaç gün önce hatırlatma yapılacağı
  */    

    public SonTeslimTarihi(LocalDateTime tarih, int hatirlatmaGunOnce) {
        this.tarih = tarih;
        this.hatirlatmaGunOnce = hatirlatmaGunOnce;
    }

    public LocalDateTime getTarih() {
        return tarih;
    }

    public void setTarih(LocalDateTime tarih) {
        this.tarih = tarih;
    }

    public int getHatirlatmaGunOnce() {
        return hatirlatmaGunOnce;
    }

    public void setHatirlatmaGunOnce(int hatirlatmaGunOnce) {
        this.hatirlatmaGunOnce = hatirlatmaGunOnce;
    }
 /**
  * Hatırlatma zamanının gelip gelmediğini kontrol eder.
  *
  * @return true ise hatırlatma zamanı gelmiştir
  */
    public boolean isHatirlatmaZamani() {
        LocalDateTime hatirlatmaZamani =
                tarih.minusDays(hatirlatmaGunOnce);
        return LocalDateTime.now().isAfter(hatirlatmaZamani);
    }

    @Override
    public String toString() {
        return "SonTeslimTarihi{" +
                "tarih=" + tarih +
                ", hatirlatmaGunOnce=" + hatirlatmaGunOnce +
                '}';
    }

}



