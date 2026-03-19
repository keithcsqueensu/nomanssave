package nomanssave;

public class gw extends Multitool {
   private final JsonObject oI;

   gw(JsonObject var1, JsonObject var2) {
      super(0, (JsonObject)null, var2);
      this.oI = var1;
   }

   public String getName() {
      return this.oI.getValueAsString("PlayerWeaponName");
   }

   public void setName(String var1) {
      this.oI.setValueByPath("PlayerWeaponName", (Object)var1);
   }

   public String cT() {
      return MultitoolType.qH.K();
   }

   public void ag(String var1) {
      if (!MultitoolType.qH.K().equals(var1)) {
         throw new RuntimeException("Only standard types allowed");
      }
   }

   public MultitoolType dI() {
      return MultitoolType.qH;
   }

   public void setType(MultitoolType var1) {
      if (var1 != MultitoolType.qH) {
         throw new RuntimeException("Only standard types allowed");
      }
   }

   public String cK() {
      return this.oI.d("CurrentWeapon.GenerationSeed").CompanionsPanel(1);
   }

   public void aa(String var1) {
      this.oI.d("CurrentWeapon.GenerationSeed").AboutDialog(1, var1);
   }

   public String LineNumberPanel() {
      return this.oI.getValueAsString("WeaponInventory.Class.InventoryClass");
   }

   public void aj(String var1) {
      this.oI.setValueByPath("WeaponInventory.Class.InventoryClass", (Object)var1);
   }

   public String toString() {
      String var1 = this.getName();
      return var1 != null && var1.length() != 0 ? var1 : "Multitool";
   }
}
