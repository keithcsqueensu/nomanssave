package nomanssave;

public class FreighterBase {
   final JsonObject nj;
   // $FF: synthetic field
   final Freighter oK;

   private FreighterBase(Freighter var1, JsonObject var2) {
      this.oK = var1;
      this.nj = var2;
   }

   public String cF() {
      Object var1 = this.nj.getValue("GalacticAddress");
      if (var1 instanceof String) {
         return (String)var1;
      } else {
         return var1 instanceof Number ? "0x" + Long.toHexString(((Number)var1).longValue()) : null;
      }
   }

   public String getName() {
      return this.nj.getValueAsString("Name");
   }

   public void setName(String var1) {
      this.nj.setValueByPath("Name", (Object)var1);
   }

   public int cG() {
      return this.nj.d("Objects").size();
   }

   public JsonObject cH() {
      return this.nj;
   }

   public String toString() {
      return this.nj.getValueAsString("Name");
   }

   // $FF: synthetic method
   FreighterBase(Freighter var1, JsonObject var2, FreighterBase var3) {
      this(var1, var2);
   }
}
