# CounterView [ ![Download](https://api.bintray.com/packages/sh3lan93/Android/CounterView/images/download.svg) ](https://bintray.com/sh3lan93/Android/CounterView/_latestVersion)

Android View that have a value that can be incremented and decremented by one.

|Screenshot|Video Demo|
|---|---|
|<img src="https://github.com/sh3lan93/CounterView/blob/master/screen1.png" width="350">| <img src="https://github.com/sh3lan93/CounterView/blob/master/lib-gif.gif" width="350">|

## Download Debug APK 
https://goo.gl/TAA7Pu

## Usage
### Adding Dependency 
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
This is the screenshot of previous code 
<img src="https://github.com/sh3lan93/CounterView/blob/master/device-2017-11-18-215610.png" width="150">

