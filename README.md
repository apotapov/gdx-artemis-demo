This is a demo environment for the [gdx-artemis](https://github.com/apotapov/gdx-artemis) project.

This project contains appropriate Eclipse project files and launch configuration. Both
can be imported into Eclipse to run and debug the demo.

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
