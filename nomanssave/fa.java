package nomanssave;

public class fa {
   final JsonObject kM = new JsonObject();

   public fa d(String var1, Object var2) {
      if (var1 == null) {
         throw new NullPointerException();
      } else if (!JsonObject.bF().matcher(var1).matches()) {
         throw new RuntimeException("Invalid name: " + var1);
      } else if (var2 != null && !JsonParser.AboutDialog(var2.getClass())) {
         throw new RuntimeException("Unsupported type: " + var2.getClass().getSimpleName());
      } else {
         this.kM.AboutDialog(var1, var2);
         return this;
      }
   }

   public JsonObject bH() {
      return this.kM;
   }
}
