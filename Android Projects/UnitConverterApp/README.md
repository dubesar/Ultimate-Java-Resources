# Unit Converter App

This app has distance and weight converting features.

## Highlights 

* It contains three activities ( `MainActivity` , `DistanceConverter` and `WeightConverter`)
* In `MainActivity` two cardviews are used, when clicked on these cardviews intent is called to move flow to other activities
*  In each of these activities two `spinners` are used to store units of measures (Kilogram,gram etc)
* Values of `spinner` are stored in `strings.xml`
* `ArrayAdapter` is used to get the values from resource `strings.xml` file and set those values in `spinner`
* Two inner classes (`FromSpinnerClass` and `ToSpinnerClass` ) which implements `AdapterView.OnItemSelectedListener` are created to get the selected item from the `spinner`
* When the convert button is clicked, `convertValues()` method is called where text is fetched from the field and calculation is done

## Concepts

* App converts units of two measures (distance and weight)
* In distance measure, it can convert units from `Miles-Kilometer`, `Miles-Meter`, `Miles-Centimeter`, `Kilometer-Miles`,`Kilometer-Meter`,`Kilometer-Centimeter`,`Meter-Miles`,`Meter-Kilometer`,`Meter-Centimeter`,`Centimeter-Miles`,`Centimeter-Kilometer`, and `Centimeter-Meter`
* In weight measure, it can convert units from `Kilogram-Pound`, `Kilogram-Gram`, `Pound-Kilogram`, `Pound-Gram`, `Gram-Kilogram` and `Gram-Pound`

## What next?

* Material Design will be implemented next


<img src="https://user-images.githubusercontent.com/47222685/95329476-71262380-08c0-11eb-9aa9-4efed9b93601.jpg" height=30% width="30%">