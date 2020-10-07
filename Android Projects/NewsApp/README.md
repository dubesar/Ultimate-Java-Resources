# News App

A simple news app where you can show news dynamically, more news automatic loaded when you scroll down. When you click one of news, then web browser automatically open and load the news url.

# Screenshots

<img src="https://i.imgur.com/h1gbUNj.png" width="200" /> <img src="https://i.imgur.com/Wpf5pQe.png" width="200" />

# Concepts Used

- MVVM (Model-View-View Model) Architecture
- Recycler View
- Material Card View
- Coordinator Layout
- Frame Layout
- AppBar Layout and Material Toolbar
- Pagination Android
- Passing url into web browser

# Resources Used

- **View Model**

```
implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"
```

[Read the documentation](https://developer.android.com/topic/libraries/architecture/viewmodel)

- **Material Design**

```
implementation "com.google.android.material:material:1.2.1"
```

[Read the documentation](https://github.com/material-components/material-components-android/blob/master/docs/getting-started.md)
and you can see all available component in Material Design [here](https://material.io/develop/android)

- **Glide**

```
implementation "com.github.bumptech.glide:glide:4.11.0"
annotationProcessor "com.github.bumptech.glide:compiler:4.11.0"
```

[Read the documentation](https://github.com/bumptech/glide)

- **RX Java**

```
implementation "io.reactivex.rxjava3:rxjava:3.0.6"
```

[Read the documentation](https://github.com/ReactiveX/RxJava)

- **Rx Android**

```
implementation "io.reactivex.rxjava3:rxandroid:3.0.0"
```

[Read the documentation](https://github.com/ReactiveX/RxAndroid)

- **Retrofit 2**

```
implementation "com.squareup.retrofit2:converter-gson:2.9.0"
implementation "com.squareup.retrofit2:retrofit:2.9.0"
implementation "com.squareup.retrofit2:adapter-rxjava3:2.9.0"
```

[Read the documentation](https://square.github.io/retrofit/)

- **Jake Warthon Date Time**

```
implementation "com.jakewharton.threetenabp:threetenabp:1.2.4"
```

[Read the documentation](https://github.com/JakeWharton/ThreeTenABP)

- **Pagination Android**

```
implementation "androidx.paging:paging-runtime:2.1.2"
```

[Read the documentation](https://developer.android.com/topic/libraries/architecture/paging)

# Improvement

- UI can be improved
- Add feature search specific news
- Add feature filter news per category, country, pupolarity, etc
