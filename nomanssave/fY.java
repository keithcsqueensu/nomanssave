package nomanssave;

import java.io.IOException;
import java.util.regex.Matcher;

class fY extends XboxContainerWriter implements SaveFile {
   final int lO;
   GameMode me;
   String na;
   // $FF: synthetic field
   final XboxSaveLocation mN;

   fY(XboxSaveLocation var1, int var2) {
      super(var1, "Slot" + (var2 / 2 + 1) + (var2 % 2 == 0 ? "Auto" : "Manual"));
      this.mN = var1;
      this.lO = var2;

      try {
         String var3 = new String(this.ah(1048576));
         Matcher var4 = XboxSaveLocation.cl().matcher(var3);
         if (var4.find()) {
            this.na = var4.group(3);
         }

         this.me = GameMode.T(var3);
      } catch (IOException var5) {
         Logger.AboutDialog("Could not read game mode from " + this.mO.name, var5);
      }

   }

   fY(XboxSaveLocation var1, fV var2, JsonObject var3) {
      super(var1, var2);
      this.mN = var1;
      this.lO = var2.mb;
      this.mZ.AboutDialog(var2.mQ);
      int var4 = XboxSaveLocation.ao(var3.J("Version"));
      if (var4 != 0) {
         this.mZ.setVersion(var4);
      }

      this.na = var3.getValueAsString("CommonStateData.SaveName");
      if (this.na != null) {
         this.mZ.Y(this.na);
      }

      this.me = GameMode.i(var3);
      long var5 = var3.K("PlayerStateData.TotalPlayTime");
      if (var5 != 0L) {
         this.mZ.d(var5);
      }

      this.h(var3);
   }

   public GameMode L() {
      return this.me;
   }

   public long lastModified() {
      return this.mO.timestamp;
   }

   public JsonObject M() {
      return this.AboutDialog(eG.jV);
   }

   public String AboutDialogCloseListener(JsonObject var1) {
      this.AboutDialog(this.lO == 0 ? "wgsbackup" : "wgsbackup" + (this.lO + 1), this.me);
      int var2 = XboxSaveLocation.ao(var1.J("Version"));
      if (var2 != 0) {
         this.mZ.setVersion(var2);
      }

      this.na = var1.getValueAsString("CommonStateData.SaveName");
      if (this.na != null) {
         this.mZ.Y(this.na);
      }

      this.me = GameMode.i(var1);
      long var3 = var1.K("PlayerStateData.TotalPlayTime");
      if (var3 != 0L) {
         this.mZ.d(var3);
      }

      this.h(var1);
      return this.mO.filename;
   }

   public String toString() {
      return this.mO.name;
   }

   public String getName() {
      return this.na;
   }

   public String getDescription() {
      return this.mZ.getDescription();
   }
}
