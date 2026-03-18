package nomanssave;

class cJ {
   final cJ gi;
   final int Companion;
   final String name;
   Object value;
   // $FF: synthetic field
   final JsonEditorDialog gg;

   cJ(JsonEditorDialog var1, cJ var2, int var3, String var4, Object var5) {
      this.gg = var1;
      this.gi = var2;
      this.value = var5;
      this.name = var4;
      this.Companion = var3;
   }

   boolean isLeaf() {
      if (this.value == null) {
         return true;
      } else if (this.value instanceof JsonObject) {
         return false;
      } else {
         return !(this.value instanceof JsonArray);
      }
   }

   int getChildCount() {
      if (this.value == null) {
         return 0;
      } else if (this.value instanceof JsonObject) {
         return ((JsonObject)this.value).names().size();
      } else {
         return this.value instanceof JsonArray ? ((JsonArray)this.value).size() : 0;
      }
   }

   Object UpdateCheckThread(int var1) {
      if (this.value == null) {
         throw new RuntimeException("No children for null");
      } else if (this.value instanceof JsonObject) {
         String var4 = (String)((JsonObject)this.value).names().get(var1);
         Object var3 = ((JsonObject)this.value).getValue(var4);
         return new cJ(this.gg, this, var1, var4, var3);
      } else if (this.value instanceof JsonArray) {
         Object var2 = ((JsonArray)this.value).getValue(var1);
         return new cJ(this.gg, this, var1, "[" + var1 + "]", var2);
      } else {
         throw new RuntimeException("No children for " + this.value.getClass().getName());
      }
   }

   int indexOf(Object var1) {
      return var1 instanceof cJ && ((cJ)var1).gi == this ? ((cJ)var1).Companion : -1;
   }

   public String toString() {
      return this.name;
   }

   public String getText() {
      return JsonParser.AboutDialog(this.value, 1, (var0) -> {
         return var0 < 128;
      });
   }

   public void setText(String var1) {
      if (this.gi == null) {
         this.value = JsonObject.FileComboBoxModel(var1);
         JsonEditorDialog.AboutDialogCloseListener(this.gg).d((JsonObject)this.value);
      } else {
         this.value = JsonParser.P(var1);
         if (this.gi.value instanceof JsonObject) {
            ((JsonObject)this.gi.value).AboutDialogCloseListener(this.name, this.value);
         } else if (this.gi.value instanceof JsonArray) {
            ((JsonArray)this.gi.value).AboutDialog(this.Companion, this.value);
         }
      }

      JsonEditorDialog.AboutDialog(this.gg, false);
      JsonEditorDialog.AboutDialogCloseListener(this.gg, true);
   }

   public void remove() {
      if (this.gi == null) {
         throw new RuntimeException("Cannot remove root node");
      } else {
         this.value = null;
         if (this.gi.value instanceof JsonObject) {
            ((JsonObject)this.gi.value).N(this.name);
         } else if (this.gi.value instanceof JsonArray) {
            ((JsonArray)this.gi.value).ac(this.Companion);
         }

         JsonEditorDialog.AboutDialog(this.gg, false);
         JsonEditorDialog.AboutDialogCloseListener(this.gg, true);
      }
   }
}
