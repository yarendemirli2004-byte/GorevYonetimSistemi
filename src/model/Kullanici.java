package model;

import java.util.ArrayList;
import java.util.List;
/**
 * Sistemi kullanan kullanıcıyı temsil eder.
 * Kullanıcı birden fazla projeye sahip olabilir.
 */
public class Kullanici {
	 private int id;
	    private String ad;
	    private String email;
	    private List<Proje> projeler;
 /**
  * Yeni bir kullanıcı oluşturur.
  *
  * @param id kullanıcı kimliği
  * @param ad kullanıcı adı
  * @param email kullanıcı e-posta adresi
  */
	    public Kullanici(int id, String ad, String email) {
	        this.id = id;
	        this.ad = ad;
	        this.email = email;
	        this.projeler = new ArrayList<>();
	    }
/**
 * Projenin benzersiz kimliğini döndürür.
 * @return proje kimliği
 */
	    public int getId() {
        	return id;
        }
        public String getEmail() {
        	return email;	
        }
/**
 * Kullanıcıya proje ekler.
 *
 * @param p eklenecek proje
 */
       
	    public void projeEkle(Proje p) {
	        projeler.add(p);
	    }
 /**
  * Kullanıcının projelerinin listesini döndürür.
  *
  * @return proje listesi
  */
	    public List<Proje> getProjeler() {
	        return projeler;
	    }

	    public String getAd() {
	        return ad;
	    }
/**
 * Kullanıcının adını günceller.
 *
 * @param yeniAd yeni kullanıcı adı
 */
	    public void setAd(String yeniAd) {
	        if (yeniAd != null && !yeniAd.trim().isEmpty()) {
	            this.ad = yeniAd.trim();
	        }
	    }

}
