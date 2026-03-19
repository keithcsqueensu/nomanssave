package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class gV {
   private static double[] readCoords(JsonObject var0, String var1) {
      JsonArray var2 = var0.d(var1);
      if (var2.size() != 3) {
         throw new RuntimeException("Invalid " + var1 + " coordinates");
      } else {
         return new double[]{var2.aa(0), var2.aa(1), var2.aa(2)};
      }
   }

   private static void writeCoords(JsonObject var0, String var1, double[] var2) {
      var0.AboutDialogCloseListener(var1, (Object)(new JsonArray(new Object[]{new Double(Double.isNaN(var2[0]) ? 0.0D : var2[0]), new Double(Double.isNaN(var2[1]) ? 0.0D : var2[1]), new Double(Double.isNaN(var2[2]) ? 0.0D : var2[2])})));
   }

   public static boolean InMemorySaveFile(JsonObject var0) {
      return moveObject(var0, "^BUILDSIGNAL");
   }

   public static boolean moveObject(JsonObject var0, String var1) {
      JsonArray var2 = var0.d("Objects");
      JsonObject var3 = null;
      JsonObject var4 = null;

      for(int var5 = 0; var5 < var2.size(); ++var5) {
         JsonObject var6 = var2.V(var5);
         if ("^BASE_FLAG".equals(var6.getValueAsString("ObjectID"))) {
            if (var3 != null) {
               Logger.warn("  multiple base computers found");
               return false;
            }

            var3 = var6;
         } else if (var1.equals(var6.getValueAsString("ObjectID"))) {
            if (var4 != null) {
               Logger.warn("  multiple " + var1 + " objects found");
               return false;
            }

            var4 = var6;
         }
      }

      if (var3 == null) {
         Logger.warn("  no base computer found");
         return false;
      } else if (var4 == null) {
         Logger.warn("  no " + var1 + " object found");
         return false;
      } else {
         transferPosition(var0, var3, var4);
         return true;
      }
   }

   public static List ValidatedTextField(JsonObject var0) {
      ArrayList var1 = new ArrayList();
      boolean var2 = false;
      JsonArray var3 = var0.d("Objects");

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         JsonObject var5 = var3.V(var4);
         String var6 = var5.getValueAsString("ObjectID");
         if ("^BASE_FLAG".equals(var5.getValueAsString("ObjectID"))) {
            var2 = true;
         } else if ("^BUILDSIGNAL".equals(var6)) {
            var1.add(var5);
         } else if ("^BP_ANALYSER".equals(var6)) {
            var1.add(var5);
         } else if ("^BUILDBEACON".equals(var6)) {
            var1.add(var5);
         }
      }

      return (List)(var2 ? var1 : Collections.emptyList());
   }

   public static boolean swapObject(JsonObject var0, JsonObject var1) {
      JsonArray var2 = var0.d("Objects");
      boolean var3 = false;
      JsonObject var4 = null;

      for(int var5 = 0; var5 < var2.size(); ++var5) {
         JsonObject var6 = var2.V(var5);
         if ("^BASE_FLAG".equals(var6.getValueAsString("ObjectID"))) {
            if (var4 != null) {
               Logger.warn("  multiple base computers found");
               return false;
            }

            var4 = var6;
         } else if (var6 == var1) {
            var3 = true;
         }
      }

      if (var4 == null) {
         Logger.warn("  no base computer found");
         return false;
      } else if (!var3) {
         Logger.warn("  replacement object found");
         return false;
      } else {
         transferPosition(var0, var4, var1);
         return true;
      }
   }

   private static void transferPosition(JsonObject var0, JsonObject var1, JsonObject var2) {
      double[] var3 = readCoords(var0, "Position");
      double[] var4 = readCoords(var0, "Forward");
      double[] var5 = readCoords(var2, "Position");
      CoordinateTransform var6 = new CoordinateTransform(var3, var4);
      double[] var7 = var6.AccountPanel(var5);
      var7[0] += var3[0];
      var7[1] += var3[1];
      var7[2] += var3[2];
      writeCoords(var0, "Position", var7);
      var7 = readCoords(var1, "At");
      double[] var8 = readCoords(var2, "At");
      writeCoords(var1, "At", var8);
      writeCoords(var2, "At", var7);
      var7 = new double[]{-var5[0], -var5[1], -var5[2]};
      writeCoords(var2, "Position", var7);
      JsonArray var9 = var0.d("Objects");

      for(int var10 = 0; var10 < var9.size(); ++var10) {
         JsonObject var11 = var9.V(var10);
         if (var11 != var1 && var11 != var2) {
            var7 = readCoords(var11, "Position");
            var7[0] -= var5[0];
            var7[1] -= var5[1];
            var7[2] -= var5[2];
            writeCoords(var11, "Position", var7);
         }
      }

   }
}
