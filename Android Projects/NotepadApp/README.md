# Android Notepad App

Android Notepad App is simple notepad app for android, written in Java. allows you to create, edit and delete notes locally using Room Persistence Library.

## Table of Contents
- [Features](#Features)
- [Getting Started](#getting-started)
	- [Tools Used](#tools-used)
	  - [Room Database](#Room-Database)
	  - [Executor](#Executor)
	  - [View Model and Live Data](#View-Model-and-Live-Data)
	  - [Parcelable](#Parcelable)
- [Authors](#authors)
- [Resources](#resources)

## Features
* User can create a note.
* User can edit a note.
* User can delete a note.
* When closing the browser window the notes will be stored and when the User returns, the data will be retrieved.

## Getting Started

 project structure:
```
	com.example.notepadapp
	├── AppExecutors
	├── MainViewModel
	├── Adapters
	│   └── NotesAdapter
	└── Database
	│ 	├── AppDatabase
	│ 	├── Notes
	│   └── NotesDao
	└── UI
	    ├── AddActivity
	    ├── EditActivity
	    └── MainActivity
```

### Tools Used
* Room Database.
* [Executor](https://developer.android.com/reference/java/util/concurrent/Executor.html)
* View Model and Live Data.
* Parcelable.

#### Room Database

Room provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.

Apps that handle non-trivial amounts of structured data can benefit greatly from persisting that data locally. The most common use case is to cache relevant pieces of data. That way, when the device cannot access the network, the user can still browse that content while they are offline. Any user-initiated content changes are then synced to the server after the device is back online.

##### Further documentation
For a guide on applying Room's capabilities to your app's data storage persistence solution, see the [Room](https://developer.android.com/training/data-storage/room) training guide. And the [CodeLabs Android Room with a View](https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#0).

##### Additional resources
* [7 Pro-tips for Room.](https://medium.com/androiddevelopers/7-pro-tips-for-room-fbadea4bfbd1)
* [Room Database: Getting Started.](https://www.raywenderlich.com/10892694-room-database-getting-started)
* [Android Architecture Components, Room, LiveData, and ViewModel.](https://google-developer-training.github.io/android-developer-fundamentals-course-concepts-v2/unit-4-saving-user-data/lesson-10-storing-data-with-room/10-1-c-room-livedata-viewmodel/10-1-c-room-livedata-viewmodel.html)

#### Executor
An object that executes submitted Runnable tasks. It's normally used instead of explicitly creating threads for each of a set of tasks. I have added the *AppExecutor* class and make it singleton so we always use the same instance of the class.

##### Additional resources
* [Executor docs.](https://developer.android.com/reference/java/util/concurrent/Executor)
* [MainThreadExecutor example.](https://github.com/android/architecture-components-samples/blob/b1a194c1ae267258cd002e2e1c102df7180be473/GithubBrowserSample/app/src/main/java/com/android/example/github/repository/NetworkBoundResource.java)


#### View Model and Live Data
**ViewModel** : Provides data to the UI and acts as a communication center between the Repository and the UI. Hides the backend from the UI. ViewModel instances survive device configuration changes. 
**LiveData** : A data holder class that follows the observer pattern, which means that it can be observed.

The Room persistence library supports observable queries, which return LiveData objects. Observable queries are written as part of a Database Access Object (DAO).

Room generates all the necessary code to update the LiveData object when a database is updated. The generated code runs the query asynchronously on a background thread when needed. This pattern is useful for keeping the data displayed in a UI in sync with the data stored in a database. 


##### Further documentation
You can read more about Room and DAOs in the [Room persistent library](https://developer.android.com/topic/libraries/architecture/room) guide. And to understand View Model and Live Data more, check these videos: [Android Jetpack: LiveData](https://www.youtube.com/watch?v=OMcDk2_4LSk), [Android Jetpack: ViewModel
](https://www.youtube.com/watch?v=5qlIPTDE274).
* [Live Data docs.](https://developer.android.com/topic/libraries/architecture/livedata
)
* [View Model docs.](https://developer.android.com/topic/libraries/architecture/viewmodel
)
##### Additional resources
* [LiveData & ViewModel — Making your own magic
](https://medium.com/mindorks/livedata-viewmodel-making-your-own-magic-73facb06fbb
)
* [Android Studio Guide to ViewModel & LiveData (2020 Edition)
](https://androideveryday.com/2020/03/07/android-studio-guide-to-viewmodel-livedata-2020-edition/)

#### Parcelable
A Parcelable is the Android implementation of the Java Serializable. It assumes a certain structure and way of processing it. This way a Parcelable can be processed relatively fast, compared to the standard Java serialization.

To allow your custom object to be parsed to another component they need to implement the *Parcelable* interface. Like so,
``` 
public class Notes implements Parcelable { }
```
then implement its necessary methods.

Once you have implemented it in you object, you can put it into the extra of an intent.
``` 
        intent.putExtra("notes", new Notes("1","note-title","note-body"));
```
and to access the parcel on the other side,
``` 
        Intent intent = getIntent();
        notes = intent.getParcelableExtra("notes");
```

##### Further documentation
* [Parcelable docs.](https://developer.android.com/reference/android/os/Parcelable)


## Resources
* [Android Developer Documentations](https://developer.android.com/docs)
* [Codelabs](https://codelabs.developers.google.com/?cat=Android)
* [Developer Guides](https://developer.android.com/guide)