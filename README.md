
# Carousel View


An easy to use Library which provides a Carousel View to the given list of Images on a Transparent Activity. The User needs to submit the list of images only and this Library provides a Carousel View with different features.  

![1](https://github.com/shaykhshaya/CarouselViewPager2/assets/119520622/f961d3e0-b68b-4117-99e4-4cf93b32e237)
![2](https://github.com/shaykhshaya/CarouselViewPager2/assets/119520622/62896769-5f4a-411b-ab34-9becd5e8463d)
![3](https://github.com/shaykhshaya/CarouselViewPager2/assets/119520622/0c822de0-afa5-4e08-84ab-505a7dc971e1)












## Features:

- Corner Radius
- Corner Family, **cut or rounded**
- Image Auto Scroll, **true or false**
- Slide Time Interval
- Handle Clicks
- Horizontal Margin among Images
- Off Screen Item Visibility
- Off Screen Item Alpha, **0.0f to 1.0f**














## Usage:

**A. Gradle Dependency**:

```kotlin
allprojects {
    repositories {
          maven { url 'https://jitpack.io' }
    }
}
```
```kotlin
dependencies {
     implementation 'com.github.shaykhshaya:CarouselViewPager2:v0.1'
}
```

**B. The Configuration is created using the Builder Pattern *in Kotlin***:


```kotlin
Carousel.with(this)
    .list(imageList) //imageList -> Your Image List
    .timeInterval(xxxxL)  //xxxxL -> Time Interval of auto scroll images in milisec.
    .cornerRadius(xx)  //xx -> Corner Radius of each images
    .cornerFamily(x)  //0-> ROUNDED, 1-> CUT
    .onItemCLick{}
    .start()

```

**C. Handling Clicks**:


```kotlin
Carousel.with(this)
    .list(imageList) 
    .timeInterval(5000L) 
    .onItemCLick {

        //User gets the whole Image Object.

    }  
    .start()

```

 



## Customization:

- Customize the **CORNER RADIUS**:
```kotlin
  Carousel.with(this)
        .list(imageList)
        .cornerRadiusTopLeft(20)
        .cornerRadiusBottomRight(20)
        .start()
```

- Customize the **CORNER FAMILY**, **0 -> ROUNDED, 1 -> CUT**

```kotlin
  Carousel.with(this)
        .list(imageList)
        .cornerRadiusTopLeft(20)
        .cornerFamilyTopLeft(0)
        .cornerRadiusBottomRight(20)
        .cornerFamilyBottomRight(1)
        .start()
```

- Customize **TIME INTERVAL**:

```kotlin
 Carousel.with(this)
        .list(imageList)
        .timeInterval(5000L) //time interval is given in Milliseconds.
        .start()
```

- Customize **AUTO SCROLL**:

```kotlin
  Carousel.with(this)
        .list(imageList)
        .autoScroll(false) // false-> Auto Scroll OFF, true -> Auto Scroll ON.
        .start()
```

- Customize the visibility of **OFF SCREEN SIDE IMAGES**:

```kotlin
  Carousel.with(this)
        .list(imageList)
        .offScreenItemVisibiliy(R.dimen.your_dimension)
        .start()
```

- Customize the opacity (alpha) of **OFF SCREEN SIDE IMAGES**:

```kotlin
  Carousel.with(this)
        .list(imageList)
        .alpha(0.7)
        .start()
```





    
                         
## Authors

[shaykhshaya@Fliptree](https://www.linkedin.com/in/mohd-shaya-837b98265/)

