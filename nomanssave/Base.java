package nomanssave;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Base {
   final JsonObject nj;
   // $FF: synthetic field
   final Settlement nk;

   private Base(Settlement var1, JsonObject var2) {
      this.nk = var1;
      this.nj = var2;
   }

   public String cF() {
      Object var1 = this.nj.getValue("GalacticAddress");
      if (var1 instanceof String) {
         return (String)var1;
      } else {
         return var1 instanceof Number ? "0x" + Long.toHexString(((Number)var1).longValue()) : null;
      }
   }

   public String getName() {
      return this.nj.getValueAsString("Name");
   }

   public void setName(String var1) {
      this.nj.setValueByPath("Name", (Object)var1);
   }

   public int cG() {
      return this.nj.d("Objects").size();
   }

   public JsonObject cH() {
      return this.nj;
   }

   public List cI() {
      ArrayList var1 = new ArrayList();
      Iterator var3 = gV.ValidatedTextField(this.nj).iterator();

      while(var3.hasNext()) {
         JsonObject var2 = (JsonObject)var3.next();
         var1.add(new gg(this, var2));
      }

      return var1;
   }

   public boolean matchesPosition(gg var1) {
      return gV.swapObject(this.nj, var1.nl);
   }

   public String toString() {
      return this.nj.getValueAsString("Name");
   }

   // $FF: synthetic method
   Base(Settlement var1, JsonObject var2, Base var3) {
      this(var1, var2);
   }
}
