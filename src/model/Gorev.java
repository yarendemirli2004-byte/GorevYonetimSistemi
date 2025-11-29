package model;
import interfaces.Completable;
/**
 * Sistemdeki temel görev yapısını temsil eder.
 * Bir görev başlık, açıklama ve parlaklık bilgisi içerir.
 */

public class Gorev implements Completable {

    private int id;
    private String baslik;
    private String aciklama;
    private int parlaklik;
    private boolean tamamlandi;
    
    /**
     * Yeni bir görev oluşturur.
     *
     * @param id görevin benzersiz kimliği
     * @param baslik görev başlığı
     * @param aciklama görev açıklaması
     * @param parlaklik görev öncelik seviyesi
     */    
    
   
    public Gorev(int id, String baslik, String aciklama, int parlaklik) {
        this.id = id;
        this.baslik = baslik;
        this.aciklama = aciklama;
        this.parlaklik = parlaklik;
        this.tamamlandi = false;
    }
 /** {@inheritDoc} */
 @Override   

    public void complete() {
        this.tamamlandi = true;
    }
 /** {@inheritDoc} */
 @Override

    public boolean isCompleted() {
        return tamamlandi;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public int getParlaklik() {
        return parlaklik;
    }

    public void setParlaklik(int parlaklik) {
        this.parlaklik = parlaklik;
    }
}

