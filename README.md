# utf8-resources

Java Extension mechanism to load resource bundles as UTF-8 files.
                                                                
## Usage

This maven project generates a jar when included as a Java Extension in the JavaVM Runtime will load resource bundles as UTF-8.
By default it will load as UTF-8 all bundles that start with `resources`. (e.g. `resources.ApplicationResources`).
The default value can be overridden defining the system property `utf8.resources.base.names` as a comma separated list of baseName prefixes (e.g `-Dutf8.resources.base.names=resources,contents`)
will load all bundles that start with `resources` or `contents` as `UTF-8` encoded files.

### Building

1. `mvn clean package`

### Running Java using this extension

### With Java

`java -jar -Djava.ext.dirs=$JAVA_HOME/jre/lib/ext:$PATH_TO_JAR_LOCATION sample-app.jar`

### With Maven

`export MAVEN_OPTS="$MAVEN_OPTS -Djava.ext.dirs=$JAVA_HOME/jre/lib/ext:$PATH_TO_JAR_LOCATION"`