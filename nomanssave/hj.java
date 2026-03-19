package nomanssave;

import java.io.IOException;
import java.util.Arrays;

class hj extends Thread {
   final long sK;
   String sL;

   hj(long var1) {
      this.sK = var1;
      this.sL = AppSettings.getProperty("KnownPlayers." + var1);
      hi.VehiclesPanel().put(var1, this);
      this.start();
   }

   public void run() {
      String var1;
      try {
         var1 = hi.j(this.sK);
      } catch (IOException var7) {
         Logger.error("Steam lookup error", var7);
         var1 = null;
      }

      synchronized(hi.VehiclesPanel()) {
         if (var1 != null) {
            Long[] var3 = (Long[])AppSettings.AboutDialog("SteamIDs", Long.class);
            boolean var4 = Arrays.asList(var3).stream().anyMatch((var1x) -> {
               return var1x.equals(this.sK);
            });
            if (!var4) {
               Long[] var5 = new Long[var3.length + 1];
               System.arraycopy(var3, 0, var5, 0, var3.length);
               var5[var3.length] = this.sK;
               AppSettings.AboutDialog("SteamIDs", (Object[])var5);
            }

            if (!var1.equals(this.sL)) {
               AppSettings.setProperty("KnownPlayers." + this.sK, var1);
               this.sL = var1;
            }
         }

      }
   }
}
