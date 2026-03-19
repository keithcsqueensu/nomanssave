package nomanssave;

public class ShipSettings {
   private final JsonObject oI;

   public static ShipSettings fromPlayerData(JsonObject var0) {
      return new ShipSettings(var0);
   }

   private ShipSettings(JsonObject var1) {
      this.oI = var1;
   }

   public int dV() {
      return this.oI.J("PrimaryShip");
   }

   public void aG(int var1) {
      this.oI.setValueByPath("PrimaryShip", (Object)var1);
   }

   public int dM() {
      return this.oI.J("ShipHealth");
   }

   public void aB(int var1) {
      this.oI.setValueByPath("ShipHealth", (Object)(new Integer(var1)));
   }

   public int ShipsPanel() {
      return this.oI.J("ShipShield");
   }

   public void aC(int var1) {
      this.oI.setValueByPath("ShipShield", (Object)(new Integer(var1)));
   }
}
