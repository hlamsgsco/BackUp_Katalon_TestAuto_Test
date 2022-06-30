Feature: Creation of User - Cancel

  Scenario Outline: User can see user management on the LHS menu
    Given I am on <Mediabox Starpack>
    When I login as suser
    And I see the settings in the menu
    And I click on the menu > Settings
    Then I see the user management in the menu

    Examples: 
      | Mediabox Starpack                                                                         |
      | http://mdb-release.diadeis.lan/Mediabox-independence/?MBI_datasource=RELTESTAUTO_STARPACK |

  Scenario Outline: User can get access to creation user page
    Given I see the <usermanagement>
    When I click on user management button
    And I click on Create user button
    Then I see the user creation page

    Examples: 
      | usermanagement                       |
      | User is on user user management page |
