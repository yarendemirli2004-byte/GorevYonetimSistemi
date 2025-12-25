package model;

/**
 * Zaman sınırlı bir görevi temsil eder.
 * Gorev sınıfından miras alır ve ek olarak son teslim tarihi içerir.
 */

public class ZamanlıGorev extends Gorev {
	private SonTeslimTarihi sonTeslimTarihi;
	
	 /**
     * Yeni bir zamanlı görev oluşturur.
     *
     * @param id görev kimliği
     * @param baslik görev başlığı
     * @param aciklama görev açıklaması
     * @param parlaklik görev önceliği
     * @param sonTeslimTarihi teslim tarihi nesnesi
     */	

    public ZamanlıGorev(int id, String baslik, String aciklama, int parlaklik, SonTeslimTarihi sonTeslimTarihi) {
        super(id, baslik, aciklama, parlaklik);
        this.sonTeslimTarihi = sonTeslimTarihi;
    }

    public SonTeslimTarihi getSonTeslimTarihi() {
        return sonTeslimTarihi;
    }

    public void setSonTeslimTarihi(SonTeslimTarihi sonTeslimTarihi) {
        this.sonTeslimTarihi = sonTeslimTarihi;
    }
    
    /**
     * Görevin süresinin geçip geçmediğini kontrol eder.
     *
     * @return true son tarih geçtiyse, false geçmediyse
     */    

    public boolean isOverdue() {
        return sonTeslimTarihi.getTarih().isBefore(java.time.LocalDateTime.now());
    }
    /**
     * Görevin son teslim tarihine kalan gün sayısını hesaplar.
     *
     * @return Kalan gün sayısı, eğer son teslim tarihi yoksa -1 döner
     */
    public long kalanGunSayisi() {
        if (sonTeslimTarihi == null) {
            return -1;
        }

        return java.time.Duration.between(
                java.time.LocalDateTime.now(),
                sonTeslimTarihi.getTarih()
        ).toDays();
    }
}

