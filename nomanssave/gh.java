package nomanssave;

public class gh {
   final String name;
   final JsonObject nn;
   // $FF: synthetic field
   final Settlement nk;

   private gh(Settlement var1, String var2, JsonObject var3) {
      this.nk = var1;
      this.name = var2;
      this.nn = var3;
   }

   public NpcType cJ() {
      return NpcType.as(this.nn.getValueAsString("ResourceElement.Filename"));
   }

   public String cK() {
      return this.nn.d("ResourceElement.Seed").CompanionsPanel(1);
   }

   public void aa(String var1) {
      this.nn.d("ResourceElement.Seed").AboutDialog(1, var1);
   }

   public String toString() {
      return this.name;
   }

   // $FF: synthetic method
   gh(Settlement var1, String var2, JsonObject var3, gh var4) {
      this(var1, var2, var3);
   }
}
