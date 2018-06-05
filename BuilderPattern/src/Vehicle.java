import java.util.ArrayList;
import java.util.List;

public class Vehicle {

	private List<Item> items = new ArrayList<Item>();	

	   public void addItem(Item item){
	      items.add(item);
	   }

	   public float getCost(){
	      float cost = 0.0f;
	      
	      for (Item item : items) {
	         cost += item.price();
	      }		
	      return cost;
	   }

	   public void showItems(){
	   
	      for (Item item : items) {
	         System.out.print("Item : " + item.name());
	         if(item.name() != "BMW") {
	        	 System.out.print(", Model : " + item.product().bikeModel());
	         }else {
	        	 System.out.print(", Model : " + item.product().carModel());
	         }
	         System.out.println(", Price : $" + item.price());
	      }		
	   }
	
}
