package nomanssave;

import java.util.ArrayList;

class fZ implements SaveSlot {
   final int lT;
   // $FF: synthetic field
   final XboxSaveLocation mN;

   fZ(XboxSaveLocation var1, int var2) {
      this.mN = var1;
      this.lT = var2;
   }

   public int getIndex() {
      return this.lT;
   }

   public boolean isEmpty() {
      return XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2] == null && XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2 + 1] == null;
   }

   public SaveFile[] bX() {
      Logger.info("Loading saves for Slot " + (this.lT + 1) + "...");
      ArrayList var1 = new ArrayList();
      if (XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2] != null) {
         var1.add(XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2]);
      }

      if (XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2 + 1] != null) {
         var1.add(XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2 + 1]);
      }

      AppSettings.cG.listFiles(new ga(this, var1));
      var1.sort(new gb(this));
      return (SaveFile[])var1.toArray(new SaveFile[0]);
   }

   public GameMode L() {
      long var1 = Long.MIN_VALUE;
      GameMode var3 = null;
      if (XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2] != null) {
         var3 = XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2].L();
         var1 = XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2].lastModified();
      }

      if (XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2 + 1] != null) {
         long var4 = XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2 + 1].lastModified();
         if (var4 > var1) {
            var3 = XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2 + 1].L();
         }
      }

      return var3;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Slot " + (this.lT + 1) + " - ");
      long var2 = Long.MIN_VALUE;
      GameMode var4 = null;
      if (XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2] != null) {
         var4 = XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2].L();
         var2 = XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2].lastModified();
      }

      if (XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2 + 1] != null) {
         long var5 = XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2 + 1].lastModified();
         if (var5 > var2) {
            var4 = XboxSaveLocation.access$getSaveFiles(this.mN)[this.lT * 2 + 1].L();
            var2 = var5;
         }
      }

      if (var4 != null) {
         var1.append(var4.toString());
         var1.append(" - " + Application.formatDateShort(var2));
      } else {
         var1.append("[EMPTY]");
      }

      return var1.toString();
   }

   // $FF: synthetic method
   static XboxSaveLocation access$getXboxSaveLocation(fZ var0) {
      return var0.mN;
   }
}
