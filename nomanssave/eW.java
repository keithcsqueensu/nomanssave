package nomanssave;

public class eW {
   final JsonArray kE = new JsonArray();

   public eW h(Object var1) {
      if (var1 != null && !JsonParser.AboutDialog(var1.getClass())) {
         throw new RuntimeException("Unsupported type: " + var1.getClass().getSimpleName());
      } else {
         this.kE.e(var1);
         return this;
      }
   }

   public JsonArray bC() {
      return this.kE;
   }
}
