package nomanssave;

public interface SaveFile {
   String K();

   GameMode L();

   JsonObject M();

   String writeToFile(JsonObject var1);

   long lastModified();

   default String getName() {
      return null;
   }

   default String getDescription() {
      return null;
   }
}
