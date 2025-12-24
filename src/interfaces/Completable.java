package interfaces;
/**
 * Tamamlanabilir görevlerin ortak davranışını tanımlar.
 */
public interface Completable {
/**
 * Görevi tamamlanmış olarak işaretler.
 */
	void complete();
	/**
     * Görevin tamamlanıp tamamlanmadığını döndürür.
     * @return true tamamlandıysa, false tamamlanmadıysa
     */	
	boolean isCompleted();
/**
 * Görevin durumunu ekrana yazdırır.
 */
    default void printStatus() {
        if (isCompleted()) {
            System.out.println("Görev tamamlandı.");
        } else {
            System.out.println("Görev henüz tamamlanmadı.");
        }
    }
}
