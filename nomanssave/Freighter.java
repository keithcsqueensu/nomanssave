package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Freighter {
   private final JsonObject oI;
   private final List CoordinateTransform;
   private final FreighterBase oJ;

   public static Freighter fromPlayerData(JsonObject var0) {
      return var0.d("CurrentFreighter.Seed").ab(0) && !isEmpty(var0.getValueAsString("CurrentFreighter.Filename")) ? new Freighter(var0, var0.H("FreighterInventory"), var0.H("FreighterInventory_TechOnly"), var0.H("FreighterInventory_Cargo")) : null;
   }

   private static boolean isEmpty(String var0) {
      return var0 == null || var0.length() == 0;
   }

   private static Function AboutDialog(Freighter var0, String var1) {
      return (var1x) -> {
         return new String[]{"Freighter", var1};
      };
   }

   private Freighter(JsonObject var1, JsonObject var2, JsonObject var3, JsonObject var4) {
      this.oI = var1;
      boolean var7 = false;
      boolean var8 = false;
      short var9 = 0;
      byte var10 = 8;
      byte var11 = 6;
      byte var12 = 7;
      byte var13 = 2;
      String var5;
      String var6;
      short var19;
      byte var20;
      if (Application.getInstance().SlotComboBoxModel()) {
         var19 = 3584;
         var20 = 8;
         var10 = 10;
         var11 = 12;
         var12 = 10;
         var13 = 6;
         var5 = "Cargo";
         var6 = "Unused";
         var4 = null;
      } else {
         var19 = 3592;
         var20 = 8;
         var9 = 3584;
         var5 = "General";
         var6 = "Cargo";
      }

      ArrayList var14 = new ArrayList();
      var14.add(new Inventory(AboutDialog(this, var5), var2, var19, var10, var11, false, true));
      if (var3 != null) {
         var14.add(new Inventory(AboutDialog(this, "Technology"), var3, var20, var12, var13, true, true));
      }

      if (var4 != null) {
         var14.add(new Inventory(AboutDialog(this, var6), var4, var9, 8, 6, false, true));
      }

      this.CoordinateTransform = Collections.unmodifiableList(var14);
      JsonArray var15 = var1.d("PersistentPlayerBases");
      JsonObject var17 = null;

      for(int var18 = 0; var18 < var15.size(); ++var18) {
         JsonObject var16 = var15.V(var18);
         if ("FreighterBase".equals(var16.getValueAsString("BaseType.PersistentBaseTypes")) && var16.J("BaseVersion") >= 3) {
            var17 = var16;
            break;
         }
      }

      this.oJ = var17 == null ? null : new FreighterBase(this, var17, (FreighterBase)null);
   }

   public String getName() {
      return this.oI.getValueAsString("PlayerFreighterName");
   }

   public void setName(String var1) {
      this.oI.AboutDialogCloseListener("PlayerFreighterName", (Object)var1);
   }

   public String cT() {
      return this.oI.getValueAsString("CurrentFreighter.Filename");
   }

   public void ag(String var1) {
      this.oI.AboutDialogCloseListener("CurrentFreighter.Filename", (Object)var1);
   }

   public String cU() {
      JsonArray var1 = this.oI.d("CurrentFreighterHomeSystemSeed");
      if (var1 != null && var1.ab(0)) {
         String var2 = var1.CompanionsPanel(1);
         return "0x0".equals(var2) ? "" : var2;
      } else {
         return "";
      }
   }

   public void ah(String var1) {
      JsonArray var2 = this.oI.d("CurrentFreighterHomeSystemSeed");
      if (var2 == null) {
         var2 = new JsonArray(new Object[]{Boolean.FALSE, "0x0"});
         this.oI.AboutDialogCloseListener("CurrentFreighterHomeSystemSeed", (Object)var2);
      }

      var2.AboutDialog(0, Boolean.TRUE);
      var2.AboutDialog(1, var1.length() == 0 ? "0x0" : var1);
   }

   public String cV() {
      return this.oI.d("CurrentFreighter.Seed").CompanionsPanel(1);
   }

   public void ai(String var1) {
      this.oI.d("CurrentFreighter.Seed").AboutDialog(1, var1);
   }

   public String LineNumberPanel() {
      return this.oI.getValueAsString("FreighterInventory.Class.InventoryClass");
   }

   public void aj(String var1) {
      this.oI.AboutDialogCloseListener("FreighterInventory.Class.InventoryClass", (Object)var1);
      JsonObject var2 = this.oI.H("FreighterInventory_TechOnly.Class");
      if (var2 != null) {
         var2.AboutDialogCloseListener("InventoryClass", (Object)var1);
      }

      var2 = this.oI.H("FreighterInventory_Cargo.Class");
      if (var2 != null) {
         var2.AboutDialogCloseListener("InventoryClass", (Object)var1);
      }

   }

   public List cC() {
      return this.CoordinateTransform;
   }

   private double ak(String var1) {
      return ((Inventory)this.CoordinateTransform.get(0)).ak(var1);
   }

   private void d(String var1, double var2) {
      this.CoordinateTransform.stream().forEach((var3) -> {
         var3.d(var1, var2);
      });
   }

   public double cX() {
      return this.ak("^FREI_HYPERDRIVE");
   }

   public void AboutDialog(double var1) {
      this.d("^FREI_HYPERDRIVE", var1);
   }

   public double cY() {
      return this.ak("^FREI_FLEET");
   }

   public void AboutDialogCloseListener(double var1) {
      this.d("^FREI_FLEET", var1);
   }

   public FreighterBase cZ() {
      return this.oJ;
   }

   public String toString() {
      String var1 = this.getName();
      return var1 != null && var1.length() != 0 ? var1 : "Freighter";
   }
}
