package nomanssave;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class fL implements SaveFile {
   final int mb;
   final File mc;
   final String mu;
   final String md;
   final GameMode be;
   final String mv;
   final String description;
   // $FF: synthetic field
   final SteamSaveLocation mt;

   fL(SteamSaveLocation var1, String var2, int var3) {
      this.mt = var1;
      this.mb = var3;
      this.mc = new File(AppSettings.cG, var2);
      ZipFile var4 = new ZipFile(this.mc);

      try {
         ZipEntry var5 = var4.getEntry("saveinfo.txt");
         if (var5 == null) {
            throw new IOException("Invalid backup file");
         }

         Properties var6 = new Properties();
         var6.load(var4.getInputStream(var5));
         this.mu = var6.getProperty("ManifestFile");
         this.md = var6.getProperty("StorageFile");
         if (this.mu == null || this.md == null) {
            throw new IOException("Invalid backup file");
         }

         String var7 = var6.getProperty("GameMode");
         this.be = var7 == null ? null : GameMode.valueOf(var7);
         this.mv = var6.getProperty("SaveName");
         this.description = var6.getProperty("Description");
      } catch (NumberFormatException var11) {
         throw new IOException("Invalid backup file");
      } finally {
         var4.close();
      }

   }

   public GameMode L() {
      return this.be;
   }

   public String K() {
      return this.mc.getName();
   }

   public long lastModified() {
      return this.mc.lastModified();
   }

   public String getName() {
      return this.mv;
   }

   public String getDescription() {
      return this.description;
   }

   public JsonObject M() {
      // $FF: Couldn't be decompiled
   }

   public String writeToFile(JsonObject var1) {
      Logger.info("Writing new save file...");
      String var2;
      if (SteamSaveLocation.access$getSaveFiles(this.mt)[this.mb] != null) {
         var2 = SteamSaveLocation.access$getSaveFiles(this.mt)[this.mb].writeToFile(var1);
      } else {
         SteamSaveLocation.access$getSaveFiles(this.mt)[this.mb] = new fM(this.mt, this.mb, var1);
         var2 = SteamSaveLocation.access$getSaveFiles(this.mt)[this.mb].filename;
      }

      Logger.info("Finished.");
      return var2;
   }

   public String toString() {
      return this.mc.getName();
   }
}
