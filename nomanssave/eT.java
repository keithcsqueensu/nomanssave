package nomanssave;

import java.util.Comparator;

class eT implements Comparator {
   public int compare(AlienWord var1, AlienWord var2) {
      return var1.text.compareTo(var2.text);
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.compare((AlienWord)var1, (AlienWord)var2);
   }
}
