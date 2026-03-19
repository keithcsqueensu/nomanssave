package nomanssave;

import java.io.File;
import java.io.IOException;

public class FileWatcher {
   private static final Object lock = new Object();
   private static FileWatcherThread lj;

   public static void register(SaveLocation var0, File var1) {
      synchronized(lock) {
         try {
            if (lj == null) {
               lj = new FileWatcherThread();
            }

            lj.fileChanged(var0, var1);
         } catch (IOException var4) {
            Logger.error("Unable to register storage", var4);
         }

      }
   }

   public static void unregister(SaveLocation var0) {
      synchronized(lock) {
         try {
            if (lj != null) {
               lj.unregister(var0);
            }
         } catch (IOException var3) {
            Logger.error("Unable to unregister storage", var3);
         }

      }
   }

   // $FF: synthetic method
   static Object bQ() {
      return lock;
   }
}
