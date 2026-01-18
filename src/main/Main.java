package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Bildiri;
import model.Gorev;
import model.Kullanici;
import model.Proje;
import model.SonTeslimTarihi;
import model.ZamanlıGorev;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    /** Tarih/saat formatlayici: yyyy-MM-dd HH:mm */
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /**
     * Uygulama giris noktasi.
     * Kullanici ve proje bilgilerini alir, menu dongusunu calistirir.
     *
     * @param args komut satiri argumanlari (kullanilmaz)
     */
    public static void main(String[] args) {

        System.out.println("===== GOREV YONETIM SISTEMI =====");

        // Bildiri listesi (uygulama logu gibi)
        List<Bildiri> bildiriler = new ArrayList<>();

        // 1) Kullanici bilgilerini kullanicidan al
        int kullaniciId = intOku("Kullanici ID: ");
        String ad = stringOku("Ad: ");
        String email = stringOku("E-posta: ");
        Kullanici kullanici = new Kullanici(kullaniciId, ad, email);
        bildiriler.add(new Bildiri("Kullanici olusturuldu: " + kullanici.getAd() + " (" + kullanici.getEmail() + ")"));

        // 2) Proje bilgilerini kullanicidan al
        int projeId = intOku("Proje ID: ");
        String projeAd = stringOku("Proje Adi: ");
        String projeAciklama = stringOku("Proje Aciklamasi: ");
        Proje proje = new Proje(projeId, projeAd, projeAciklama);
        kullanici.projeEkle(proje);
        bildiriler.add(new Bildiri("Proje olusturuldu: " + proje.getAd() + " (ID=" + proje.getId() + ")"));

        System.out.println();
        System.out.println("Aktif Kullanici: " + kullanici.getAd() + " (" + kullanici.getEmail() + ")");
        System.out.println("Aktif Proje: " + proje.getAd());
        System.out.println();

        boolean running = true;
        while (running) {
            menuYaz();
            int secim = intOku("Secim: ");

            switch (secim) {
                case 1:
                    normalGorevEkle(proje, bildiriler);
                    break;
                case 2:
                    zamanliGorevEkle(proje, bildiriler);
                    break;
                case 3:
                    gorevleriListele(proje);
                    break;
                case 4:
                    gorevTamamla(proje, bildiriler);
                    break;
                case 5:
                    zamanliGorevKontrol(proje, bildiriler);
                    break;
                case 6:
                    gorevSil(proje, bildiriler);
                    break;
                case 7:
                    bildirileriListele(bildiriler);
                    break;
                case 0:
                    bildiriler.add(new Bildiri("Program kapatildi."));
                    running = false;
                    break;
                default:
                    System.out.println("Hatali secim.");
            }
        }

        System.out.println("Program sonlandirildi.");
        sc.close();
    }

    /**
     * Ana menu seceneklerini ekrana basar.
     */
    private static void menuYaz() {
        System.out.println();
        System.out.println("----- MENU -----");
        System.out.println("1) Normal gorev ekle");
        System.out.println("2) Zamanli gorev ekle");
        System.out.println("3) Gorevleri listele");
        System.out.println("4) Gorev tamamla (ID ile)");
        System.out.println("5) Zamanli gorevleri kontrol et (geciken / kalan gun)");
        System.out.println("6) Gorev sil (ID ile)");
        System.out.println("7) Bildirileri listele");
        System.out.println("0) Cikis");
        System.out.println("----------------");
    }

    private static void normalGorevEkle(Proje proje, List<Bildiri> bildiriler) {
        System.out.println();
        System.out.println("[Normal Gorev Ekle]");

        int id = intOku("Gorev ID: ");
        if (idVarMi(proje, id)) {
            System.out.println("Bu ID ile zaten bir gorev var. Farkli bir ID girin.");
            return;
        }

        String baslik = stringOku("Baslik: ");
        String aciklama = stringOku("Aciklama: ");
        int oncelik = intOku("Oncelik Seviyesi (1-5): ");

        Gorev g = new Gorev(id, baslik, aciklama, oncelik);
        proje.gorevEkle(g);

        bildiriler.add(new Bildiri("Normal gorev eklendi: " + g.getBaslik() + " (ID=" + g.getId() + ")"));
        System.out.println("Gorev eklendi.");
    }

    private static void zamanliGorevEkle(Proje proje, List<Bildiri> bildiriler) {
        System.out.println();
        System.out.println("[Zamanli Gorev Ekle]");

        int id = intOku("Gorev ID: ");
        if (idVarMi(proje, id)) {
            System.out.println("Bu ID ile zaten bir gorev var. Farkli bir ID girin.");
            return;
        }

        String baslik = stringOku("Baslik: ");
        String aciklama = stringOku("Aciklama: ");
        int oncelik = intOku("Oncelik Seviyesi (1-5): ");

        System.out.println("Tarih formati: yyyy-MM-dd HH:mm (ornek: 2026-01-13 18:30)");
        String tarihStr = stringOku("Son teslim tarihi: ");

        LocalDateTime deadline;
        try {
            deadline = LocalDateTime.parse(tarihStr, FMT);
        } catch (Exception e) {
            System.out.println("Tarih formati hatali. Ornek: 2026-01-13 18:30");
            return;
        }

        int hatirlatmaGunOnce = intOku("Kac gun once hatirlatsin?: ");
        SonTeslimTarihi st = new SonTeslimTarihi(deadline, hatirlatmaGunOnce);

        ZamanlıGorev zg = new ZamanlıGorev(id, baslik, aciklama, oncelik, st);
        proje.gorevEkle(zg);

        bildiriler.add(new Bildiri("Zamanli gorev eklendi: " + zg.getBaslik()
                + " (ID=" + zg.getId() + ", Deadline=" + deadline.format(FMT) + ")"));
        System.out.println("Zamanli gorev eklendi.");
    }

    private static void gorevleriListele(Proje proje) {
        System.out.println();
        System.out.println("[Gorevleri Listele]");

        if (proje.getGorevler().isEmpty()) {
            System.out.println("Listelenecek gorev yok.");
            return;
        }

        for (Gorev g : proje.getGorevler()) {
            String tip = (g instanceof ZamanlıGorev) ? "ZAMANLI" : "NORMAL";

            String satir = "ID=" + g.getId()
                    + " | Tip=" + tip
                    + " | Baslik=" + g.getBaslik()
                    + " | Oncelik=" + g.getoncelikSeviyesi()
                    + " | Tamamlandi=" + g.isCompleted();

            if (g instanceof ZamanlıGorev zg) {
                if (zg.getSonTeslimTarihi() != null && zg.getSonTeslimTarihi().getTarih() != null) {
                    satir += " | Deadline=" + zg.getSonTeslimTarihi().getTarih().format(FMT);
                } else {
                    satir += " | Deadline=(yok)";
                }
            }

            System.out.println(satir);
        }
    }

    private static void gorevTamamla(Proje proje, List<Bildiri> bildiriler) {
        System.out.println();
        System.out.println("[Gorev Tamamla]");

        if (proje.getGorevler().isEmpty()) {
            System.out.println("Tamamlanacak gorev yok.");
            return;
        }

        int id = intOku("Tamamlanacak gorev ID: ");
        Gorev hedef = gorevBul(proje, id);

        if (hedef == null) {
            System.out.println("Bu ID ile gorev bulunamadi.");
            return;
        }

        if (hedef.isCompleted()) {
            System.out.println("Gorev zaten tamamlanmis.");
            return;
        }

        hedef.complete();
        bildiriler.add(new Bildiri("Gorev tamamlandi: " + hedef.getBaslik() + " (ID=" + hedef.getId() + ")"));
        System.out.println("Gorev tamamlandi.");
    }

    /**
     * Zamanli gorevleri gecikme/kalan gun acisindan kontrol eder ve gerekirse bildiri uretir.
     *
     * @param proje gorevlerin bulundugu proje
     * @param bildiriler log/bildiri listesi
     */
    private static void zamanliGorevKontrol(Proje proje, List<Bildiri> bildiriler) {
        System.out.println();
        System.out.println("[Zamanli Gorev Kontrolu]");

        boolean zamanliVar = false;

        for (Gorev g : proje.getGorevler()) {
            if (g instanceof ZamanlıGorev zg) {
                zamanliVar = true;

                if (zg.getSonTeslimTarihi() == null || zg.getSonTeslimTarihi().getTarih() == null) {
                    System.out.println("Baslik=" + zg.getBaslik() + " | Son teslim tarihi yok.");
                    bildiriler.add(new Bildiri("Uyari: Zamanli gorevde son teslim tarihi yok: " + zg.getBaslik()
                            + " (ID=" + zg.getId() + ")"));
                    continue;
                }

                String deadline = zg.getSonTeslimTarihi().getTarih().format(FMT);

                if (zg.isOverdue()) {
                    System.out.println("GECIKMIS | Baslik=" + zg.getBaslik() + " | Deadline=" + deadline);
                    bildiriler.add(new Bildiri("Gecikmis gorev bulundu: " + zg.getBaslik()
                            + " (ID=" + zg.getId() + ", Deadline=" + deadline + ")"));
                } else {
                    long kalanGun = zg.kalanGunSayisi();
                    System.out.println("ZAMANINDA | Baslik=" + zg.getBaslik()
                            + " | KalanGun=" + kalanGun
                            + " | Deadline=" + deadline);

                    // Hatirlatma gun mantigini da kullan (bildiri uretmek icin)
                    int hatirlatmaGunOnce = zg.getSonTeslimTarihi().getHatirlatmaGunOnce();
                    if (kalanGun >= 0 && kalanGun <= hatirlatmaGunOnce) {
                        bildiriler.add(new Bildiri("Hatirlatma: " + zg.getBaslik()
                                + " gorevinin teslimine " + kalanGun + " gun kaldi. Deadline=" + deadline));
                    }
                }
            }
        }

        if (!zamanliVar) {
            System.out.println("Zamanli gorev yok.");
        }
    }

    private static void gorevSil(Proje proje, List<Bildiri> bildiriler) {
        System.out.println();
        System.out.println("[Gorev Sil]");

        if (proje.getGorevler().isEmpty()) {
            System.out.println("Silinecek gorev yok.");
            return;
        }

        int id = intOku("Silinecek gorev ID: ");
        Gorev hedef = gorevBul(proje, id);

        if (hedef == null) {
            System.out.println("Bu ID ile gorev bulunamadi.");
            return;
        }

        boolean silindi = proje.gorevSil(hedef);
        if (silindi) {
            bildiriler.add(new Bildiri("Gorev silindi: " + hedef.getBaslik() + " (ID=" + hedef.getId() + ")"));
            System.out.println("Gorev silindi.");
        } else {
            System.out.println("Gorev silinemedi.");
        }
    }

    private static void bildirileriListele(List<Bildiri> bildiriler) {
        System.out.println();
        System.out.println("[Bildiriler]");

        if (bildiriler.isEmpty()) {
            System.out.println("Bildiri yok.");
            return;
        }

        for (Bildiri b : bildiriler) {
            System.out.println(b.getTarihSaat().format(FMT) + " | " + b.getMesaj());
        }
    }

    // ---------------- Yardimci metodlar ----------------

    private static Gorev gorevBul(Proje proje, int id) {
        for (Gorev g : proje.getGorevler()) {
            if (g.getId() == id) return g;
        }
        return null;
    }

    private static boolean idVarMi(Proje proje, int id) {
        return gorevBul(proje, id) != null;
    }

    private static int intOku(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Gecersiz sayi girdiniz.");
            }
        }
    }

    private static String stringOku(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            if (s != null) {
                s = s.trim();
                if (!s.isEmpty()) return s;
            }
            System.out.println("Bos gecilemez.");
        }
    }
}
