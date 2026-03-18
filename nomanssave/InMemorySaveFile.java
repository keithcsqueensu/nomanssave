package nomanssave;

import java.io.IOException;

class InMemorySaveFile implements SaveFile {
   final String filename;
   final long FreighterPanel;
   final GameMode be;
   final JsonObject bf;
   // $FF: synthetic field
   final Application aZ;

   public InMemorySaveFile(Application var1, String var2, long var3, GameMode var5, JsonObject var6) {
      this.aZ = var1;
      this.filename = var2;
      this.FreighterPanel = var3;
      this.be = var5;
      this.bf = var6;
   }

   public String K() {
      return this.filename;
   }

   public GameMode L() {
      return this.be;
   }

   public long lastModified() {
      return this.FreighterPanel;
   }

   public JsonObject M() {
      return this.bf;
   }

   public String AboutDialogCloseListener(JsonObject var1) {
      throw new IOException("Save not supported!");
   }

   public String toString() {
      return this.filename;
   }
}
