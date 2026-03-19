package nomanssave;

import java.io.File;
import java.io.IOException;

class fM extends SteamSaveFileMetadata implements SaveFile {
   GameMode me;
   // $FF: synthetic field
   final SteamSaveLocation mt;

   fM(SteamSaveLocation var1, int var2) {
      super(var1, var2 == 0 ? "save.hg" : "save" + (var2 + 1) + ".hg", var2, true);
      this.mt = var1;

      try {
         String var3 = new String(this.ah(65536));
         this.me = GameMode.T(var3);
      } catch (IOException var4) {
         Logger.error("Could not read game mode from " + this.filename, var4);
      }

   }

   fM(SteamSaveLocation var1, int var2, JsonObject var3) {
      super(var1, var2 == 0 ? "save.hg" : "save" + (var2 + 1) + ".hg", var2, false);
      this.mt = var1;
      this.me = GameMode.i(var3);
      this.AboutDialog(var3, true);
   }

   public GameMode L() {
      return this.me;
   }

   public JsonObject M() {
      return this.AboutDialog(eG.jV);
   }

   void cm() {
      this.AboutDialog(this.lO == 0 ? "backup" : "backup" + (this.lO + 1), this.me, this.getName(), this.getDescription());
      (new File(SteamSaveLocation.AboutDialog(this.mt), this.filename)).delete();
      (new File(SteamSaveLocation.AboutDialog(this.mt), "mf_" + this.filename)).delete();
   }

   public String writeToFile(JsonObject var1) {
      this.AboutDialog(this.lO == 0 ? "backup" : "backup" + (this.lO + 1), this.me, this.getName(), this.getDescription());
      this.mx.Y(var1.getValueAsString("CommonStateData.SaveName"));
      this.me = GameMode.i(var1);
      this.mx.al((int)var1.K("CommonStateData.TotalPlayTime"));
      this.AboutDialog(var1, true);
      return this.filename;
   }

   public String toString() {
      return this.filename;
   }

   public String getName() {
      return this.mx.ck();
   }

   public String getDescription() {
      return this.mx.getDescription();
   }
}
