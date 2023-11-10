Feature: Menu Section on HomePage
 
 
 Scenario: Logo should displayed on Home Page.
  Given User nevigate to homepage
 Then logo should be visible on page
  
  Scenario: Page get refreshed when user clicks on logo
  Given User nevigate to homepage
  When user clicks on logo
  Then home page should get refreshed
  And user clicks on home menu
  Then home page should get refreshed
  
  Scenario: Blog page should display when clicked on Blog Menu
  Given User nevigate to homepage
  When user clicks on Blog menu
  Then blog page should display
 
  Scenario: Promotions page should display when clicked on Promotions Menu
  Given User nevigate to homepage
  When user clicks on Promotions menu
  Then Promotions page should display
   
  
  Scenario: Cart page should display when clicked on cart Menu
  Given User nevigate to homepage
  When user clicks on cart menu
  Then Cart page should display.
  
  Scenario: when user clicks on checkout menu and cart is not empty ,checkout page should display.
  Given User nevigate to homepage
  When user clicks on checkout menu
  And cart is not empty 
  Then user should get checkout page.
  
 Scenario: when user clicks on checkout menu and cart is empty , cart page should display with proper message.
  Given User nevigate to homepage
  When user clicks on checkout menu
  And cart is empty 
  Then user should get cart page with proper waring message "Checkout is not available".
  
   Scenario: Getting ToolTip when mouse hover on Cart Symbol
  Given User nevigate to homepage
  When user hover on cart symbol
  Then "View your shopping cart" should display as a tool tip
  
  Scenario: If there are no items in cart then it should display nothing when hover on cart symbol
  Given User nevigate to homepage
  When user hover on cart symbol
  And cart is empty 
  Then no mini cart view displayed. 
  
  Scenario: If there are no items in cart then it should display "No products in the cart." when hover on cart symbol
  Given User nevigate to homepage
  When user hover on cart symbol
  And cart is empty 
  Then "No products in the cart." should display as popup.
  
  Scenario: If cart contains an item then it should display mini cart overview when hover on cart symbol
  Given User nevigate to homepage
  When user hover on cart symbol
  And cart is not empty
  Then mini cart view should displayed.
  
  
  Scenario: Dropdown option should be displayed on hempage for sorting products.
  Given User nevigate to homepage
  Then Dropdown option should display to sort product.
  
  Scenario: showing options #Outline: List of options
  Given User nevigate to homepage
  When user clicks on dropdown
  Then Dropdown should display 'Sort by price: low to high'
 
  
  
 Scenario: User should get order by option page 
   Given User nevigate to homepage
  When user clicks on dropdown
  And select any option
  Then user should get page with sorted products.
  
  
  Scenario: User should get order by option page with low to high price 
  Given User nevigate to homepage
  When user select 'Sort by price: low to high' from dropdown
  Then products should displayed in sorted order: low to high price
  
  
   Scenario: User should get order by option page with high to low price 
   Given User nevigate to homepage
  When user select 'Sort by price: high to low' from dropdown
  Then products should displayed in sorted order: high to low price
  
  
  
  
  
  
  
 
  
  
  
  