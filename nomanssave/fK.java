package nomanssave;

class fK extends SteamSaveFileMetadata implements AccountData {
   // $FF: synthetic field
   final SteamSaveLocation mt;

   fK(SteamSaveLocation var1) {
      super(var1, "accountdata.hg", -1, true);
      this.mt = var1;
   }

   public JsonObject M() {
      return this.AboutDialog(eG.jW);
   }

   public void k(JsonObject var1) {
      this.writeMetadata("accountdata", (GameMode)null, (String)null, (String)null);
      this.AboutDialog(var1, false);
   }
}
