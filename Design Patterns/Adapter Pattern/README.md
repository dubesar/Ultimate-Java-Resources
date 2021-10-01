### Adapter Pattern

### Introduction

Adapter pattern works as a bridge between two incompatible interfaces. This type of design pattern comes under structural pattern as this pattern combines the capability of two independent interfaces.

### Advantages

- The code is reusable and flexible.
- Clean code — because the client/context does not use a different interface in each concrete class and can use polymorphism to swap between different adapters.

### Disadvantages

- Cannot override methods in Adaptee.
- Cannot reuse Adapter with subclasses of Target.
- Adapter and Adaptee are different objects (Need to maintain relation between Adaptee and his Adapter).

### Programming

- Here, we have a MediaPlayer interface and a concrete class AudioPlayer implementing the MediaPlayer interface. AudioPlayer can play mp3 format audio files by default.

- We are having another interface AdvancedMediaPlayer and concrete classes implementing the AdvancedMediaPlayer interface. These classes can play vlc and mp4 format files.

- We want to make AudioPlayer to play other formats as well. To attain this, we have created an adapter class MediaAdapter which implements the MediaPlayer interface and uses AdvancedMediaPlayer objects to play the required format.

- AudioPlayer uses the adapter class MediaAdapter passing it the desired audio type without knowing the actual class which can play the desired format. AdapterPattern, our demo class will use AudioPlayer class to play various formats.