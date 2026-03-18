package nomanssave;

import java.util.Comparator;

class es implements Comparator {
   public int AboutDialog(er var1, er var2) {
      return var1.name.compareTo(var2.name);
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.AboutDialog((er)var1, (er)var2);
   }
}
