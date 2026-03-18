package nomanssave;

class fb extends fc {
   final String name;
   // $FF: synthetic field
   final JsonObject kL;

   fb(JsonObject var1, String var2, fc var3) {
      super(var1, var3);
      this.kL = var1;
      this.name = var2;
   }

   Object AboutDialog(Class var1, boolean var2) {
      JsonObject var3;
      if (this.kN == null) {
         var3 = this.kL;
      } else {
         var3 = (JsonObject)this.kN.AboutDialog(JsonObject.class, var2);
      }

      int var4 = var3.indexOf(this.name);
      if (var4 < 0) {
         if (!var2) {
            throw new fd((fd)null);
         } else {
            Object var5;
            try {
               var5 = var1.newInstance();
            } catch (IllegalAccessException | InstantiationException var7) {
               throw new RuntimeException("Unexpected error", var7);
            }

            var3.put(this.name, var5);
            return var5;
         }
      } else if (var1.isInstance(var3.values[var4])) {
         return var1.cast(var3.values[var4]);
      } else {
         throw new RuntimeException("Unexpected path");
      }
   }

   Object getValue() {
      JsonObject var1;
      if (this.kN == null) {
         var1 = this.kL;
      } else {
         var1 = (JsonObject)this.kN.AboutDialog(JsonObject.class, false);
      }

      return var1.get(this.name);
   }

   Object AboutDialog(Object var1, boolean var2) {
      JsonObject var3;
      if (this.kN == null) {
         var3 = this.kL;
      } else {
         var3 = (JsonObject)this.kN.AboutDialog(JsonObject.class, var2);
      }

      return var3.put(this.name, var1);
   }

   Object bG() {
      JsonObject var1;
      if (this.kN == null) {
         var1 = this.kL;
      } else {
         var1 = (JsonObject)this.kN.AboutDialog(JsonObject.class, false);
      }

      return var1.InMemorySaveFile(this.name);
   }

   JsonObject e(JsonObject var1) {
      JsonObject var2;
      if (this.kN == null) {
         var2 = this.kL;
      } else {
         var2 = (JsonObject)this.kN.AboutDialog(JsonObject.class, false);
      }

      Object var3 = var2.get(this.name);
      if (var3 == null) {
         var2.put(this.name, var1);
         return null;
      } else if (var3 instanceof JsonObject) {
         ((JsonObject)var3).AccountPanel(var1);
         return (JsonObject)var3;
      } else {
         throw new RuntimeException("Unsupported type: " + var3.getClass().getSimpleName());
      }
   }
}
