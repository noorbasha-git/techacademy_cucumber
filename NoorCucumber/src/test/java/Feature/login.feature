Feature: makemytrip flight search

Scenario: Search for he flights from hyd o chennai
Given launch makemytrip portal
When we enter From location HYD and To locaion as MAA
Then select departure date as and return date 
And click on search
Then verify search page is displayed as expeced
