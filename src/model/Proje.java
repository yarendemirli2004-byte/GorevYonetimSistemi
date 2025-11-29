package model;
import java.util.ArrayList;
import java.util.List;
/**
 * Bir projeyi temsil eder.
 * Proje, birden fazla görev içerebilir.
 */
public class Proje {
	 private int id;
	    private String ad;
	    private String aciklama;
	    private List<Gorev> gorevler;
/**
 * Yeni bir proje oluşturur.
 *
 * @param id proje kimliği
 * @param ad proje adı
 * @param aciklama proje açıklaması
 */

	    public Proje(int id, String ad, String aciklama) {
	        this.id = id;
	        this.ad = ad;
	        this.aciklama = aciklama;
	        this.gorevler = new ArrayList<>();
	    }
/**
 * Projeye yeni bir görev ekler.
 *
 * @param g eklenecek görev
 */

	    public void gorevEkle(Gorev g) {
	        gorevler.add(g);
	    }

/**
 * Projeye ait görevlerin listesini döndürür.
 *
 * @return görevlerin listesi
 */	    

	    public List<Gorev> getGorevler() {
	        return gorevler;
	    }

	    public String getAd() {
	        return ad;
	    }

	    public String getAciklama() {
	        return aciklama;
	    }
	}


