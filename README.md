# Business Rule Engine

Steps to run 
prerequisites install docker

# Run postgresql database
````
docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres -p 5432:5432
````

Steps 
1. Checkout the code from Github
2. open it inside intellij
3. start the project inside intellij or through CMD
4. Use postman collection shared to create rules
   5. condition example "amount::eq::5", Kindly note that the supported checks for now is Long comparing, this can be enhanced later to 
      include string check and more, we can introduce also type into this string ```"amount::str::eq::5"```
   6. action example ```"action":"direction::set::shmal"``` more actions can be added currently support ```set ``` later we can add 
      ``inc`` or ``multiply`` and handle this


# Enhancements 
1. String parsing and Reflection used on Condition and Action can be enhanced for higher performance
