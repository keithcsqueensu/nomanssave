package nomanssave;

import java.io.File;
import java.io.IOException;

public class FileWatcher {
   private static final Object lock = new Object();
   private static FileWatcherThread lj;

   public static void AboutDialog(SaveLocation var0, File var1) {
      synchronized(lock) {
         try {
            if (lj == null) {
               lj = new FileWatcherThread();
            }

            lj.AboutDialog(var0, var1);
         } catch (IOException var4) {
            Logger.AboutDialog("Unable to register storage", var4);
         }

      }
   }

   public static void AboutDialogCloseListener(SaveLocation var0) {
      synchronized(lock) {
         try {
            if (lj != null) {
               lj.AboutDialogCloseListener(var0);
            }
         } catch (IOException var3) {
            Logger.AboutDialog("Unable to unregister storage", var3);
         }

      }
   }

   // $FF: synthetic method
   static Object bQ() {
      return lock;
   }
}
