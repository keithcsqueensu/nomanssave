package nomanssave;

import java.io.IOException;

class fD extends fH implements SaveFile {
   final int lO;
   GameMode me;
   // $FF: synthetic field
   final PS4SaveLocation ma;

   fD(PS4SaveLocation var1, int var2) {
      super(var1, "savedata" + (var2 < 8 ? "0" : "") + Integer.toString(var2 + 2) + ".hg", true);
      this.ma = var1;
      this.lO = var2;

      try {
         String var3 = new String(this.ah(65536));
         this.me = GameMode.T(var3);
      } catch (IOException var4) {
         Logger.error("Could not read game mode from " + this.mh.getName(), var4);
      }

   }

   fD(PS4SaveLocation var1, int var2, byte[] var3, JsonObject var4) {
      super(var1, "savedata" + (var2 < 8 ? "0" : "") + Integer.toString(var2 + 2) + ".hg", false);
      this.ma = var1;
      this.lO = var2;
      this.lK = var3;
      this.me = GameMode.i(var4);
      this.writeBytes(PS4SaveLocation.l(var4));
   }

   public GameMode L() {
      return this.me;
   }

   public JsonObject M() {
      return PS4SaveLocation.access$readMetadata(this.readBytes(), eG.jV);
   }

   public String writeToFile(JsonObject var1) {
      this.AboutDialog(this.lO == 0 ? "ps4_backup" : "ps4_backup" + (this.lO + 1), this.me, this.getName(), this.getDescription());
      this.writeBytes(PS4SaveLocation.l(var1));
      return this.K();
   }

   public long lastModified() {
      return this.mh.lastModified();
   }

   public String toString() {
      return this.K();
   }
}
