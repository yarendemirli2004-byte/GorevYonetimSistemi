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

}
