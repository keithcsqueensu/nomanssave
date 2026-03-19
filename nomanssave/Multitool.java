package nomanssave;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.function.Function;

public class Multitool {
   private final int index;
   private final JsonObject qF;
   private final Inventory qG;

   public static Multitool[] fromPlayerData(JsonObject var0) {
      JsonArray var1 = var0.d("Multitools");
      if (var1 != null && var1.size() != 0) {
         ArrayList var2 = new ArrayList();

         for(int var3 = 0; var3 < var1.size(); ++var3) {
            JsonObject var4 = var1.V(var3);
            if (var4.d("Seed").ab(0)) {
               var2.add(new Multitool(var3, var4, var4.H("Store")));
            }
         }

         return (Multitool[])var2.toArray(new Multitool[0]);
      } else {
         return new Multitool[]{new gw(var0, var0.H("WeaponInventory"))};
      }
   }

   public static Multitool importFromFile(JsonObject var0, File var1) {
      JsonArray var2 = var0.d("Multitools");
      if (var2 != null && var2.size() != 0) {
         int var3 = -1;

         JsonObject var5;
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            var5 = var2.V(var4);
            if (!var5.d("Seed").ab(0)) {
               var3 = var4;
               break;
            }
         }

         if (var3 < 0) {
            throw new RuntimeException("Weapon cannot be imported to current file!");
         } else {
            JsonObject var14 = TemplateLoader.loadTemplate("multitool");
            Throwable var15 = null;
            JsonArray var6 = null;

            try {
               BinaryReader var7 = new BinaryReader(new FileInputStream(var1));

               try {
                  if (var14 == null) {
                     var14 = var7.bK();
                  } else {
                     var14.AccountPanel(var7.bK());
                  }
               } finally {
                  if (var7 != null) {
                     var7.close();
                  }

               }
            } catch (Throwable var13) {
               if (var15 == null) {
                  var15 = var13;
               } else if (var15 != var13) {
                  var15.addSuppressed(var13);
               }

               throw var15;
            }

            var2.AboutDialog(var3, var14);
            var5 = var14.H("Store");
            if (var5 == null) {
               throw new RuntimeException("Invalid weapon data");
            } else {
               var6 = var14.d("Seed");
               if (var6 != null && var6.ab(0)) {
                  return new Multitool(var3, var14, var5);
               } else {
                  throw new RuntimeException("Invalid weapon data");
               }
            }
         }
      } else {
         throw new RuntimeException("Weapon cannot be imported to current file!");
      }
   }

   private static Function buildFieldAccessor(Multitool var0) {
      return (var1) -> {
         String var2 = var0.getName();
         if (var2 == null || var2.length() == 0) {
            var2 = "Multitool [" + var0.index + "]";
         }

         return new String[]{var2};
      };
   }

   Multitool(int var1, JsonObject var2, JsonObject var3) {
      this.index = var1;
      this.qF = var2;
      byte var4 = 8;
      byte var5 = 6;
      if (Application.getInstance().SlotComboBoxModel()) {
         var4 = 10;
         var5 = 10;
      }

      this.qG = new Inventory(buildFieldAccessor(this), var3, 2, var4, var5, true, true);
   }

   public void j(File var1) {
      Throwable var2 = null;
      Object var3 = null;

      try {
         JsonWriter var4 = new JsonWriter(new FileOutputStream(var1));

         try {
            JsonObject var5 = this.qF.MilestonesPanel();
            var4.h(var5);
         } finally {
            if (var4 != null) {
               var4.close();
            }

         }

      } catch (Throwable var11) {
         if (var2 == null) {
            var2 = var11;
         } else if (var2 != var11) {
            var2.addSuppressed(var11);
         }

         throw var2;
      }
   }

   public int getIndex() {
      return this.index;
   }

   public String getName() {
      return this.qF.getValueAsString("Name");
   }

   public void setName(String var1) {
      this.qF.AboutDialogCloseListener("Name", (Object)var1);
   }

   public String cT() {
      return this.qF.getValueAsString("Resource.Filename");
   }

   public void ag(String var1) {
      this.qF.AboutDialogCloseListener("Resource.Filename", (Object)var1);
   }

   public String cK() {
      return this.qF.d("Seed").CompanionsPanel(1);
   }

   public void aa(String var1) {
      this.qF.d("Seed").AboutDialog(1, var1);
   }

   public String LineNumberPanel() {
      return this.qF.getValueAsString("Store.Class.InventoryClass");
   }

   public void aj(String var1) {
      this.qF.AboutDialogCloseListener("Store.Class.InventoryClass", (Object)var1);
   }

   public Inventory SettlementsPanel() {
      return this.qG;
   }

   private double ak(String var1) {
      return this.qG.ak(var1);
   }

   private void d(String var1, double var2) {
      this.qG.d(var1, var2);
   }

   public double dF() {
      return this.ak("^WEAPON_DAMAGE");
   }

   public void d(double var1) {
      this.d("^WEAPON_DAMAGE", var1);
   }

   public double dG() {
      return this.ak("^WEAPON_MINING");
   }

   public void e(double var1) {
      this.d("^WEAPON_MINING", var1);
   }

   public double dH() {
      return this.ak("^WEAPON_SCAN");
   }

   public void f(double var1) {
      this.d("^WEAPON_SCAN", var1);
   }

   public void cm() {
      this.qF.AboutDialogCloseListener("Seed", (Object)(new JsonArray(new Object[]{Boolean.FALSE, "0x0"})));
   }

   public String toString() {
      String var1 = this.getName();
      return var1 != null && var1.length() != 0 ? var1 : "Multitool [" + this.index + "]";
   }
}
