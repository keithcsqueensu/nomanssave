package nomanssave;

import javax.swing.ImageIcon;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

class q implements TableModel {
   // $FF: synthetic field
   final p BasesStoragePanel;

   q(p var1) {
      this.BasesStoragePanel = var1;
   }

   public void addTableModelListener(TableModelListener var1) {
   }

   public Class getColumnClass(int var1) {
      return var1 == 0 ? ImageIcon.class : String.class;
   }

   public int getColumnCount() {
      return 4;
   }

   public String getColumnName(int var1) {
      switch(var1) {
      case 0:
         return "";
      case 1:
         return "Name";
      case 2:
         return "Category";
      case 3:
         return "ID";
      default:
         return null;
      }
   }

   public int getRowCount() {
      return p.AboutDialog(this.BasesStoragePanel) == null ? 0 : p.AboutDialog(this.BasesStoragePanel).size();
   }

   public Object getValueAt(int var1, int var2) {
      switch(var2) {
      case 0:
         return ((ItemDefinition)p.AboutDialog(this.BasesStoragePanel).get(var1)).N(3);
      case 1:
         return ((ItemDefinition)p.AboutDialog(this.BasesStoragePanel).get(var1)).getName();
      case 2:
         return ((ItemDefinition)p.AboutDialog(this.BasesStoragePanel).get(var1)).bc().toString();
      case 3:
         return ((ItemDefinition)p.AboutDialog(this.BasesStoragePanel).get(var1)).getID();
      default:
         return null;
      }
   }

   public boolean isCellEditable(int var1, int var2) {
      return false;
   }

   public void removeTableModelListener(TableModelListener var1) {
   }

   public void setValueAt(Object var1, int var2, int var3) {
   }
}
