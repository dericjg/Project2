package Project2;
import javafx.scene.control.TreeItem;


/*
  I created a new class that extends TreeItem. This allows me to bind the data
  that was previously stored in an external Item class to the tree nodes themselves.
  This way the TreeView serves as the single source of truth for the data. The primary
  reason for this, although completely unnecessary, was to provide an easy way to 
  distinguish between different nodes (Item vs Container) in order to determine which 
  context menu to show.
*/
public class ModTreeItem extends TreeItem{
 
  private String name;
  private int price;
  private int x;
  private int y;
  private int width;
  private int height;

  //constructor
  public ModTreeItem(String name, int price, int x, int y, int width, int height){
    super();
    this.setValue(name);
    this.name = name;
    this.price = price;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;

  }
  
  public String getName()
  {
      return this.name;
  }
  public void setName(String name)
  {
      this.name = name;
  }

  public int getPrice()
  {
      return this.price;
  }
  public void setPrice(int price)
  {
      this.price = price;
  }

  public int getX()
  {
      return this.x;
  }
  public void setX(int x)
  {
      this.x = x;
  }

  public int getY()
  {
      return this.y;
  }
  public void setY(int y)
  {
      this.y = y;
  }

  public int getWidth()
  {
      return this.width;
  }
  public void setWidth(int width)
  {
      this.width = width;
  }

  public int getHeight()
  {
      return this.height;
  }
  public void setHeight(int height)
  {
      this.height = height;
  }

  @Override
  public String toString(){
    return "N: " + this.name + " P: " + this.price + " X: " + this.x + " Y: " + this.y + " W: " + this.width + " H: " + this.height;
  }
}