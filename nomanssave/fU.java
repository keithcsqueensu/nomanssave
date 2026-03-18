package nomanssave;

class fU extends XboxContainerWriter implements AccountData {
   // $FF: synthetic field
   final XboxSaveLocation mN;

   fU(XboxSaveLocation var1) {
      super(var1, "AccountData");
      this.mN = var1;
   }

   public JsonObject M() {
      return this.AboutDialog(eG.jW);
   }

   public void k(JsonObject var1) {
      this.AboutDialog("msaccountdata", (GameMode)null);
      this.h(var1);
   }
}
