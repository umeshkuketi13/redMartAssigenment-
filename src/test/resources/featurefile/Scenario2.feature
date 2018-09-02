
@tag
Feature: product cart 
  I want to use this template for my feature file

  @tag1
  Scenario: Add new product in cart and chekout sucessuflly 
    Given Lunch the brower 
    When user click on sign in link
    And enter email address as "User1@yahoo.com"
    And enter password as "password"
    And click on sign in button
    And search the iteam MarketPlace and add to cart
    And search the iteam On sale and add to cart
    And go to the cart and remove second iteam from cart
    And  click on checkout 
    And edit the address 
    Then log out from browser

 