
#  CalenderEvent

This is the simple library of calender, where you can set event on specific date. And this calender you can customize all section.

For this version **we are not set any off or holiday** We will add in next version. So this library is simple to use.

Sample
![Alt Text](https://github.com/mahimrocky/EventCalender/blob/master/screen.png)

Following instructions you have to follow to use Expandable Card view

# Root Gradle
```sh
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

# App Gradle:

```sh
dependencies {
	   implementation 'com.github.mahimrocky:EventCalender:v1.0.0'
	}
```

# XML Section

```sh
    <com.skyhope.eventcalenderlibrary.CalenderEvent
        android:id="@+id/calender_event"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</android.support.constraint.ConstraintLayout>
```

### By below options you can change or customize the view

| Attributes | Purpose |
| ------ | ------ |
| ```app:selector_color```|  To change Selector color|
| ```app:current_month_day_color```|  To change current month days color|
| ```app:off_month_day_colorr```|  To change off month days color|
| ```app:week_name_color```|  To change week name color (sun,mon etc)|
| ```app:month_colorn```|  To change month title color|
| ```app:next_icon```|  To change next month icon|
| ```app:previous_icon```|  To change previous month icon|
| ```app:app:calender_background```|  To change total calender background color|
| ```app:selected_day_text_color```|  To selected day text color|

### How to set event?
```sh
CalenderEvent calenderEvent = findViewById(R.id.calender_event);
Event event = new Event(calendar.getTimeInMillis(), "Test");
// to set desire day time milli second in first parameter
//or you set color for each event
Event event = new Event(calendar.getTimeInMillis(), "Test",Color.RED);
calenderEvent.addEvent(event);
```

for remove event you can call 
```sh
    calenderEvent.removeEvent(event);
```
for each item click get all date or event. Below section you will get event,time,date. ***Remember dayContainerModel.getEvent() give you null if you don`t set any event*** so check ***dayContainerModel.isHaveEvent()***
```sh
 calenderEvent.initCalderItemClickCallback(new CalenderDayClickListener() {
            @Override
            public void onGetDay(DayContainerModel dayContainerModel) {
                Log.d(TAG, dayContainerModel.getDate());
            }
        });
```
# Happy Coding
