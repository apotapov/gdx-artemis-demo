This is a demo environment for the [gdx-artemis](https://github.com/apotapov/gdx-artemis) project.

For the explanation of the demo see [gdx-artemis Wiki](https://github.com/apotapov/gdx-artemis/wiki/Quick-tutorial).

This project contains appropriate Eclipse project files and launch configuration. Both
can be imported into Eclipse to run and debug the demo.

# Quick Demo

Simple demonstration of how artemis works in an libgdx game.

# Event Demo

Simple demonstration of event passing in artemis.

# Instructions
```
git clone git@github.com:apotapov/gdx-artemis.git
git clone git@github.com:apotapov/gdx-artemis-demo.git
cd gdx-artemis
mvn install
cd ../gdx-artemis-demo
mvn install -Pdesktop
mvn antrun:run -Pdesktop
```
