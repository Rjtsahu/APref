# APref
Android easy shared preferences with preference model (POJO)

## INSTALL Gradle

##### Add following line in build.config(project) repositories
`  maven {
      url  "https://dl.bintray.com/sahurjt/APref/"
  }
`
##### Add following line in build.config(app) dependencies
   `implementation 'com.sahurjt:apref:1.0.0'`
   
##### Sync your project with gradle

#### Example <a href="https://github.com/Rjtsahu/APref/blob/master/app/src/main/java/com/sahurjt/aprefdemo/MainActivity.java">Source Code</a>

## Documentation:

##### Setup init method in application class
```java
APref.init(getApplicationContext());

// with sp filename 
APref.init(getApplicationContext(),"myPref");
```
##### Create instance for you POJO class

```java
APref<PreferenceModel> mSettings = APref.getInstance(PreferenceModel.class);
 
 // accessing a value 
 int age = mSettings.object.age;
 
 // update a value
 mSettings.object.age = 5;
 
 // or update whole object
 PreferenceModel data = new PreferenceModel();
 data.age = 6;
 data.name = 'test';
 
 mSettings.object = data;
 
 // commit all changes 
 mSettings.commit();
 ```
 ##### Reset method
 ```java 
 
 // reset current object (mSettings.object) to empty object 
 mSettings.reset(true);
 
 // update the object (mSettings.object) with data present in shared preference file
 mSettings.reset(false);
 
 ```
