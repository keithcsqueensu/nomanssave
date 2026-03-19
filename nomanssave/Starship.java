package nomanssave;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Starship {
   private final int index;
   private final JsonObject rp;
   private final List CoordinateTransform;

   public static Starship[] fromPlayerData(JsonObject var0) {
      JsonArray var1 = var0.d("ShipOwnership");
      if (var1 != null && var1.size() != 0) {
         ArrayList var2 = new ArrayList();

         for(int var3 = 0; var3 < var1.size(); ++var3) {
            JsonObject var4 = var1.V(var3);
            if (var4.d("Resource.Seed").ab(0)) {
               var2.add(new Starship(var3, var4, var4.H("Inventory"), var4.H("Inventory_TechOnly"), var4.H("Inventory_Cargo")));
            }
         }

         return (Starship[])var2.toArray(new Starship[0]);
      } else {
         return new Starship[0];
      }
   }

   public static Starship importFromFile(JsonObject var0, File var1) {
      JsonArray var2 = var0.d("ShipOwnership");
      if (var2 != null && var2.size() != 0) {
         int var3 = -1;

         JsonObject var5;
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            var5 = var2.V(var4);
            if (!var5.d("Resource.Seed").ab(0)) {
               var3 = var4;
               break;
            }
         }

         if (var3 < 0) {
            throw new RuntimeException("Ship cannot be imported to current file!");
         } else {
            JsonObject var14 = TemplateLoader.loadTemplate("ship");
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

            var5 = var14.H("Inventory");
            if (var5 == null) {
               throw new RuntimeException("Invalid ship data");
            } else {
               var6 = var14.d("Resource.Seed");
               if (var6 != null && var6.ab(0)) {
                  var2.AboutDialog(var3, var14);
                  return new Starship(var3, var14, var5, var14.H("Inventory_TechOnly"), var14.H("Inventory_Cargo"));
               } else {
                  throw new RuntimeException("Invalid ship data");
               }
            }
         }
      } else {
         throw new RuntimeException("Ship cannot be imported to current file!");
      }
   }

   private static Function buildFieldAccessor(Starship var0, String[] var1) {
      return (var2) -> {
         String var3 = var0.getName();
         if (var3 == null || var3.length() == 0) {
            var3 = "Ship [" + var0.index + "]";
         }

         return new String[]{var3, var1[var0.dZ() ? 1 : 0]};
      };
   }

   private Starship(int var1, JsonObject var2, JsonObject var3, JsonObject var4, JsonObject var5) {
      this.index = var1;
      this.rp = var2;
      String[] var7 = new String[]{"Technology", "Organ Chamber"};
      short var9 = 0;
      byte var10 = 8;
      byte var11 = 6;
      byte var12 = 8;
      byte var13 = 6;
      boolean var14 = Application.getInstance().SlotComboBoxModel();
      String[] var6;
      String[] var8;
      if (var14) {
         var10 = 10;
         var11 = 12;
         var12 = 10;
         var13 = 6;
         var6 = new String[]{"Cargo", "Storage Sacs"};
         var8 = new String[]{"Unused", "Unused"};
         var5 = null;
      } else {
         var9 = 3584;
         var6 = new String[]{"General", "Storage Sacs"};
         var8 = new String[]{"Cargo", "Inflated Sacs"};
      }

      ArrayList var15 = new ArrayList();
      var15.add(new gI(this, buildFieldAccessor(this, var6), var3, 0, var10, var11, false, true, var14, var1));
      if (var4 != null) {
         var15.add(new gJ(this, buildFieldAccessor(this, var7), var4, 0, var12, var13, true, true, var1));
      }

      if (var5 != null) {
         var15.add(new gK(this, buildFieldAccessor(this, var8), var5, var9, 8, 6, false, true, var1));
      }

      this.CoordinateTransform = Collections.unmodifiableList(var15);
   }

   public void exportToFile(File var1, boolean var2) {
      Throwable var3 = null;
      Object var4 = null;

      try {
         JsonWriter var5 = new JsonWriter(new FileOutputStream(var1));

         try {
            JsonObject var6 = this.rp.MilestonesPanel();
            if (!var2) {
               JsonArray var7 = var6.d("Inventory.Slots");

               int var8;
               JsonObject var9;
               for(var8 = 0; var8 < var7.size(); ++var8) {
                  var9 = var7.V(var8);
                  if (!var9.getValueAsString("Type.InventoryType").equals("Technology")) {
                     var7.ac(var8--);
                  }
               }

               var7 = var6.d("Inventory_Cargo.Slots");

               for(var8 = 0; var8 < var7.size(); ++var8) {
                  var9 = var7.V(var8);
                  if (!var9.getValueAsString("Type.InventoryType").equals("Technology")) {
                     var7.ac(var8--);
                  }
               }
            }

            var5.h(var6);
         } finally {
            if (var5 != null) {
               var5.close();
            }

         }

      } catch (Throwable var15) {
         if (var3 == null) {
            var3 = var15;
         } else if (var3 != var15) {
            var3.addSuppressed(var15);
         }

         throw var3;
      }
   }

   public int getIndex() {
      return this.index;
   }

   public String getName() {
      return this.rp.getValueAsString("Name");
   }

   public void setName(String var1) {
      this.rp.AboutDialogCloseListener("Name", (Object)var1);
   }

   public boolean dZ() {
      return ShipType.aw(this.cT()) == ShipType.rx;
   }

   private int ea() {
      ShipType var1 = ShipType.aw(this.cT());
      return var1 == null ? 4 : var1.ea();
   }

   public String cT() {
      return this.rp.getValueAsString("Resource.Filename");
   }

   public void ag(String var1) {
      this.rp.AboutDialogCloseListener("Resource.Filename", (Object)var1);
      ShipType var2 = ShipType.aw(var1);
      this.CoordinateTransform.stream().forEach((var1x) -> {
         var1x.az(var2 == null ? 4 : var2.ea());
      });
      if (var2 == ShipType.rx) {
         this.d("^ALIEN_SHIP", 1.0D);
         this.av("^ROBOT_SHIP");
      } else if (var2 == ShipType.rC) {
         this.av("^ALIEN_SHIP");
         this.d("^ROBOT_SHIP", 1.0D);
      } else {
         this.av("^ALIEN_SHIP");
         this.av("^ROBOT_SHIP");
      }

   }

   public String cK() {
      return this.rp.d("Resource.Seed").CompanionsPanel(1);
   }

   public void aa(String var1) {
      this.rp.d("Resource.Seed").AboutDialog(1, var1);
   }

   public void cm() {
      this.rp.AboutDialogCloseListener("Resource.Filename", (Object)"");
      this.rp.d("Resource.Seed").AboutDialog(0, Boolean.FALSE);
      this.rp.d("Resource.Seed").AboutDialog(1, "0x0");
   }

   public String LineNumberPanel() {
      return this.rp.getValueAsString("Inventory.Class.InventoryClass");
   }

   public void aj(String var1) {
      this.rp.AboutDialogCloseListener("Inventory.Class.InventoryClass", (Object)var1);
      JsonObject var2 = this.rp.H("Inventory_TechOnly.Class");
      if (var2 != null) {
         var2.AboutDialogCloseListener("InventoryClass", (Object)var1);
      }

      var2 = this.rp.H("Inventory_Cargo.Class");
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

   private void av(String var1) {
      this.CoordinateTransform.stream().forEach((var1x) -> {
         var1x.DiscoveryPanel(var1);
      });
   }

   public double dF() {
      return this.ak("^SHIP_DAMAGE");
   }

   public void d(double var1) {
      this.d("^SHIP_DAMAGE", var1);
   }

   public double SquadronPanel() {
      return this.ak("^SHIP_SHIELD");
   }

   public void h(double var1) {
      this.d("^SHIP_SHIELD", var1);
   }

   public double cX() {
      return this.ak("^SHIP_HYPERDRIVE");
   }

   public void setHyperdrive(double var1) {
      this.d("^SHIP_HYPERDRIVE", var1);
   }

   public double ec() {
      return this.ak("^SHIP_AGILE");
   }

   public void i(double var1) {
      this.d("^SHIP_AGILE", var1);
   }

   public String toString() {
      String var1 = this.getName();
      if (var1 != null && var1.length() != 0) {
         return var1;
      } else {
         ShipType var2 = ShipType.aw(this.cT());
         return var2 == null ? "Unknown [" + this.index + "]" : var2 + " [" + this.index + "]";
      }
   }

   // $FF: synthetic method
   static int access$getIndex(Starship var0) {
      return var0.ea();
   }
}
