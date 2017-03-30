# CrewView
This repo contains my Android app submission for the Slack coding exercise. The app displays a list of users retrieved from `https://slack.com/api/users.list`. Clicking on a user will navigate to a detail page about that particular user. Be sure to configure the API key as outlined below, or the project will not build.

### Configure the API Key
I haven't pushed the API key used by this project, so you will need to configure it before the project will build. To do so, add a file named `config.gradle` with the following contents to the same folder as the root `build.gradle` file (keep the double quotes).
```
ext {
  apiKey="API_KEY_HERE"
}
```

### Libraries I used
1. [Android support libs](https://developer.android.com/topic/libraries/support-library/index.html) - I frequently use the support libs to get backward compatibility for newer Android features like `RecyclerView` and Shared Element Transitions, but I don't get to use `CoordinatorLayout` too often. I knew the user detail page would be a good place to play with it.
2. [Dagger 2](https://github.com/google/dagger) - Dagger 2 is Google's fork of Square's well-known dependency injection library, Dagger. Even though its usage in this project was probably overkill, it simplifies my usage of my Retrofit interface so that it can easily be swapped out for mocking, different endpoints, etc.
3. [Retrofit 2](https://github.com/square/retrofit) - Retrofit 2 is awesome for HTTP API communication. I typically use the GSON converter for request/response serialization. And for this project, I was able to try out the Rx Call adapter, which streams server responses to an Rx Observable.
4. [RxAndroid](https://github.com/ReactiveX/RxAndroid) - I used RxAndroid in conjunction with Retrofit 2 to observe API response streams
5. [Retrolambda Plugin](https://github.com/evant/gradle-retrolambda) - I use this gradle plugin to build code that leverages lambdas
6. [Butter Knife](https://github.com/JakeWharton/butterknife) - I love reducing boilerplate whenever I can, so I always use Butter Knife whenever I'm working on Java Android projects. Great annotations for quickly binding Views.
7. [Glide](https://github.com/bumptech/glide) - Glide abstracts away a lot of the ugliness involved in loading images. I also used a lib containing numerous Glide transformations, so I could get the rounded corner effect I wanted on the user avatar images.
8. [Calligraphy](https://github.com/chrisjenx/Calligraphy) - Calligraphy is great for using fonts that don't come pre-packaged with Android. It basically removes the pain of having to cache and properly manage fonts.
9. [Stetho](https://github.com/facebook/stetho) - I love the ease with which Stetho allows me to monitor netword traffic and storage on my Android devices. Most of the time, it's a good enough replacement for CharlesProxy.

### Future considerations
1. Network error handling
2. I would have liked to use Android's `Palette` library to change the user detail screen toolbar color based on the use image.
3. Put more time into the user detail page `CoordinatorLayout` and the avatar image transition. Perhaps, add a transition for the user's name.
4. Learn more about the backend I worked with to clean up some client-side issues that can arise while consuming it. Mostly relating to which fields are required and which aren't
5. UI Testing with Espresso
6. Add actions to user detail page, i.e. call, email , send message, open in Slack
