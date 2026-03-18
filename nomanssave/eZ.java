package nomanssave;

class eZ extends fc {
   final int index;
   // $FF: synthetic field
   final JsonObject kL;

   eZ(JsonObject var1, int var2, fc var3) {
      super(var1, var3);
      this.kL = var1;
      this.index = var2;
   }

   Object AboutDialog(Class var1, boolean var2) {
      if (this.kN == null) {
         throw new RuntimeException("Unexpected path");
      } else {
         JsonArray var3 = (JsonArray)this.kN.AboutDialog(JsonArray.class, var2);
         if (this.index >= 0 && this.index <= var3.length) {
            if (this.index == var3.length) {
               if (!var2) {
                  throw new fd((fd)null);
               } else {
                  Object var4;
                  try {
                     var4 = var1.newInstance();
                  } catch (IllegalAccessException | InstantiationException var6) {
                     throw new RuntimeException("Unexpected error", var6);
                  }

                  var3.add(var4);
                  return var4;
               }
            } else if (var1.isInstance(var3.values[this.index])) {
               return var1.cast(var3.values[this.index]);
            } else {
               throw new RuntimeException("Unexpected path");
            }
         } else {
            throw new RuntimeException("Array index out of bounds");
         }
      }
   }

   Object getValue() {
      if (this.kN == null) {
         throw new RuntimeException("Unexpected path");
      } else {
         JsonArray var1 = (JsonArray)this.kN.AboutDialog(JsonArray.class, false);
         return var1.get(this.index);
      }
   }

   Object AboutDialog(Object var1, boolean var2) {
      if (this.kN == null) {
         throw new RuntimeException("Unexpected path");
      } else {
         JsonArray var3 = (JsonArray)this.kN.AboutDialog(JsonArray.class, var2);
         if (this.index == var3.length) {
            var3.add(var1);
            return null;
         } else {
            return var3.set(this.index, var1);
         }
      }
   }

   Object bG() {
      if (this.kN == null) {
         throw new RuntimeException("Unexpected path");
      } else {
         JsonArray var1 = (JsonArray)this.kN.AboutDialog(JsonArray.class, false);
         return var1.remove(this.index);
      }
   }

   JsonObject e(JsonObject var1) {
      if (this.kN == null) {
         throw new RuntimeException("Unexpected path");
      } else {
         JsonArray var2 = (JsonArray)this.kN.AboutDialog(JsonArray.class, false);
         Object var3 = var2.get(this.index);
         if (var3 == null) {
            var2.set(this.index, var1);
            return null;
         } else if (var3 instanceof JsonObject) {
            ((JsonObject)var3).AccountPanel(var1);
            return (JsonObject)var3;
         } else {
            throw new RuntimeException("Unsupported type: " + var3.getClass().getSimpleName());
         }
      }
   }
}
