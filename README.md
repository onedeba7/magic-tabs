# Material Button Design


[![JitPack](https://img.shields.io/badge/JitPack-1.0.0-brightgreen.svg?style=for-the-badge)](https://jitpack.io/#debacodex/matebutton)        

[![Blogger](https://img.shields.io/badge/Blogger-FF5722?style=for-the-badge&logo=blogger&logoColor=white)](https://debacodes.blogspot.com)   

[![Facebook](https://img.shields.io/badge/Facebook-1877F2?style=for-the-badge&logo=facebook&logoColor=white)](https://www.facebook.com/mr.deba.000?mibextid=ZbWKwL)


# Coming Soon Gradient Button Source Code  ❤️

## Screenshot
<img src="https://github.com/debacodex/matebutton/blob/bbf38cb723c0ee81f024c95527a17e6f74d84d02/Screenshot_20250508-120340.Mate%20Button.png"/>

## Getting Started

To start working with material button, you need to add its dependency into your `build.gradle` file:
### Dependency
```groovy
dependencies {
    implementation "com.github.debacodex: matebutton:1.0.0" //Androidx Library...
}
```

Then you need to add jitpack as your maven repository in `build.gradle`  file:

```groovy
repositories {
    google()
    jcenter()
    maven { url 'https://jitpack.io' }
}
```

## How to use

Use material button in the layout pragmatically
```JAVA
DnButton materialButton = findViewById(R.id.dnButton);
List<ButtonBackground.DrawableParams> drawableParams = new ArrayList<>();
drawableParams.add(ButtonBackground.DrawableParams.newBuilder()
    .addButtonStateType(-ButtonUtilities.ButtonStateType.ENABLED)
    .setColors(0xffe2e2e2)
    .setRadius(10)
    .setRadius(10, 10, 10, 10)
    .build());
drawableParams.add(ButtonBackground.DrawableParams.newBuilder()
    .addButtonStateType(ButtonUtilities.ButtonStateType.PRESSED)
    .setColors(0xff009688, 0xffE0F2F1, 0xff009688)
    .setRadius(10)
    .setRadius(10, 10, 10, 10)
    .setStrokeWidth(3)
    .setStrokeColor(0xff009688)
    .build());
drawableParams.add(ButtonBackground.DrawableParams.newBuilder()
    .addButtonStateType(ButtonUtilities.ButtonStateType.NONE)
    .setColors(Color.TRANSPARENT)
    .build());
materialButton.setBackgroundParamsList(drawableParams);
// or
materialButton.setBackgroundParamsList(drawableParams, ButtonBackground.RippleParams.newBuilder()
    .addButtonStateType(ButtonUtilities.ButtonStateType.PRESSED)
    .setColor(Color.WHITE)
    .build());
// or
List<ButtonBackground.RippleParams> rippleParams = new ArrayList<>();
rippleParams.add(ButtonBackground.RippleParams.newBuilder()
    .addButtonStateType(-ButtonUtilities.ButtonStateType.ENABLED)
    .setColor(Color.GRAY)
    .build());
rippleParams.add(ButtonBackground.RippleParams.newBuilder()
    .addButtonStateType(ButtonUtilities.ButtonStateType.PRESSED)
    .setColor(Color.WHITE)
    .build());
materialButton.setBackgroundParamsList(drawableParams, rippleParams);
```

Use material button in the layout via xml
```XML
<com.debashis.code.material.button.MateButton
    android:id="@+id/materialButton"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Button"
    app:cornerRadius="7dp"
    app:backgroundTint="@color/colorPrimary"
    app:cornerTopStartRadius="0dp"
    app:cornerTopEndRadius="0dp"
    app:cornerBottomEndRadius="0dp"
    app:cornerBottomStartRadius="0dp"
    app:elevation="0dp"
    app:rippleColor="?rippleColor"
    app:strokeColor="@color/black"
    app:strokeWidth="0dp"
    app:scale="1.03"
    app:useScale="true" />
    
```
# Example

### Button 1,2 Design

<img src="https://github.com/debanikita/android-material/blob/1380e800214fa65625a7d40d9798fc5b980578d7/20241004_220057.png"/>

```XML

<com.debashis.code.material.button.MateButton
    android:id="@+id/MateButton1"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:backgroundTint="#0091EA"
    app:cornerRadius="2dp"
    app:useScale="true"
    android:textColor="#FFFFFF"
    android:text="Love"/>
    
<com.debashis.code.material.button.MateButton
    android:id="@+id/MateButton2"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:drawableEnd="@drawable/ic_language_java"
    android:text="Java"
    app:backgroundTint="#0091EA"
    app:cornerRadius="2dp"
    app:useScale="true"/>
```
### Button 3,4 Design

<img src="https://github.com/debanikita/android-material/blob/2ca80fcddd1ba03379d01579882346f18208912c/20241004_220803.png"/>

```XML

<com.debashis.code.material.button.MateButton
    android:id="@+id/DnButton3"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:backgroundTint="#FF4081"
    android:drawableStart="@drawable/ic_language_python"
    app:cornerBottomStartRadius="30dp"
    app:cornerTopStartRadius="30dp"
    app:useScale="true"
    android:text="Python"
    android:layout_marginTop="@dimen/button_margin_top"/>

<com.debashis.code.material.button.MateButton
    android:id="@+id/DnButton4"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:drawableEnd="@drawable/ic_xml"
    android:text="Xml"
    app:backgroundTint="#FF4081"
    app:cornerBottomEndRadius="30dp"
    app:cornerTopEndRadius="30dp"
    app:useScale="true"
    android:layout_marginTop="@dimen/button_margin_top"/>
```
### Button 5,6 Design

<img src="https://github.com/debanikita/android-material/blob/74b509253c36c8f92da01811c9efb1989ab2e401/20241004_221257.png"/>

```XML

<com.debashis.code.material.button.MateButton
    android:id="@+id/MateButton5"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:drawableStart="@drawable/ic_github"
    app:cornerBottomStartRadius="30dp"
    app:cornerTopEndRadius="30dp"
    android:text="Github"
    app:backgroundTint="#FF1744"
    app:useScale="true"
    android:layout_marginTop="@dimen/button_margin_top"/>

<com.debashis.code.material.button.MateButton
    android:id="@+id/MateButton6"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:drawableEnd="@drawable/ic_react"
    app:cornerTopStartRadius="30dp"
    app:cornerBottomEndRadius="30dp"
    android:text="React"
    app:backgroundTint="#FF1744"
    app:useScale="true"
    android:layout_marginTop="@dimen/button_margin_top"/>
```
### Button 7,8 Design

<img src="https://github.com/debanikita/android-material/blob/143cbf549890a5d608f1cac1385cdb240ca17a73/20241004_221841.png"/>

```XML

<com.debashis.code.material.button.MateButton
        android:id="@+id/MateButton7"
        android:layout_width="wrap_content"
	android:layout_height="wrap_content"
	android:text="Debashis"
	app:backgroundTint="#00C853"
	app:cornerRadius="30dp"
	app:useScale="true"
	android:layout_marginTop="@dimen/button_margin_top"/>

<com.debashis.code.material.button.MateButton
   android:id="@+id/MateButton8"
   android:layout_width="wrap_content"
   android:layout_height="wrap_content"
   android:drawableEnd="@drawable/ic_language_html5"
   android:text="Html5"
   app:backgroundTint="#00C853"
   app:cornerRadius="30dp"
   app:useScale="true"
   android:layout_marginTop="@dimen/button_margin_top"/>
```
### Button 9,10 Design

<img src="https://github.com/debanikita/android-material/blob/b1931a8d61c031e4fecd9c5e0df108464e69396f/20241004_222405.png"/>

```XML

<com.debashis.code.material.button.MateButton
        android:id="@+id/MateButton9"
        android:layout_width="wrap_content"
	android:layout_height="wrap_content"
	app:backgroundTint="#FFFFFF"
	app:strokeWidth="2dp"
	app:strokeColor="#000000"
	app:rippleColor="@color/ripplex"
	app:cornerRadius="2dp"
	app:useScale="true"
	android:text="Do You"
	android:textColor="#000000"
	android:layout_marginTop="@dimen/button_margin_top"/>

<com.debashis.code.material.button.MateButton
    android:id="@+id/MateButton10"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:backgroundTint="#000000"
    android:drawableStart="@drawable/ic_heart"
    app:strokeWidth="2dp"
    app:cornerRadius="2dp"
    app:useScale="true"
    android:text="Me  ?"
    android:textColor="#FFFFFF"
    android:layout_marginTop="@dimen/button_margin_top"/>
```
## Author & support
This project was created by [Debashis Sabar](https://www.instagram.com/mr_deba_000) .
> You can help us to keep my open source projects up to date!
