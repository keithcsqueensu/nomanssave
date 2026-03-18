package nomanssave;

import java.util.Arrays;
import java.util.stream.Stream;

public class JsonArray {
   private static final int kB = 10;
   private static final int kC = 10;
   int length;
   Object[] values;
   Object kD;

   public static JsonArray SlotComboBoxModel(String var0) {
      return JsonParser.R(var0);
   }

   public JsonArray() {
      this.length = 0;
      this.values = new Object[10];
   }

   public JsonArray(Object... var1) {
      this.length = var1.length;
      this.values = new Object[var1.length];

      for(int var2 = 0; var2 < this.length; ++var2) {
         if (var1[var2] != null && !JsonParser.AboutDialog(var1[var2].getClass())) {
            throw new RuntimeException("Unsupported type: " + var1[var2].getClass().getSimpleName());
         }

         this.values[var2] = var1[var2];
         JsonParser.AboutDialog((Object)var1[var2], (Object)this);
      }

   }

   void e(Object var1) {
      if (this.values.length == this.length) {
         Object[] var2 = new Object[this.length + 10];
         System.arraycopy(this.values, 0, var2, 0, this.length);
         this.values = var2;
      }

      this.values[this.length] = var1;
      JsonParser.AboutDialog((Object)var1, (Object)this);
      ++this.length;
   }

   Object U(int var1) {
      return this.values[var1];
   }

   public String bz() {
      return JsonParser.AboutDialog(this, System.lineSeparator(), true);
   }

   public String toString() {
      return JsonParser.AboutDialog((JsonArray)this, (String)null, false);
   }

   public JsonArray bA() {
      JsonArray var1 = new JsonArray();
      var1.values = new Object[this.values.length];

      for(int var2 = 0; var2 < this.length; ++var2) {
         if (this.values[var2] instanceof JsonObject) {
            var1.values[var2] = ((JsonObject)this.values[var2]).MilestonesPanel();
            JsonParser.AboutDialog((Object)var1.values[var2], (Object)var1);
         } else if (this.values[var2] instanceof JsonArray) {
            var1.values[var2] = ((JsonArray)this.values[var2]).bA();
            JsonParser.AboutDialog((Object)var1.values[var2], (Object)var1);
         } else {
            var1.values[var2] = this.values[var2];
         }
      }

      var1.length = this.length;
      return var1;
   }

   public int size() {
      return this.length;
   }

   public int indexOf(Object var1) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         for(int var2 = 0; var2 < this.length; ++var2) {
            if (var1.equals(this.values[var2])) {
               return var2;
            }
         }

         return -1;
      }
   }

   public Object get(int var1) {
      if (var1 >= 0 && var1 < this.length) {
         return this.values[var1];
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public Object set(int var1, Object var2) {
      if (var1 >= 0 && var1 < this.length) {
         if (var2 != null && !JsonParser.AboutDialog(var2.getClass())) {
            throw new RuntimeException("Unsupported type: " + var2.getClass().getSimpleName());
         } else {
            Object var3 = this.values[var1];
            JsonParser.i(var3);
            this.values[var1] = var2;
            JsonParser.AboutDialog((Object)var2, (Object)this);
            this.firePropertyChange("[" + var1 + "]", var3, var2);
            return var3;
         }
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public void add(Object var1) {
      if (var1 != null && !JsonParser.AboutDialog(var1.getClass())) {
         throw new RuntimeException("Unsupported type: " + var1.getClass().getSimpleName());
      } else {
         JsonArray var2 = new JsonArray();
         if (this.values.length == this.length) {
            var2.values = this.values;
            var2.length = this.length;
            Object[] var3 = new Object[this.length + 10];
            System.arraycopy(this.values, 0, var3, 0, this.length);
            this.values = var3;
         } else {
            var2.values = new Object[this.values.length];
            System.arraycopy(this.values, 0, var2.values, 0, this.length);
            var2.length = this.length;
         }

         this.values[this.length] = var1;
         JsonParser.AboutDialog((Object)var1, (Object)this);
         ++this.length;
         this.firePropertyChange("", var2, this);
      }
   }

   public void add(int var1, Object var2) {
      if (var1 >= 0 && var1 <= this.length) {
         if (var2 != null && !JsonParser.AboutDialog(var2.getClass())) {
            throw new RuntimeException("Unsupported type: " + var2.getClass().getSimpleName());
         } else {
            JsonArray var3 = new JsonArray();
            if (this.values.length == this.length) {
               var3.values = this.values;
               var3.length = this.length;
               Object[] var4 = new Object[this.length + 10];
               System.arraycopy(this.values, 0, var4, 0, this.length);
               this.values = var4;
            } else {
               var3.values = new Object[this.values.length];
               System.arraycopy(this.values, 0, var3.values, 0, this.length);
               var3.length = this.length;
            }

            for(int var5 = this.length; var5 > var1; ++var5) {
               this.values[var5] = this.values[var5 - 1];
            }

            this.values[var1] = var2;
            JsonParser.AboutDialog((Object)var2, (Object)this);
            ++this.length;
            this.firePropertyChange("", var3, this);
         }
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public Object remove(int var1) {
      if (var1 >= 0 && var1 < this.length) {
         JsonArray var2 = new JsonArray();
         var2.values = new Object[this.values.length];
         System.arraycopy(this.values, 0, var2.values, 0, this.length);
         var2.length = this.length;
         Object var3 = this.values[var1];
         JsonParser.i(var3);

         for(int var4 = var1; var4 < this.length - 1; ++var4) {
            this.values[var4] = this.values[var4 + 1];
         }

         --this.length;
         this.firePropertyChange("", var2, this);
         return var3;
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public void clear() {
      JsonArray var1 = new JsonArray();
      var1.values = new Object[this.values.length];
      System.arraycopy(this.values, 0, var1.values, 0, this.length);
      var1.length = this.length;

      for(int var2 = 0; var2 < this.length; ++var2) {
         JsonParser.i(this.values[var2]);
      }

      this.length = 0;
      this.firePropertyChange("", var1, this);
   }

   void AboutDialog(Object var1, String var2, Object var3, Object var4) {
      for(int var5 = 0; var5 < this.length; ++var5) {
         if (var1 == this.values[var5]) {
            this.firePropertyChange("[" + var5 + "]" + var2, var3, var4);
            return;
         }
      }

   }

   private void firePropertyChange(String var1, Object var2, Object var3) {
      if (this.kD instanceof JsonObject) {
         ((JsonObject)this.kD).AboutDialog(this, var1, var2, var3);
      }

      if (this.kD instanceof JsonArray) {
         ((JsonArray)this.kD).AboutDialog(this, var1, var2, var3);
      }

   }

   public Object getValue(int var1) {
      return this.get(var1);
   }

   public JsonObject V(int var1) {
      return (JsonObject)this.getValue(var1);
   }

   public JsonArray W(int var1) {
      return (JsonArray)this.getValue(var1);
   }

   public String CompanionsPanel(int var1) {
      Object var2 = this.getValue(var1);
      return var2 instanceof fg ? var2.toString() : (String)var2;
   }

   public int Y(int var1) {
      Object var2 = this.getValue(var1);
      return var2 == null ? 0 : ((Number)var2).intValue();
   }

   public long Z(int var1) {
      Object var2 = this.getValue(var1);
      return var2 == null ? 0L : ((Number)var2).longValue();
   }

   public double aa(int var1) {
      Object var2 = this.getValue(var1);
      return var2 == null ? 0.0D : ((Number)var2).doubleValue();
   }

   public boolean ab(int var1) {
      Object var2 = this.getValue(var1);
      return var2 == null ? false : (Boolean)var2;
   }

   public void AboutDialog(int var1, Object var2) {
      this.set(var1, var2);
   }

   public void f(Object var1) {
      this.add(var1);
   }

   public boolean hasValue(Object var1) {
      return this.indexOf(var1) >= 0;
   }

   public boolean ac(int var1) {
      this.remove(var1);
      return true;
   }

   public boolean g(Object var1) {
      int var2 = this.indexOf(var1);
      if (var2 < 0) {
         return false;
      } else {
         this.remove(var2);
         return true;
      }
   }

   public Stream bB() {
      JsonObject[] var1 = new JsonObject[this.length];
      int var2 = 0;

      for(int var3 = 0; var3 < this.length; ++var3) {
         if (this.values[var3] instanceof JsonObject) {
            var1[var2++] = (JsonObject)this.values[var3];
         }
      }

      return Arrays.stream(var1, 0, var2);
   }

   // $FF: synthetic method
   public Object clone() {
      return this.bA();
   }
}
