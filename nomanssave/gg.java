package nomanssave;

public class gg {
   final JsonObject nl;
   // $FF: synthetic field
   final Base nm;

   public gg(Base var1, JsonObject var2) {
      this.nm = var1;
      this.nl = var2;
   }

   public String toString() {
      return this.nl.getValueAsString("ObjectID");
   }
}
