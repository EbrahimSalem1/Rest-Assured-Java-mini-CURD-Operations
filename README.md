<h1># Reqres Automated Tests </h1> 
<p>using API Rest-Assured with java OOP and TestNg</p> 
<p> You Can Runs all APIs Test Cases from file  API.xlm </p>


<h2>#Test Case 1: GET method with List of users </h2>

1. use RequestSpecification class
2. use Response to get url 'https://reqres.in/api/users?page=2'
3. use ResponseBody class to getBody Response
4. use Assertion to Verify Response Body contains correct Response Body for users is successfully
4. Print Response if you want see it


<h2>#Test Case 2: POST method for Creating a new user </h2>

1. use JSONOBJECT class to put JsonBody request
2. use RequestSpecification class and use Response to get url 'https://reqres.in/api/users'
3.  use ResponseBody to getBody Response
4. use Verify extract response Body to Response Body is successfully
5. Print Response if you want see it


<h2>Test Case 3: PUT method for updating an existing user</h2>

1. use JSONOBJECT class to put JsonBody request
2. use RequestSpecification class and use Response to get url 'https://reqres.in/api/users/2'
3. use ResponseBody class to getBody Response
4. use Verify extract response Body to Update Response Body is successfully
5. Print Response if you want see it

