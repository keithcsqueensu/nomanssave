package nomanssave;

public interface SaveChangeListener {
   void onSaveLocationChanged(SaveLocation var1);

   void onFileChanged(SaveLocation var1, int var2, String var3);
}
