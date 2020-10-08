# Random Number Generator Application

This project is good to start with Android Development. This project consists of basic concepts used to start with Android:
1. Intent:- An Intent is a messaging object you can use to request an action from another app component. Although intents facilitate communication between components in several ways, there are three fundamental use cases:
  - Starting an activity :- An Activity represents a single screen in an app. You can start a new instance of an Activity by passing an Intent to startActivity(). The Intent describes the activity to start and carries any necessary data.
    If you want to receive a result from the activity when it finishes, call startActivityForResult(). Your activity receives the result as a separate Intent object in your activity's onActivityResult() callback. For more information, see the Activities guide.
  - Starting a service :- A Service is a component that performs operations in the background without a user interface. With Android 5.0 (API level 21) and later, you can start a service with JobScheduler. For more information about JobScheduler, see its API-reference documentation.
  - Delivering a broadcast :- A broadcast is a message that any app can receive. The system delivers various broadcasts for system events, such as when the system boots up or the device starts charging. You can deliver a broadcast to other apps by passing an Intent to sendBroadcast() or sendOrderedBroadcast().
2. Button


![](https://github.com/avinash14022002/Java-A-Z/blob/master/Android%20Projects/RandomNumberApplication/Screenshot%202020-10-05%20132848.jpg)

## Concepts used
  - Creation of activity
  - creation of XML File
  - Updating Manifest File
  - Intent
  
## Documentation and Resources used
  - https://developer.android.com/docs?authuser=1
## Future Aspects of the app
  - Convert the value to floating value
  - Make UI better
