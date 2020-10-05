# COFFEE ORDERING APP

## Documentation
The app takes user name, address, number of coffees required and toppings as input and displays the order.

<img src="https://user-images.githubusercontent.com/43422407/95093780-c3433980-0746-11eb-8195-01a2303387e4.jpeg" height="400" width="200" />

Two EventListeners applied on 'Place Order' button
- onClickListener: If user simply clicks the button, a toast message appears stating order placed.

<img src="https://user-images.githubusercontent.com/43422407/95093545-87a86f80-0746-11eb-9032-8b3c8c9c4a11.jpeg" height="400" width="200" />

```
        Button b3 = (Button)findViewById(R.id.submit);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Order placed",Toast.LENGTH_SHORT).show();
            }
        });
```

- onLongClickListener: If user long clicks the button, they can see their coffee order along with the price.

<img src="https://user-images.githubusercontent.com/43422407/95095849-32219200-0749-11eb-9ab2-b41f185c7512.jpeg" height="400" width="200" />

```
            b3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String name = "Name: " + e1.getText().toString();
                .
                .
            }

        });
```


### Concepts Used
- Text View
```
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Order for Coffee"
            android:textAppearance="?android:attr/textAppearanceLarge"
            android:gravity="center"/>
```
- Linear Layouts
```
        <LinearLayout
            android:paddingTop="20dp"
            android:orientation="vertical"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" >
            .
            .
        </LinearLayout>
```
- Grid Layouts
```
    <GridLayout
        android:id="@+id/gridLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:rowCount="2"
        android:layout_below="@id/linearLayout"
        android:columnCount="2">
        .
        .
    </GridLayout>
```
- Edit Text
```
        <EditText
            android:id="@+id/name"
            android:ems="10"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
```
- CheckBox
```
        <CheckBox
            android:id="@+id/whipped_cream"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Whipped Cream" />
```
- Intents
```
        Intent i = new Intent(MainActivity.this,SecondActivity.class);

                //For Passing the Values to Second Activity
                i.putExtra("name_key", name);
```

## To run the app
Download source code and run app on your computer.

## Future Scope
- Use intents to send the order over email.
- Add data validation so that user does not input incorrect data.
- Improve UI.

## Resources
- ![Intents](https://developer.android.com/reference/android/content/Intent)
- ![Basic EventListeners](https://guides.codepath.com/android/Basic-Event-Listeners)
- ![Android Documentation](https://developer.android.com/docs)
- ![Reference App](https://www.codingconnect.net/android-application-for-layout-managers-event-listners/)
