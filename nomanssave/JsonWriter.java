package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

public class JsonWriter implements Closeable {
   public static final int kP = 2;
   public static final int kQ = 8;
   private static final byte[] le = "null".getBytes();
   private static final byte[] lf = "true".getBytes();
   private static final byte[] lg = "false".getBytes();
   private final OutputStream lh;
   private final int flags;

   public static byte[] j(Object var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      Throwable var2 = null;
      Object var3 = null;

      try {
         JsonWriter var4 = new JsonWriter(var1, 0);

         try {
            var4.k(var0);
         } finally {
            if (var4 != null) {
               var4.close();
            }

         }
      } catch (Throwable var10) {
         if (var2 == null) {
            var2 = var10;
         } else if (var2 != var10) {
            var2.addSuppressed(var10);
         }

         throw var2;
      }

      return var1.toByteArray();
   }

   public static byte[] g(JsonObject var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      Throwable var2 = null;
      Object var3 = null;

      try {
         JsonWriter var4 = new JsonWriter(var1, 0);

         try {
            var4.h(var0);
         } finally {
            if (var4 != null) {
               var4.close();
            }

         }
      } catch (Throwable var10) {
         if (var2 == null) {
            var2 = var10;
         } else if (var2 != var10) {
            var2.addSuppressed(var10);
         }

         throw var2;
      }

      return var1.toByteArray();
   }

   public static byte[] toBytes(JsonArray var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      Throwable var2 = null;
      Object var3 = null;

      try {
         JsonWriter var4 = new JsonWriter(var1, 0);

         try {
            var4.writeJsonArray(var0);
         } finally {
            if (var4 != null) {
               var4.close();
            }

         }
      } catch (Throwable var10) {
         if (var2 == null) {
            var2 = var10;
         } else if (var2 != var10) {
            var2.addSuppressed(var10);
         }

         throw var2;
      }

      return var1.toByteArray();
   }

   public JsonWriter(OutputStream var1) {
      this(var1, 0);
   }

   public JsonWriter(OutputStream var1, int var2) {
      this.lh = var1;
      this.flags = var2;
   }

   public void k(Object var1) {
      if (var1 == null) {
         this.lh.write(le);
      } else if (var1.equals(Boolean.TRUE)) {
         this.lh.write(lf);
      } else if (var1.equals(Boolean.FALSE)) {
         this.lh.write(lg);
      } else if (var1 instanceof String) {
         this.writeString((String)var1);
      } else if (var1 instanceof fg) {
         this.writeToken((fg)var1);
      } else if (var1 instanceof fk) {
         this.writeJsonObject((JsonObject)var1, ((fk)var1).li);
      } else if (var1 instanceof JsonObject) {
         this.AboutDialog((JsonObject)((JsonObject)var1), (eC)null);
      } else if (var1 instanceof JsonArray) {
         this.AboutDialog((JsonArray)((JsonArray)var1), (eC)null);
      } else {
         if (!(var1 instanceof Number)) {
            throw new IOException("Cannot write value");
         }

         this.writeNumber((Number)var1);
      }

   }

   private void writeValue(Object var1, eC var2) {
      if (var1 == null) {
         this.lh.write(le);
      } else if (var1.equals(Boolean.TRUE)) {
         this.lh.write(lf);
      } else if (var1.equals(Boolean.FALSE)) {
         this.lh.write(lg);
      } else if (var1 instanceof String) {
         this.writeString((String)var1);
      } else if (var1 instanceof fg) {
         this.writeToken((fg)var1);
      } else if (var1 instanceof JsonObject) {
         this.writeJsonObject((JsonObject)var1, var2);
      } else if (var1 instanceof JsonArray) {
         this.writeJsonArrayInternal((JsonArray)var1, var2);
      } else {
         if (!(var1 instanceof Number)) {
            throw new IOException("Cannot write value");
         }

         this.writeNumber((Number)var1);
      }

   }

   private void writeString(String var1) {
      this.lh.write(JsonParser.O(var1).getBytes(StandardCharsets.UTF_8));
   }

   private void writeToken(fg var1) {
      this.lh.write(34);
      byte[] var5;
      int var4 = (var5 = var1.toByteArray()).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         byte var2 = var5[var3];
         int var6 = var2 & 255;
         if (var6 == 13) {
            this.lh.write("\\r".getBytes(StandardCharsets.UTF_8));
         } else if (var6 == 10) {
            this.lh.write("\\n".getBytes(StandardCharsets.UTF_8));
         } else if (var6 == 9) {
            this.lh.write("\\t".getBytes(StandardCharsets.UTF_8));
         } else if (var6 == 12) {
            this.lh.write("\\f".getBytes(StandardCharsets.UTF_8));
         } else if (var6 == 8) {
            this.lh.write("\\b".getBytes(StandardCharsets.UTF_8));
         } else if (var6 == 34) {
            this.lh.write("\\\"".getBytes(StandardCharsets.UTF_8));
         } else if (var6 == 92) {
            this.lh.write("\\\\".getBytes(StandardCharsets.UTF_8));
         } else if (var6 >= 32) {
            this.lh.write(var6);
         } else {
            StringBuffer var7 = new StringBuffer();
            var7.append("\\u00");
            var7.append("0123456789ABCDEFabcdef".charAt(var6 >> 4 & 15));
            var7.append("0123456789ABCDEFabcdef".charAt(var6 & 15));
            this.lh.write(var7.toString().getBytes(StandardCharsets.UTF_8));
         }
      }

      this.lh.write(34);
   }

   public void h(JsonObject var1) {
      this.writeJsonObject(var1, var1 instanceof fk ? ((fk)var1).li : null);
   }

   private void writeJsonObject(JsonObject var1, eC var2) {
      this.lh.write(123);
      if (var1.length > 0) {
         for(int var3 = 0; var3 < var1.length; ++var3) {
            if (var3 > 0) {
               this.lh.write(44);
            }

            this.writeString(var2 == null ? var1.names[var3] : var2.r(var1.names[var3]));
            this.lh.write(58);
            this.writeValue(var1.values[var3], var2);
         }
      }

      this.lh.write(125);
   }

   public void writeJsonArray(JsonArray var1) {
      this.writeJsonArrayInternal((JsonArray)var1, (eC)null);
   }

   private void writeJsonArrayInternal(JsonArray var1, eC var2) {
      this.lh.write(91);
      if (var1.length > 0) {
         for(int var3 = 0; var3 < var1.length; ++var3) {
            if (var3 > 0) {
               this.lh.write(44);
            }

            this.writeValue(var1.values[var3], var2);
         }
      }

      this.lh.write(93);
   }

   private void writeNumber(Number var1) {
      if (var1 instanceof BigDecimal) {
         this.lh.write(((BigDecimal)var1).toString().replace('E', 'e').getBytes(StandardCharsets.UTF_8));
      } else {
         this.lh.write(var1.toString().getBytes(StandardCharsets.UTF_8));
      }

   }

   public void close() {
      try {
         if ((this.flags & 2) != 0) {
            this.lh.write(0);
         }
      } finally {
         if ((this.flags & 8) == 0) {
            this.lh.close();
         }

      }

   }
}
