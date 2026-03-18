package nomanssave;

import java.util.Comparator;

class eT implements Comparator {
   public int AboutDialog(AlienWord var1, AlienWord var2) {
      return var1.text.compareTo(var2.text);
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.AboutDialog((AlienWord)var1, (AlienWord)var2);
   }
}
