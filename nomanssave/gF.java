package nomanssave;

public class gF implements ItemData {
   private final JsonObject kM;
   // $FF: synthetic field
   final SettlementState rf;

   private gF(SettlementState var1, JsonObject var2) {
      this.rf = var1;
      this.kM = var2;
   }

   public boolean isValid() {
      String var1 = this.kM.getValueAsString("ElementId");
      return var1 != null && var1.length() > 1;
   }

   public String getType() {
      return "Product";
   }

   public Object dz() {
      return this.kM.getValue("ElementId");
   }

   public void m(Object var1) {
      this.kM.AboutDialogCloseListener("ElementId", var1);
      this.kM.AboutDialogCloseListener("LastChangeTimestamp", (Object)((int)(System.currentTimeMillis() / 1000L)));
   }

   public int dA() {
      return this.kM.J("Amount");
   }

   public void aA(int var1) {
      this.kM.AboutDialogCloseListener("Amount", (Object)var1);
      this.kM.AboutDialogCloseListener("LastChangeTimestamp", (Object)((int)(System.currentTimeMillis() / 1000L)));
   }

   public int dB() {
      return 999;
   }

   // $FF: synthetic method
   gF(SettlementState var1, JsonObject var2, gF var3) {
      this(var1, var2);
   }
}
