package nomanssave;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SettlementState {
   private final int index;
   private final JsonObject bf;

   public static SettlementState[] fromPlayerData(JsonObject var0) {
      JsonArray var1 = var0.d("TeleportEndpoints");
      List var2 = (List)var1.bB().filter((var0x) -> {
         return "Settlement".equals(var0x.getValueAsString("TeleporterType"));
      }).map((var0x) -> {
         return GalacticAddress.n(var0x.H("UniverseAddress"));
      }).collect(Collectors.toList());
      JsonArray var3 = var0.d("SettlementStatesV2");
      if (var3 != null && var3.size() != 0) {
         ArrayList var4 = new ArrayList();

         for(int var5 = 0; var5 < var3.size(); ++var5) {
            JsonObject var6 = var3.V(var5);
            GalacticAddress var7 = GalacticAddress.n(var6.getValue("UniverseAddress"));
            if (var2.contains(var7)) {
               var4.add(new SettlementState(var5, var6));
            }
         }

         return (SettlementState[])var4.toArray(new SettlementState[0]);
      } else {
         return new SettlementState[0];
      }
   }

   private SettlementState(int var1, JsonObject var2) {
      this.index = var1;
      this.bf = var2;
   }

   public int getIndex() {
      return this.index;
   }

   public String getName() {
      return this.bf.getValueAsString("Name");
   }

   public void setName(String var1) {
      this.bf.setValueByPath("Name", (Object)var1);
   }

   public int aq(int var1) {
      return this.bf.d("Stats").Y(var1);
   }

   public void e(int var1, int var2) {
      this.bf.d("Stats").AboutDialog(var1, var2);
   }

   public int getStat(gG var1) {
      return this.bf.d("Stats").Y(var1.ordinal());
   }

   public void setStat(gG var1, int var2) {
      this.bf.d("Stats").AboutDialog(var1.ordinal(), var2);
   }

   public int dW() {
      return this.bf.d("Perks").size();
   }

   public String AppSettings(int var1) {
      return this.bf.d("Perks").CompanionsPanel(var1);
   }

   public void setPerk(int var1, String var2) {
      this.bf.d("Perks").AboutDialog(var1, var2);
   }

   public String cK() {
      return this.bf.BasesStoragePanel("SeedValue");
   }

   public void aa(String var1) {
      this.bf.setValueByPath("SeedValue", (Object)var1);
   }

   public gF[] dX() {
      JsonArray var1 = this.bf.d("ProductionState");
      if (var1 == null) {
         return new gF[0];
      } else {
         ArrayList var2 = new ArrayList();

         for(int var3 = 0; var3 < var1.size(); ++var3) {
            JsonObject var4 = var1.V(var3);
            var2.add(new gF(this, var4, (gF)null));
         }

         return (gF[])var2.toArray(new gF[0]);
      }
   }

   public String toString() {
      return this.getName();
   }
}
