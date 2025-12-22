package main;

import java.time.LocalDateTime;

import model.Gorev;
import model.Kullanici;
import model.Proje;
import model.SonTeslimTarihi;
import model.ZamanlıGorev;

/**
 * Görev Yönetim Sistemi çalıştırma sınıfı.
 * Bu sınıf, tüm minimum gereksinimlerin (görev oluşturma, atama,
 * tamamlama ve yaklaşan görevleri listeleme) örnek olarak
 * çalıştırıldığı ana sınıftır.
 */

public class Main {
/**
 * Programın başlangıç noktası. Örnek bir kullanıcı, proje ve
 * görevler oluşturarak sistemin temel özelliklerini gösterir.
 *
 * @param args komut satırı argümanları
 */	

    public static void main(String[] args) {

        System.out.println("===== GÖREV YÖNETİM SİSTEMİ =====");

        // 1) KULLANICI OLUŞTURMA
        Kullanici kullanici = new Kullanici(1, "Yaren", "yaren@example.com");
        System.out.println("Kullanıcı oluşturuldu: " + kullanici.getAd());

        // 2) PROJE OLUŞTURMA
        Proje proje = new Proje(1, "OOP Projesi", "Görev ve proje yönetim sistemi");
        kullanici.projeEkle(proje);
        System.out.println("Proje oluşturuldu: " + proje.getAd());

        // 3) NORMAL GÖREV OLUŞTURMA
        Gorev gorev1 = new Gorev(1, "UML Diyagramlarını Çiz",
                "Sınıf ve Use-Case diyagramlarını oluştur", 3);

        // PROJEYE GÖREV EKLEME
        proje.gorevEkle(gorev1);
        System.out.println("Görev eklendi: " + gorev1.getBaslik());

        // 4) ZAMANLI GÖREV OLUŞTURMA
        SonTeslimTarihi tarih = new SonTeslimTarihi(
                LocalDateTime.now().plusDays(2), // 2 gün sonrası
                1                                   // 1 gün önce hatırlatma
        );

        ZamanlıGorev gorev2 = new ZamanlıGorev(2, "Java Kodlarını Yaz",
                "Sınıfları UML diyagramına uygun olarak oluştur", 5, tarih);

        // ZAMANLI GÖREVİ PROJEYE EKLEME
        proje.gorevEkle(gorev2);
        System.out.println("Zamanlı görev eklendi: " + gorev2.getBaslik());

        // 5) GÖREV TAMAMLAMA (MIN. ÖZELLİK 3)
        gorev1.complete();
        System.out.println("Görev TAMAMLANDI: " + gorev1.getBaslik());

        // 6) TÜM GÖREVLERİ LİSTELEME
        System.out.println("\nProjeye ait tüm görevler:");
        for (Gorev g : proje.getGorevler()) {
            System.out.println("- " + g.getBaslik()
                    + " | Tamamlandı mı? " + g.isCompleted());
        }

        // 7) YAKLAŞAN GÖREVLERİ LİSTELEME (MIN. ÖZELLİK 4)
        System.out.println("\nYaklaşan görev kontrolü:");
        if (gorev2.isOverdue()) {
            System.out.println("- " + gorev2.getBaslik() + " → SÜRESİ GEÇMİŞ!");
        } else {
            System.out.println("- " + gorev2.getBaslik() + " → Süresi henüz geçmedi.");
        }

        System.out.println("===== PROGRAM BİTTİ =====");
    }
}