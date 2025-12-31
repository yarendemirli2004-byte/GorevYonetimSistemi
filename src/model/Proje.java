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
	    public int getId() {
        	return id;
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
 * Projeden bir görevi siler.
 *
 * @param g silinecek görev
 * 
 * @return görev silindiyse true, aksi halde false
 */
	    public boolean gorevSil(Gorev g) {
	        return gorevler.remove(g);
	    }
	    

/**
 * Projeye ait görevlerin listesini döndürür.
 *
 * @return görevlerin listesi
 */	    

	    public List<Gorev> getGorevler() {
	        return gorevler;
	    }
/**
 * Projeye ait toplam görev sayısını döndürür.
 *
 * @return görev sayısı
 */
	    public int gorevSayisi() {
	        return gorevler.size();
	    }
	    public String getAd() {
	        return ad;
	    }

	    public String getAciklama() {
	        return aciklama;
	    }
	}


