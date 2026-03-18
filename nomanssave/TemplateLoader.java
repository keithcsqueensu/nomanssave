package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TemplateLoader {
   private static Map rR = new HashMap();

   public static JsonObject loadTemplate(String var0) {
      JsonObject var1 = null;
      if (rR.containsKey(var0)) {
         var1 = (JsonObject)rR.get(var0);
      } else {
         InputStream var2 = Application.class.getResourceAsStream("templates/" + var0 + ".json");
         if (var2 != null) {
            try {
               byte[] var3 = hk.g(var2);
               var1 = BinaryReader.AboutDialogCloseListener(var3);
            } catch (IOException var4) {
               Logger.AboutDialog("Cannot load template: " + var0, var4);
            }
         }

         rR.put(var0, var1);
      }

      return var1 == null ? null : var1.MilestonesPanel();
   }
}
