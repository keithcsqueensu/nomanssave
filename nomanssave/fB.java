package nomanssave;

class fB extends fH implements AccountData {
   // $FF: synthetic field
   final PS4SaveLocation ma;

   fB(PS4SaveLocation var1) {
      super(var1, "savedata00.hg", true);
      this.ma = var1;
   }

   public JsonObject M() {
      return PS4SaveLocation.access$readMetadata(this.readBytes(), eG.jW);
   }

   public void k(JsonObject var1) {
      this.writeMetadata("ps4_accountdata", (GameMode)null, (String)null, (String)null);
      this.writeBytes(PS4SaveLocation.l(var1));
   }
}
