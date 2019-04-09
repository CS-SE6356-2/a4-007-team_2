import org.junit.Test;
import static org.junit.Assert.*;

public class JUnitShoppingCartTest{

    // Test Case 1: Test that a new cart has 0 items
    @Test
    public void printNewCartSize(){

        ShoppingCart newCart = new ShoppingCart();
        System.out.println("New Shopping Cart Size = " + newCart.getItemCount());
        assertEquals(0, newCart.getItemCount());

    }

    // Test Case 2: Test that cart has 0 items after empty() method call
    @Test
    public void printEmptyCartSize(){

        ShoppingCart cart = new ShoppingCart();
        cart.empty();

        System.out.println("Empty Shopping Cart Size = " + cart.getItemCount());
        assertEquals(0, cart.getItemCount());
    }

    // Test Case 3: Test that after addItem(Product item), the number of items must be incremented
    @Test
    public void printNumberOfItems(){

        ShoppingCart cart = new ShoppingCart();
        int startSize = cart.getItemCount();
        System.out.println("Current Shopping Cart Size = " + cart.getItemCount());

        Product milk = new Product("milk", 2);
        cart.addItem(milk);
        System.out.println("Shopping Cart Size = " + cart.getItemCount());

        assertEquals(startSize+1, cart.getItemCount());
    }

    // Test Case 4: Test that after addItem(Product item), the new balance must be the sum of the previous balance plus the cost of the new product
    @Test
    public void printNewBalance(){

        ShoppingCart cart = new ShoppingCart();
        double startBalance = cart.getBalance();
        System.out.println("Current Balance = " + cart.getBalance());

        Product milk = new Product("milk", 2.0);
        cart.addItem(milk);
        System.out.println("New Balance = " + cart.getBalance());

        assertEquals(startBalance+2.0, cart.getBalance(), 0.0);
    }
      //Test Case 5: Test that after removeItem(Product item), the new cart count is decremented
        @Test
    public void printNewNumberOfItems() throws ProductNotFoundException{
      ShoppingCart cart = new ShoppingCart();
      Product milk = new Product("milk", 2.0);
      cart.addItem(milk);
      Product honey = new Product("honey", 2.0);
      cart.addItem(honey);
      int startcartcount = cart.getItemCount();
      System.out.println("Current Cart Count = " + startcartcount);
      cart.removeItem(milk);
      System.out.println("New Cart Count after Milk Removal = " + cart.getItemCount());

      assertEquals(startcartcount-1, cart.getItemCount());
    }
    
    //Test Case 6: When a product not in the cart is removed, a ProductNotFoundException must be thrown
   @Test
    public void printNewBalance) {
	
 	  try{
	      ShoppingCart cart = new ShoppingCart();
	      Product milk = new Product("milk", 2.0);
	      cart.addItem(milk);
	      Product honey = new Product("honey", 2.0);
	      cart.addItem(honey);
	      int startcartcount = cart.getItemCount();
	      System.out.println("Current Cart Count = " + startcartcount);
	      cart.removeItem(mango);
	      fail("exception not thrown");// Product was found.
	      System.out.println("New Cart Count after Milk Removal = " + cart.getItemCount());    
  	 }
   
 	   catch (ProductNotFoundExcetion e){
  	    System.out.println("Failed to remove item. Item does not exist in cart!");
  	 }
   }
    
    
}
