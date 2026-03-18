package nomanssave;

public class MultitoolSettings {
   private final JsonObject oI;

   public static MultitoolSettings fromPlayerData(JsonObject var0) {
      return new MultitoolSettings(var0);
   }

   private MultitoolSettings(JsonObject var1) {
      this.oI = var1;
   }

   public int dU() {
      return this.oI.J("ActiveMultioolIndex");
   }

   public void aF(int var1) {
      JsonObject var2 = this.oI.H("Multitools[" + var1 + "]");
      if (var2 != null && var2.M("Seed[0]")) {
         this.oI.AboutDialogCloseListener("ActiveMultioolIndex", (Object)var1);
         this.oI.AboutDialogCloseListener("WeaponInventory", (Object)var2.H("Store").MilestonesPanel());
         this.oI.AboutDialogCloseListener("CurrentWeapon.GenerationSeed[1]", (Object)var2.BasesStoragePanel("Seed[1]"));
         this.oI.AboutDialogCloseListener("CurrentWeapon.Filename", (Object)var2.getValueAsString("Resource.Filename"));
      } else {
         throw new RuntimeException("Cannot set current multitool");
      }
   }
}
