package model;
import interfaces.Completable;
/**
 * Sistemdeki temel görev yapısını temsil eder.
 * Bir görev başlık, açıklama ve öncelik seviyesi bilgisi içerir.
 */

public class Gorev implements Completable {

    private int id;
    private String baslik;
    private String aciklama;
    private int oncelikSeviyesi;
    private boolean tamamlandi;
    
    /**
     * Yeni bir görev oluşturur.
     *
     * @param id görevin benzersiz kimliği
     * @param baslik görev başlığı
     * @param aciklama görev açıklaması
     * @param görev öncelik seviyesi
     */    
    
   
    public Gorev(int id, String baslik, String aciklama, int oncelikSeviyesi) {
        this.id = id;
        this.baslik = baslik;
        this.aciklama = aciklama;
        this.oncelikSeviyesi = oncelikSeviyesi;
        this.tamamlandi = false;
    }
    /**
     * Görevin benzersiz kimlik numarasını döndürür.
     *
     * @return görev kimliği
     */   

    public int getId() {
	    return id;
	}
    /**
     * Göreve ait açıklama bilgisini döndürür.
     *
     * @return görev açıklaması
     */
	public String getAciklama() {
	    return aciklama;
	}
	/**
	 * Görevin açıklama bilgisini günceller.
	 *
	 * @param aciklama yeni görev açıklaması
	 */	
	public void setAciklama(String aciklama) {
	    this.aciklama = aciklama;
	}

	/**
	 * Görevi tamamlanmış olarak işaretler.
	 */
    public void complete() {
        this.tamamlandi = true;
    }
    /**
     * Görevin tamamlanma durumunu döndürür.
     *
     * @return görev tamamlandıysa true, aksi halde false
     */
 @Override

    public boolean isCompleted() {
        return tamamlandi;
    }
 @Override
 public String toString() {
     return "Gorev{id=" + id +
            ", baslik='" + baslik + '\'' +
            ", oncelik=" + oncelikSeviyesi +
            ", tamamlandi=" + tamamlandi + "}";
 }
 /**
  * Görevin başlık bilgisini döndürür.
  *
  * @return görev başlığı
  */
    public String getBaslik() {
        return baslik;
    }
    /**
     * Görevin başlık bilgisini günceller.
     *
     * @param baslik yeni görev başlığı
     */
    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public int getoncelikSeviyesi() {
        return oncelikSeviyesi;
    }

    public void setoncelikSeviyesi(int oncelikSeviyesi) {
        this.oncelikSeviyesi = oncelikSeviyesi;
    }
}

