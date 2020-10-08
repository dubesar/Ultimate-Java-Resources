## Spin The Bottle Application
A simple spin the bottle game in Android Studio.

<img src="./img/demo.png" width="300" />

## Concept 
- We will display the bottle in an ImageView on which we set an onClickListener with the onClick xml attribute. 
- When we click this image, we start a `RotateAnimation` which ends at a random direction.
- We will get this random direction as a number with the `Random class` and it's `nextInt` method. For `pivotX` and `pivotY` will be set in the middle of the ImageView which we get by dividing `getWidth` and `getHeight` by 2. 
- With `setDuration` we set the length of the animation and with `setFillAfter(true)` we make sure that the `ImageView` ends up pointing to the direction at which the rotation ends.
- We will also set an `AnimationListener` on our animation to `lock` and `unlock` the spinning method in `onAnimationStart` and `onAnimationEnd`.

## Documentation and Resources used
- https://developer.android.com/docs?authuser=1

## Future Aspects of the app
- Landscape Orientation needs ot be handled.
- More features to be added in the future. These include :
  - Improving the UI using material design, animations, etc.
- And finally, innovation and creativity to improve this project, add more features and fixing bugs is always welcomed. :)

