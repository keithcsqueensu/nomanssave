package nomanssave;

public class SquadronPilot {
   private final JsonArray rH;
   private final JsonObject rI;
   private final int index;

   public static SquadronPilot[] fromPlayerData(JsonObject var0) {
      JsonArray var1 = var0.d("SquadronUnlockedPilotSlots");
      JsonArray var2 = var0.d("SquadronPilots");
      if (var1 != null && var2 != null) {
         SquadronPilot[] var3 = new SquadronPilot[Math.min(var1.size(), var2.size())];

         for(int var4 = 0; var4 < var3.length; ++var4) {
            var3[var4] = new SquadronPilot(var1, var2.V(var4), var4);
         }

         return var3;
      } else {
         return new SquadronPilot[0];
      }
   }

   private SquadronPilot(JsonArray var1, JsonObject var2, int var3) {
      this.rH = var1;
      this.rI = var2;
      this.index = var3;
   }

   public boolean isEnabled() {
      return this.rH.ab(this.index);
   }

   public void setEnabled(boolean var1) {
      this.rH.AboutDialog(this.index, var1);
   }

   public boolean isValid() {
      return this.rI.d("NPCResource.Seed").ab(0) && this.rI.d("ShipResource.Seed").ab(0);
   }

   public NpcType ed() {
      return NpcType.as(this.rI.getValueAsString("NPCResource.Filename"));
   }

   public void setNpcType(NpcType var1) {
      this.rI.AboutDialogCloseListener("NPCResource.Filename", (Object)var1.K());
   }

   public String ee() {
      JsonArray var1 = this.rI.d("NPCResource.Seed");
      return var1.ab(0) ? var1.CompanionsPanel(1) : "";
   }

   public void ax(String var1) {
      JsonArray var2 = this.rI.d("NPCResource.Seed");
      if (var1 != null && var1.length() != 0) {
         var2.AboutDialog(0, true);
         var2.AboutDialog(1, var1);
      } else {
         var2.AboutDialog(0, false);
         var2.AboutDialog(1, "0x0");
      }

   }

   public ShipType ef() {
      return ShipType.aw(this.rI.getValueAsString("ShipResource.Filename"));
   }

   public void setShipType(ShipType var1) {
      this.rI.AboutDialogCloseListener("ShipResource.Filename", (Object)var1.K());
   }

   public String eg() {
      JsonArray var1 = this.rI.d("ShipResource.Seed");
      return var1.ab(0) ? var1.CompanionsPanel(1) : "";
   }

   public void ay(String var1) {
      JsonArray var2 = this.rI.d("ShipResource.Seed");
      if (var1 != null && var1.length() != 0) {
         var2.AboutDialog(0, true);
         var2.AboutDialog(1, var1);
      } else {
         var2.AboutDialog(0, false);
         var2.AboutDialog(1, "0x0");
      }

   }

   public int eh() {
      return this.rI.J("PilotRank");
   }

   public void aI(int var1) {
      this.rI.AboutDialogCloseListener("PilotRank", (Object)var1);
   }

   public String toString() {
      return this.isEnabled() ? (this.isValid() ? "Wingman " + this.index : "EMPTY") : "LOCKED";
   }
}
