Feature: Shopping successful

  Scenario: Success EndToEnd Shopping
    Given open authorization page
    When user enters username standard_user and password secret_sauce
    * user clicks login button
    * user clicks addToCart button
    * user clicks shoppingCart
    * user clicks checkout button
    * user enters firstname Duke and lastname Poul and zipCode 453
    * user clicks continue button
    * user clicks finish button
    Then checkoutComplete page is displayed