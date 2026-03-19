package nomanssave;

import java.util.ArrayList;

class fN implements SaveSlot {
   final int lT;
   // $FF: synthetic field
   final SteamSaveLocation mt;

   fN(SteamSaveLocation var1, int var2) {
      this.mt = var1;
      this.lT = var2;
   }

   public int getIndex() {
      return this.lT;
   }

   public boolean isEmpty() {
      return SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2] == null && SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2 + 1] == null;
   }

   public SaveFile[] bX() {
      Logger.info("Loading saves for Slot " + (this.lT + 1) + "...");
      ArrayList var1 = new ArrayList();
      if (SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2] != null) {
         var1.add(SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2]);
      }

      if (SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2 + 1] != null) {
         var1.add(SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2 + 1]);
      }

      AppSettings.cG.listFiles(new fO(this, var1));
      var1.sort(new fP(this));
      return (SaveFile[])var1.toArray(new SaveFile[0]);
   }

   public GameMode L() {
      long var1 = Long.MIN_VALUE;
      GameMode var3 = null;
      if (SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2] != null) {
         var3 = SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2].L();
         var1 = SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2].lastModified();
      }

      if (SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2 + 1] != null) {
         long var4 = SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2 + 1].lastModified();
         if (var4 > var1) {
            var3 = SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2 + 1].L();
         }
      }

      return var3;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Slot " + (this.lT + 1) + " - ");
      long var2 = Long.MIN_VALUE;
      String var4 = null;
      GameMode var5 = null;
      if (SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2] != null) {
         var5 = SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2].L();
         var2 = SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2].lastModified();
         var4 = SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2].getName();
      }

      if (SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2 + 1] != null) {
         long var6 = SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2 + 1].lastModified();
         if (var6 > var2) {
            var5 = SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2 + 1].L();
            var2 = var6;
            var4 = SteamSaveLocation.access$getSaveFiles(this.mt)[this.lT * 2 + 1].getName();
         }
      }

      if (var5 != null) {
         var1.append(var5.toString());
         if (var4 != null) {
            var1.append(" - " + var4);
         } else {
            var1.append(" - " + Application.formatDateShort(var2));
         }
      } else {
         var1.append("[EMPTY]");
      }

      return var1.toString();
   }

   // $FF: synthetic method
   static SteamSaveLocation access$getSteamSaveLocation(fN var0) {
      return var0.mt;
   }
}
