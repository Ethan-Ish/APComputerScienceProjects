class InventoryItem implements Comparable<InventoryItem>
{
 private String name;
 private int uniqueItemID;
 
 public InventoryItem(String name, int uniqueItemID)
 {
     this.name = name;
     this.uniqueItemID = uniqueItemID;
 }
 
 public String toString()
 {
     return name + ", " + Integer.toString(uniqueItemID);
 }
 
 public String getName()
 {
     String returnString = new String(name);
     return returnString; // Safety first!
 }
 
 public Integer getID()
 {
     return uniqueItemID;
 }
 
 public void setName(String input)
 {
     String newName = new String(input);
     name = input;
 }
 
 public void setID(int ID)
 {
     uniqueItemID = ID;
 }
 
 public int compareTo(InventoryItem other) {
     return Integer.compare(uniqueItemID, other.getID());
 }
 
}