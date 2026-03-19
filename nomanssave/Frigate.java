package nomanssave;

import java.util.ArrayList;

public class Frigate {
   private final int index;
   private final JsonObject oR;

   public static Frigate[] fromPlayerData(JsonObject var0) {
      JsonArray var1 = var0.d("FleetFrigates");
      return var1 == null ? new Frigate[0] : d(var1);
   }

   public static Frigate[] d(JsonArray var0) {
      if (var0.size() == 0) {
         return new Frigate[0];
      } else {
         ArrayList var1 = new ArrayList();
         Frigate[] var2 = new Frigate[var0 == null ? 0 : var0.size()];

         for(int var3 = 0; var3 < var2.length; ++var3) {
            JsonObject var4 = var0.V(var3);
            var1.add(new Frigate(var3, var4));
         }

         return (Frigate[])var1.toArray(new Frigate[0]);
      }
   }

   private Frigate(int var1, JsonObject var2) {
      this.index = var1;
      this.oR = var2;
   }

   public int getIndex() {
      return this.index;
   }

   public String getName() {
      return this.oR.getValueAsString("CustomName");
   }

   public void setName(String var1) {
      this.oR.AboutDialogCloseListener("CustomName", (Object)var1);
   }

   public FrigateClass da() {
      return FrigateClass.an(this.oR.getValueAsString("FrigateClass.FrigateClass"));
   }

   public void setFrigateClass(FrigateClass var1) {
      this.oR.AboutDialogCloseListener("FrigateClass.FrigateClass", (Object)var1.toString());
   }

   public String LineNumberPanel() {
      int var1 = -2;
      JsonArray var2 = this.oR.d("TraitIDs");

      for(int var3 = 0; var3 < var2.size(); ++var3) {
         String var4 = var2.CompanionsPanel(var3);
         er var5 = er.o(var4);
         if (var5 != null && var5.aW()) {
            ++var1;
         }
      }

      if (var1 < 0) {
         var1 = 0;
      }

      if (var1 > 3) {
         var1 = 3;
      }

      return ShipClass.values()[var1].name();
   }

   public String cU() {
      return this.oR.d("HomeSystemSeed").CompanionsPanel(1);
   }

   public void ah(String var1) {
      this.oR.d("HomeSystemSeed").AboutDialog(1, var1);
   }

   public String cV() {
      return this.oR.d("ResourceSeed").CompanionsPanel(1);
   }

   public void ai(String var1) {
      this.oR.d("ResourceSeed").AboutDialog(1, var1);
   }

   public String db() {
      return this.oR.getValueAsString("Race.AlienRace");
   }

   public void am(String var1) {
      this.oR.AboutDialogCloseListener("Race.AlienRace", (Object)var1);
   }

   public int aq(int var1) {
      JsonArray var2 = this.oR.d("Stats");
      return var2.size() <= var1 ? 0 : var2.Y(var1);
   }

   public void e(int var1, int var2) {
      JsonArray var3 = this.oR.d("Stats");

      while(var3.size() <= var1) {
         var3.f(0);
      }

      var3.AboutDialog(var1, new Integer(var2));
   }

   public er ar(int var1) {
      JsonArray var2 = this.oR.d("TraitIDs");
      if (var1 < var2.size()) {
         String var3 = var2.CompanionsPanel(var1);
         return er.o(var3);
      } else {
         return null;
      }
   }

   public void setStatUpgrade(int var1, er var2) {
      JsonArray var3 = this.oR.d("TraitIDs");
      if (var1 < var3.size()) {
         var3.AboutDialog(var1, var2 == null ? "^" : var2.getID());
      }

   }

   public int dc() {
      return this.oR.J("TotalNumberOfExpeditions");
   }

   public void as(int var1) {
      this.oR.AboutDialogCloseListener("TotalNumberOfExpeditions", (Object)(new Integer(var1)));
   }

   public int dd() {
      return this.oR.J("TotalNumberOfSuccessfulEvents");
   }

   public void at(int var1) {
      this.oR.AboutDialogCloseListener("TotalNumberOfSuccessfulEvents", (Object)(new Integer(var1)));
   }

   public int de() {
      return this.oR.J("TotalNumberOfFailedEvents");
   }

   public void au(int var1) {
      this.oR.AboutDialogCloseListener("TotalNumberOfFailedEvents", (Object)(new Integer(var1)));
   }

   public int df() {
      return this.oR.J("NumberOfTimesDamaged");
   }

   public void av(int var1) {
      this.oR.AboutDialogCloseListener("NumberOfTimesDamaged", (Object)(new Integer(var1)));
   }

   public int dg() {
      return this.oR.J("RepairsMade");
   }

   public void aw(int var1) {
      this.oR.AboutDialogCloseListener("RepairsMade", (Object)(new Integer(var1)));
   }

   public int dh() {
      return this.oR.J("DamageTaken");
   }

   public void ax(int var1) {
      this.oR.AboutDialogCloseListener("DamageTaken", (Object)(new Integer(var1)));
   }

   public String toString() {
      String var1 = this.getName();
      if (var1 != null && var1.length() != 0) {
         return var1;
      } else {
         FrigateClass var2 = this.da();
         return var2 == null ? "Unknown [" + this.index + "]" : var2 + " [" + this.index + "]";
      }
   }
}
