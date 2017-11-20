# CounterView [ ![Download](https://api.bintray.com/packages/sh3lan93/Android/CounterView/images/download.svg) ](https://bintray.com/sh3lan93/Android/CounterView/_latestVersion) [![](https://jitpack.io/v/sh3lan93/CounterView.svg)](https://jitpack.io/#sh3lan93/CounterView) [![API](https://img.shields.io/badge/API-14%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=14) 

Android View that have a value that can be incremented and decremented by one.

|Screenshot|Video Demo|
|---|---|
|<img src="https://github.com/sh3lan93/CounterView/blob/master/screen1.png" width="350">| <img src="https://github.com/sh3lan93/CounterView/blob/master/lib-gif.gif" width="350">|

## Download Debug APK 
https://goo.gl/TAA7Pu

## Usage
### Adding Dependency 
Add this to ```build.gradle``` Project level 
```
allprojects {
  repositories {
    maven{
      url 'https://dl.bintray.com/sh3lan93/Android'
    }
  }
}
```

Add this to ``` build.gradle ``` Module:app

```
compile 'com.mohamed.shalan:inc-dec-view:1.0'
```

for maven usage 
```
<dependency>
  <groupId>com.mohamed.shalan</groupId>
  <artifactId>inc-dec-view</artifactId>
  <version>1.0</version>
  <type>pom</type>
</dependency>
```

### Adding The View
- XML

```xml
<com.shalan.mohamed.itemcounterview.IncDecView
        android:id="@+id/itemCounter"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:border_color="@android:color/holo_red_dark"
        app:border_width="5dp"
        app:dec_icon="@drawable/ic_remove"
        app:inc_icon="@drawable/ic_add"
        app:counterValueColor="@android:color/holo_orange_dark"
        app:inc_dec_button_color="@drawable/btn_background"
        app:startCounterValue="5"/>
```
- This is the screenshot of previous code 
<img src="https://github.com/sh3lan93/CounterView/blob/master/device-2017-11-18-215610.png" width="250">

- Java
```java
IncDecView incDecView = findViewById(R.id.itemCounter);
incDecView.setIncButtonIcon(R.drawable.ic_add);
incDecView.setDecButtonIcon(R.drawable.ic_remove);
incDecView.setBorderColor(android.R.color.darker_gray);
incDecView.setBorderWidth(R.dimen.inc_dec_counter_view_stroke_width);
incDecView.setStartCounterValue(R.string._5);
incDecView.setCounterListener(new CounterListener() {
   @Override
   public void onIncClick(String value) {
      Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
   }
   
   @Override
   public void onDecClick(String value) {
      Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
   }});
```

### Java Methods
|Method|Description|
|---|---|
|```setStartCounterValue(String startValue)```| for setting the start value of counter |
|```setStartCounterValue(@StringRes int startValue)```| for setting the start value of counter|
|```setCounterListener(CounterListener counterListener)```| for setting listener for vounter value when increment or decrement|
|```setIncButtonIcon(@DrawableRes int incButtonIcon)```| for setting the icon of increment button|
|```setDecButtonIcon(@DrawableRes int decButtonIcon)```| for setting the icon of decrement button|
|```setBorderWidth(@DimenRes int strokeWidth)```| for setting the border width of the view|
|```setBorderWidth(float value)```| for setting the border width of the view|
|```setBorderColor(@ColorRes int strokeColor)```| for setting view border color|
|```setBorderColor_(int color)```| for setting view border color|
|```String getCounterValue()```| for getting counter value|

## License

```
Copyright 2017 Mohamed Fotouh Shalan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
