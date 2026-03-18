package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Settlement {
   private final List CoordinateTransform;
   private final List nh;
   private final List ni;

   public static Settlement fromPlayerData(JsonObject var0) {
      return new Settlement(var0);
   }

   private static Function DiscoveryPanel(int var0) {
      return (var1) -> {
         String var2 = var1.getName();
         if (var2 == null || var2.length() == 0 || "BLD_STORAGE_NAME".equals(var2)) {
            var2 = "Chest " + var0;
         }

         return new String[]{var2};
      };
   }

   private static Function cB() {
      return (var0) -> {
         return new String[]{"Ingredient Storage"};
      };
   }

   private Settlement(JsonObject var1) {
      byte var2 = 8;
      byte var3 = 6;
      if (Application.getInstance().SlotComboBoxModel()) {
         var2 = 10;
         var3 = 8;
      }

      ArrayList var4 = new ArrayList();

      for(int var5 = 0; var5 < 10; ++var5) {
         var4.add(new Inventory(DiscoveryPanel(var5), var1.H("Chest" + (var5 + 1) + "Inventory"), 3584, var2, var3, false, false));
      }

      JsonObject var14 = var1.H("CookingIngredientsInventory");
      if (var14 != null) {
         var4.add(new Inventory(cB(), var14, 36352, var2, var3, false, false));
      }

      this.CoordinateTransform = Collections.unmodifiableList(var4);
      ArrayList var6 = new ArrayList();
      JsonArray var7 = var1.d("NPCWorkers");
      String var8 = "";

      for(int var10 = 0; var10 < var7.size() && var10 < 5; ++var10) {
         JsonObject var9 = var7.V(var10);
         if (var9.M("HiredWorker")) {
            switch(var10) {
            case 0:
               var8 = "Armorer";
               break;
            case 1:
               var8 = "Farmer";
               break;
            case 2:
               var8 = "Overseer";
               break;
            case 3:
               var8 = "Technician";
               break;
            case 4:
               var8 = "Scientist";
            }

            var6.add(new gh(this, var8, var9, (gh)null));
         }
      }

      this.nh = Collections.unmodifiableList(var6);
      ArrayList var15 = new ArrayList();
      JsonArray var11 = var1.d("PersistentPlayerBases");

      for(int var13 = 0; var13 < var11.size(); ++var13) {
         JsonObject var12 = var11.V(var13);
         if ("HomePlanetBase".equals(var12.getValueAsString("BaseType.PersistentBaseTypes")) && var12.J("BaseVersion") >= 3) {
            var15.add(new Base(this, var12, (Base)null));
         }
      }

      this.ni = Collections.unmodifiableList(var15);
   }

   public List cC() {
      return this.CoordinateTransform;
   }

   public List cD() {
      return this.nh;
   }

   public List cE() {
      return this.ni;
   }
}
