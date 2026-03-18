package nomanssave;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public interface SaveLocation {
   int lz = 15;

   static String AccountPanel(long var0) {
      int var2 = (int)(var0 % 60L);
      var0 /= 60L;
      int var3 = (int)(var0 % 60L);
      var0 /= 60L;
      int var4 = (int)var0;
      StringBuilder var5 = new StringBuilder();
      var5.append(var4);
      var5.append(':');
      if (var3 < 10) {
         var5.append(0);
      }

      var5.append(var3);
      return var5.toString();
   }

   static String getStorageName(SaveLocation var0) {
      if (var0 instanceof SteamSaveLocation) {
         return "Steam";
      } else if (var0 instanceof XboxSaveLocation) {
         return "Xbox Game Pass";
      } else {
         return var0 instanceof PS4SaveLocation ? "PS4 - Save Wizard" : null;
      }
   }

   static SaveLocation detectSaveLocation(File var0, SaveChangeListener var1) {
      if (!var0.exists()) {
         return null;
      } else {
         try {
            if (var0.isDirectory()) {
               if (var0.listFiles((var0x) -> {
                  return var0x.getName().equalsIgnoreCase("containers.index");
               }).length > 0) {
                  return new XboxSaveLocation(var0, var1);
               }

               if (var0.listFiles((var0x) -> {
                  return var0x.getName().equalsIgnoreCase("accountdata.hg") || Pattern.matches("save\\d*.hg", var0x.getName().toLowerCase());
               }).length > 0) {
                  return new SteamSaveLocation(var0, var1);
               }

               if (var0.listFiles((var0x) -> {
                  return Pattern.matches("savedata\\d{2}.hg", var0x.getName().toLowerCase());
               }).length > 0) {
                  return new PS4SaveLocation(var0, var1);
               }
            } else {
               if (var0.getName().equalsIgnoreCase("containers.index")) {
                  return new XboxSaveLocation(var0.getParentFile(), var1);
               }

               if (var0.getName().equalsIgnoreCase("accountdata.hg") || Pattern.matches("save\\d*.hg", var0.getName().toLowerCase())) {
                  return new SteamSaveLocation(var0.getParentFile(), var1);
               }

               if (Pattern.matches("savedata\\d{2}.hg", var0.getName().toLowerCase())) {
                  return new PS4SaveLocation(var0.getParentFile(), var1);
               }
            }
         } catch (IOException var3) {
            Logger.error("cannot load storage", var3);
         }

         return null;
      }
   }

   static SaveLocation createSaveLocation(String var0, File var1, SaveChangeListener var2) {
      if (!var1.exists()) {
         return null;
      } else if (var0 == null) {
         return detectSaveLocation(var1, var2);
      } else {
         try {
            if ("Steam".equals(var0)) {
               return new SteamSaveLocation(var1, var2);
            }

            if ("Xbox Game Pass".equals(var0)) {
               return new XboxSaveLocation(var1, var2);
            }

            if ("PS4 - Save Wizard".equals(var0)) {
               return new PS4SaveLocation(var1, var2);
            }
         } catch (IOException var4) {
            Logger.error("cannot load storage", var4);
         }

         return null;
      }
   }

   File InventorySlotPanel();

   AccountData bT();

   SaveSlot[] bU();

   default SaveSlot[] bV() {
      return (SaveSlot[])Arrays.asList(this.bU()).stream().filter((var0) -> {
         return !var0.isEmpty();
      }).toArray((var0) -> {
         return new SaveSlot[var0];
      });
   }

   int W(String var1);

   default boolean bW() {
      return false;
   }

   default String AboutDialog(int var1, JsonObject var2) {
      throw new IOException("cannot create slot " + (var1 + 1));
   }

   void CompanionsPanel(String var1);
}
