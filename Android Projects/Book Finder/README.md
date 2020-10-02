### Note
To run the app, download and run the code.

## Concepts Used
This is a simple app which show the book list based on a query. This is a simple app to understand. The app :-
1.  Simple UI.
2.  How to use MVVM with live mutable data.
3.  How to user retrofit library to call api with live data.
4.  How to use recyclerView with live data and api to show live change

This README also contains the approach that was followed while developing this app so that beginners can relate to it.  
## Approach
### The First Steps
As this app only show some book list along with it,s name and author, so I decided to use a single page to make the UI more responsive and simple.  
On tope of the app I used a EditText to take the query input and a ImageButton to trigger the search action. Then I used a recycler view to show the result which each element has a ImageView to show the book image, a TextView to show book name and another TextView to show the author name. The UI finally looks like the following:- 

![UI](app/src/main/res/drawable-v24/screenshot1.jpg)(app/src/main/res/drawable-v24/screenshot2.jpg)


### Fetching Data from API
Now that the UI is created, it is time for our app to fetch data from an API. To fetch book list based on query I used google book api. Next, from documentation I saw the format of the request URL. It had the following format

``https://www.googleapis.com/books/v1/volumes?q={query}``

I used Retrofit library to handle the api calling and to receive the response data I used some model class which is in the model folder. The following procedure is used to obtain book list:-
1. Used BookApi interface and HomeRepository class to call the api.
2. Then used MutableLiveData in HomeViewModel class to get data from repository. 


Also, remember to add Internet Permission in AndroidManifest.xml.

### Add Book List in Recycler View
First I have initialized the recyclerView with empty list. I have also set a ovserver to observe the chang on  MutableLiveData in HomeViewModel class. When the repository returns book list data to the HomeViewModel then it called Onchange on  MutableLiveData, then seted the book list data in BookListRecyclerViewAdapter class using setBookList() method and call the notifyDataSetChanged() the change. 



