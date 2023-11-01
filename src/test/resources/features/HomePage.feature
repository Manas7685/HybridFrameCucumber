Feature: Menu Section on HomePage
 
 
 Scenario: Logo should displayed on Home Page.
  Given User nevigate to homepage
 Then logo is visible on page
  
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
  And user clicks on home menu
  Then home page should display
  
  Scenario: Promotions page should display when clicked on Promotions Menu
  Given User nevigate to homepage
  When user clicks on Promotions menu
  Then Promotions page should display
   When user clicks on home menu
  Then home page should display
  
  Scenario: when user clicks on checkout menu and cart is not empty ,checkout page should display.
  Given User nevigate to homepage
  When user clicks on checkout menu
  And cart is not empty 
  Then user should get checkout page.
  
 
  
  Scenario: when user clicks on checkout menu and cart is empty , cart page should display with proper message.
  Given User nevigate to homepage
  When user clicks on checkout menu
  And cart is empty 
  Then user should get cart page with proper waring message.
  
   Scenario: Getting ToolTip when mouse hover on Cart Symbol
  Given User nevigate to homepage
  When user hover on cart symbol
  Then "View your shopping cart" should display as a tool tip
  
  Scenario: If there are no items in cart then it should display nothing when hover on cart symbol
  Given User nevigate to homepage
  When user hover on cart symbol
  And cart is empty 
  Then no mini cart view displayed when hover on cart symbol
  
  Scenario: If cart contains an item then it should display mini cart overview when hover on cart symbol
  Given User nevigate to homepage
  When user hover on cart symbol
  And cart contains an item 
  Then mini cart view should displayed when hover on cart symbol
  
  Scenario: If cart contains an item then it should display mini cart overview when hover on cart symbol
  					and user should be able to remove item from there
  Given User nevigate to homepage
  When user hover on cart symbol
  And cart contains an item 
  Then mini cart view should displayed when hover on cart symbol
  And user should be able to remove/delete item from the cart.
  
  
  Scenario: If cart contains an item then it should display mini cart overview when hover on cart symbol
  					and user should be able to go to cart page
  Given User nevigate to homepage
  When user hover on cart symbol
  And cart contains an item 
  Then mini cart view should displayed when hover on cart symbol
  And user should be able to go to cartpage.
  
  Scenario: If cart contains an item then it should display mini cart overview when hover on cart symbol
  					and user should be able to go to checkout page
  Given User nevigate to homepage
  When user hover on cart symbol
  And cart contains an item 
  Then mini cart view should displayed when hover on cart symbol
  And user should be able to go to checkout page.
  
   
  
  Scenario: Cart page should display when clicked on Cart Menu
  Given User nevigate to homepage
  When user clicks on cart menu
  Then cart page should display
   
  
  Scenario: Cart page should display when clicked on Cart Symbol
  Given User nevigate to homepage
  When user clicks on cart Symbol 
  Then Cart page should display
  
  
  